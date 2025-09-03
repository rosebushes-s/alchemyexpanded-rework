package com.rosebushes.alchemyexpanded.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class ExplodingProjectileEntity extends ProjectileEntity {
    protected float explodeRadius;

    public ExplodingProjectileEntity(Level world, LivingEntity shooter) {
        super(world, shooter);
    }

    public ExplodingProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    public ExplodingProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    @Override
    protected void onHit(HitResult result) {
        if (!this.level().isClientSide) {
            this.level().explode((Entity)null, result.getLocation().x, result.getLocation().y, result.getLocation().z, 3.0F, Level.ExplosionInteraction.NONE);
        }

        this.discard();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        setExplodeRadius(compoundTag.getFloat("radius"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putFloat("radius", explodeRadius);
    }

    public void setExplodeRadius(float radius) {
        this.explodeRadius = radius;
    }
}
