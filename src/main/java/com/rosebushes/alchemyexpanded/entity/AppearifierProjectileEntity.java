package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.entity.underling.BasiliskEntity;
import com.mraof.minestuck.entity.underling.BasiliskPartEntity;
import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class AppearifierProjectileEntity extends ProjectileEntity {

    public AppearifierProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    public AppearifierProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.APPEARIFIER_PROJECTILE.get(), shooter, world);
    }

    protected AppearifierProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult raytrace) {
        if(!level().isClientSide()) {
            Entity target = raytrace.getEntity();
            Entity shooter = getOwner();
            if(target instanceof BasiliskPartEntity) {
                if(shooter != null) {
                    BasiliskEntity basilisk = ((BasiliskPartEntity)target).getParent();
                    Vec3 shooterAngle = shooter.getLookAngle();
                    boolean shooterLookX = shooterAngle.x >= 0;
                    boolean shooterLookZ = shooterAngle.z >= 0;
                    double addX = shooterLookX ? 2.0 : -2.0;
                    double addZ = shooterLookZ ? 2.0 : -2.0;

                    basilisk.setPos(shooter.getX() + addX, shooter.getY(), shooter.getZ() + addZ);
                }
            }
            else if(target instanceof LivingEntity) {
                if(shooter != null) {
                    Vec3 shooterAngle = shooter.getLookAngle();
                    boolean shooterLookX = shooterAngle.x >= 0;
                    boolean shooterLookZ = shooterAngle.z >= 0;
                    double addX = shooterLookX ? 2.0 : -2.0;
                    double addZ = shooterLookZ ? 2.0 : -2.0;
                    Vec3 eyePos = target.getEyePosition(1.0F);

                    this.sendEffectPacket((ServerLevel) shooter.level(), eyePos, shooterAngle);
                    target.setPos(shooter.getX() + addX, shooter.getY(), shooter.getZ() + addZ);
                }
            }
        }
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(AEItems.DUMMY_CROCKERCORP_BULLET.get());
    }
}
