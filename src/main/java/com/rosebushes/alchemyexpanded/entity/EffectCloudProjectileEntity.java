package com.rosebushes.alchemyexpanded.entity;

import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EffectCloudProjectileEntity extends ProjectileEntity {
    protected Potion potion;
    protected int radius;
    protected int duration;
    protected int color;

    public EffectCloudProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.FLARE_PROJECTILE.get(), shooter, world);
    }

    public EffectCloudProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    protected EffectCloudProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    @Override
    protected void onHit(HitResult result) {
        if(!this.level().isClientSide()) {
            AreaEffectCloud cloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            cloud.setDuration(getDuration());
            cloud.setOwner((LivingEntity)this.getOwner());
            cloud.setRadius(getRadius());
            cloud.addEffect(new MobEffectInstance(potion.getEffects().getFirst()));
            cloud.setParticle(() -> ParticleTypes.CLOUD);

            this.level().addFreshEntity(cloud);
        }
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(AEItems.DUMMY_FLARE_BULLET.get());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("effect")) {
            this.potion = byName(compoundTag.getString("effect"));
        }
        if(compoundTag.contains("radius")) {
            this.radius = compoundTag.getInt("radius");
        }
        if(compoundTag.contains("duration")) {
            this.duration = compoundTag.getInt("duration");
        }
        if(compoundTag.contains("color")) {
            this.color = compoundTag.getInt("color");
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("effect", potion.toString());
        compoundTag.putInt("radius", getRadius());
        compoundTag.putInt("duration", getDuration());
        compoundTag.putInt("color", getColor());
    }

    public static Potion byName(String name) {
        return BuiltInRegistries.POTION.get(ResourceLocation.tryParse(name));
    }

    @Override
    protected ParticleOptions getParticleTrail() {
        return ParticleTypes.EFFECT;
    }

    public void setPotionEffect(Potion potionEffect) {
        this.potion = potionEffect;
    }

    protected Potion getPotion() {
        return this.potion;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    protected int getDuration() {
        return this.duration;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    protected int getRadius() {
        return this.radius;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }
}
