package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.entity.underling.UnderlingEntity;
import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class YoYoProjectileEntity extends ThrowableItemProjectile {
    private float realDamage;
    private int hitCheck = 0;
    private int stringLength;
    private static final EntityDataAccessor<Integer> LIFESPAN;

    public YoYoProjectileEntity(EntityType<? extends YoYoProjectileEntity> type, Level level) {
        super(type, level);
    }

    public YoYoProjectileEntity(EntityType<? extends YoYoProjectileEntity> type, LivingEntity livingEntityIn, Level level, float damage, int stringLength, int maxTick) {
        super(type, livingEntityIn, level);
        this.realDamage = damage;
        this.stringLength = stringLength;
        this.setLifespan(maxTick);
    }

    @Override
    protected void onHit(HitResult result) {
        if (result.getType() == HitResult.Type.ENTITY) {
            if (!this.level().isClientSide) {
                Entity entity = ((EntityHitResult)result).getEntity();
                if(this.hitCheck > 2) {
                    if (entity instanceof UnderlingEntity) {
                        entity.hurt(this.damageSources().thrown(this, this.getOwner()), realDamage * 1.5F);
                    } else if (entity != this.getOwner()) {
                        entity.hurt(this.damageSources().thrown(this, this.getOwner()), realDamage);
                    } else {
                        this.discard();
                    }
                }
                else {
                    if (entity instanceof UnderlingEntity) {
                        entity.hurt(this.damageSources().thrown(this, this.getOwner()), realDamage * 1.5F);
                    } else if (entity != this.getOwner()) {
                        entity.hurt(this.damageSources().thrown(this, this.getOwner()), realDamage);
                    }
                    this.hitCheck++;
                    this.realDamage = realDamage * 0.5F;
                }
            }
        } else if (result.getType() == HitResult.Type.BLOCK) {
            this.discard();
        }
    }

    @Override
    public void tick() {
        this.level().addParticle(ParticleTypes.END_ROD, getX(), getY(), getZ(), 0, 0, 0);
        Vec3 pos = this.position();
        this.xOld = pos.x;
        this.yOld = pos.y;
        this.zOld = pos.z;

        if (this.isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().scale(1.2));
        } else {
            this.setDeltaMovement(this.getDeltaMovement().scale(1.005));
        }
        if(this.tickCount >= this.stringLength) {
            this.setDeltaMovement(this.getDeltaMovement().scale(0.0));
        }
        if(this.tickCount >= this.getLifespan()) {
            this.discard();
        }

        super.tick();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        this.entityData.set(LIFESPAN, 20);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.realDamage = compound.getFloat("weapon_damage");
        this.stringLength = compound.getInt("string_length");
        this.hitCheck = compound.getInt("hit_check");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("weapon_damage", this.realDamage);
        compound.putInt("string_length", this.stringLength);
        compound.putInt("hit_check", this.hitCheck);
    }

    @Override
    protected Item getDefaultItem() {
        return AEItems.YOYO.get();
    }

    public int getLifespan() {
        return (Integer)this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int v) {
        this.entityData.set(LIFESPAN, v);
    }

    static {
        LIFESPAN = SynchedEntityData.defineId(YoYoProjectileEntity.class, EntityDataSerializers.INT);
    }
}
