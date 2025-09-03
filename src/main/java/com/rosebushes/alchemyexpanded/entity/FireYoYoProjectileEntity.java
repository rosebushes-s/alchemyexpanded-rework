package com.rosebushes.alchemyexpanded.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class FireYoYoProjectileEntity extends YoYoProjectileEntity {
    public FireYoYoProjectileEntity(EntityType<? extends FireYoYoProjectileEntity> type, Level level) {
        super(type, level);
    }

    public FireYoYoProjectileEntity(EntityType<? extends FireYoYoProjectileEntity> type, LivingEntity livingEntityIn, Level level, float damage, int stringLength, int maxTick) {
        super(type, livingEntityIn, level, damage, stringLength, maxTick);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (result.getType() == HitResult.Type.ENTITY) {
            Entity entity = ((EntityHitResult) result).getEntity();

            if(entity instanceof LivingEntity livingEntity) {
                livingEntity.setRemainingFireTicks(100);
            }
        }
    }
}
