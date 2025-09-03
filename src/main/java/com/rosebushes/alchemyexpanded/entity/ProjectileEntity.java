package com.rosebushes.alchemyexpanded.entity;

import com.rosebushes.alchemyexpanded.item.AEItems;
import com.rosebushes.alchemyexpanded.network.BulletEffectPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.neoforged.neoforge.network.PacketDistributor;

//code snippets taken from GunsWithoutRoses by Lykrast under MIT license.
public class ProjectileEntity extends Projectile implements ItemSupplier {

    private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(ProjectileEntity.class, EntityDataSerializers.ITEM_STACK);
    protected double damage;
    private ItemStack item = ItemStack.EMPTY;
    protected int sinceSpawned;

    public ProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    public ProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.BASIC_BULLET.get(), shooter, world);
    }

    protected ProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        this(type, shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ(), world);
        setOwner(shooter);
        setRot(shooter.getYRot(), shooter.getXRot());
    }

    protected ProjectileEntity(EntityType<? extends ProjectileEntity> type, double x, double y, double z, Level world) {
        this(type, world);
        moveTo(x, y, z, getYRot(), getXRot());
        reapplyPosition();
    }

    //passthrough
    protected HitResult getHitResult() {
        Vec3 pos = position();
        Vec3 vel = getDeltaMovement();
        Vec3 nextpos = pos.add(vel);
        HitResult hitresult = level().clip(new ClipContext(pos, nextpos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));

        if (!noPhysics && hitresult.getType() != HitResult.Type.MISS) nextpos = hitresult.getLocation();

        HitResult hitresult1 = ProjectileUtil.getEntityHitResult(level(), this, pos, nextpos, getBoundingBox().expandTowards(vel).inflate(1), this::canHitEntity);
        if (hitresult1 != null) {
            hitresult = hitresult1;
        }

        return hitresult;
    }

    private static final double STOP_TRESHOLD = 0.01;

    @SuppressWarnings({ "deprecation", "resource" })
    @Override
    public void tick() {
        //Using a thing I save so that bullets don't get clogged up on chunk borders
        sinceSpawned++;
        if (sinceSpawned > 100 || getDeltaMovement().lengthSqr() < STOP_TRESHOLD) {
            remove(RemovalReason.KILLED);
        }

        onProjectileTick();

        Entity entity = this.getOwner();
        if (level().isClientSide || (entity == null || !entity.isRemoved()) && level().hasChunkAt(blockPosition())) {
            super.tick();

            processCollision();

            checkInsideBlocks();
            Vec3 vec3 = getDeltaMovement();
            double nextx = getX() + vec3.x;
            double nexty = getY() + vec3.y;
            double nextz = getZ() + vec3.z;
            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            if (isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    level().addParticle(ParticleTypes.BUBBLE, nextx - vec3.x * 0.25, nexty - vec3.y * 0.25, nextz - vec3.z * 0.25, vec3.x, vec3.y, vec3.z);
                }

                setDeltaMovement(vec3.scale(waterInertia()));
            }
            level().addParticle(getParticleTrail(), nextx, nexty + 0.5, nextz, 0, 0, 0);
            setPos(nextx, nexty, nextz);
        }
        else {
            discard();
        }
    }

    protected void processCollision() {
        HitResult hitresult = getHitResult();
        if (hitresult.getType() != HitResult.Type.MISS && !net.neoforged.neoforge.event.EventHooks.onProjectileImpact(this, hitresult)) {
            onHit(hitresult);
        }
    }

    protected double waterInertia() {
        //same as fireballs but now it can be changed yay
        return 0.8;
    }

    //used for doing stuff on tick, override
    protected void onProjectileTick() {

    }

    @SuppressWarnings("resource")
    @Override
    protected void onHitEntity(EntityHitResult raytrace) {
        //note: that super is currently empty
        super.onHitEntity(raytrace);
        onProjectileHitEntity(raytrace);

        if (!level().isClientSide) {
            Entity target = raytrace.getEntity();
            Entity shooter = getOwner();

            if (isOnFire()) target.setRemainingFireTicks(100);
            int lastHurtResistant = target.invulnerableTime;
            target.invulnerableTime = 0;
            double hitdamage = this.damage;
            float adjustedDamage = this.sinceSpawned > 20 ? (float) hitdamage * 0.5F : (float) hitdamage;
            if(this.sinceSpawned > 30) {
                adjustedDamage = (float) hitdamage * 0.25F;
            }
            boolean damaged = shooter == null
                    ? target.hurt(AEDamage.gun(level().registryAccess()), adjustedDamage)
                    : target.hurt(AEDamage.gun(level().registryAccess(), this, shooter), adjustedDamage);
            if(shooter != null) {
                Vec3 eyePos = target.getEyePosition(1.0F);
                Vec3 lookVec = shooter.getLookAngle();

                this.sendEffectPacket((ServerLevel)shooter.level(), eyePos, lookVec);
            }
            if (!damaged) target.invulnerableTime = lastHurtResistant;
        }
    }

    protected void sendEffectPacket(ServerLevel level, Vec3 pos, Vec3 lookVec) {
        PacketDistributor.sendToPlayersNear(level, null, pos.x, pos.y, pos.z, 64.0, new BulletEffectPacket(pos, lookVec));
    }

    @SuppressWarnings("resource")
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        //Don't disappear on blocks if we're set to noclipping
        if (!level().isClientSide && (!noPhysics || result.getType() != HitResult.Type.BLOCK) && shouldDespawnOnHit(result)) remove(RemovalReason.KILLED);
    }

    //do extra stuff on hit in case you want to keep normal damage functionality
    protected void onProjectileHitEntity(EntityHitResult result) {

    }

    protected boolean shouldDespawnOnHit(HitResult result) {
        return true;
    }

    @SuppressWarnings("resource")
    @Override
    protected void onHitBlock(BlockHitResult result) {
        //noclipping bullets don't interact with blocks
        if (noPhysics) return;
        super.onHitBlock(result);
    }

    public void setWeapon(ItemStack weapon) {
        this.item = weapon;
    }

    public ItemStack getWeapon() {
        return item;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        this.getEntityData().set(DATA_ITEM_STACK, ItemStack.EMPTY);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        sinceSpawned = compoundTag.getInt("tsf");
        damage = compoundTag.getDouble("damage");
        setWeapon(ItemStack.parse(Minecraft.getInstance().player.level().registryAccess(), compoundTag.get("Item")).get());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putDouble("damage", damage);
        compoundTag.putInt("tsf", sinceSpawned);
        ItemStack stack = getWeapon();
        if(!stack.isEmpty()) compoundTag.put("Item", stack.save(Minecraft.getInstance().player.level().registryAccess()));
    }

    @Override
    //Same as normal but ignores player velocity
    public void shootFromRotation(Entity shooter, float xRot, float yRot, float upArc, float speed, float spread) {
        float f = -Mth.sin(yRot * Mth.DEG_TO_RAD) * Mth.cos(xRot * Mth.DEG_TO_RAD);
        float f1 = -Mth.sin((xRot + upArc) * Mth.DEG_TO_RAD);
        float f2 = Mth.cos(yRot * Mth.DEG_TO_RAD) * Mth.cos(xRot * Mth.DEG_TO_RAD);
        shoot((double) f, (double) f1, (double) f2, speed, spread);
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double sqrDistance) {
        double d0 = getBoundingBox().getSize() * 4;
        if (Double.isNaN(d0)) d0 = 4;
        d0 *= 64;
        return sqrDistance < d0 * d0;
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(AEItems.DUMMY_BULLET.get());
    }

    protected ParticleOptions getParticleTrail() {
        return ParticleTypes.SMOKE;
    }
}
