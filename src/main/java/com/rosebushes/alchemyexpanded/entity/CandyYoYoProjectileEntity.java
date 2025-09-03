package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.entity.underling.BasiliskEntity;
import com.mraof.minestuck.entity.underling.BasiliskPartEntity;
import com.mraof.minestuck.entity.underling.UnderlingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class CandyYoYoProjectileEntity extends YoYoProjectileEntity {
    public CandyYoYoProjectileEntity(EntityType<? extends CandyYoYoProjectileEntity> type, Level level) {
        super(type, level);
    }

    public CandyYoYoProjectileEntity(EntityType<? extends CandyYoYoProjectileEntity> type, LivingEntity livingEntityIn, Level level, float damage, int stringLength, int maxTick) {
        super(type, livingEntityIn, level, damage, stringLength, maxTick);
    }

    @Override
    protected void onHit(HitResult result) {
        if (result.getType() == HitResult.Type.ENTITY) {
            Entity entity = ((EntityHitResult)result).getEntity();

            if(entity instanceof UnderlingEntity || entity instanceof BasiliskPartEntity) {
                if(entity instanceof BasiliskPartEntity basiliskPart) {
                    BasiliskEntity basilisk = basiliskPart.getParent();

                    basilisk.dropCandy = true;
                }
                else {
                    UnderlingEntity underling = (UnderlingEntity) entity;

                    underling.dropCandy = true;
                }
            }
        }
        super.onHit(result);
    }
}
