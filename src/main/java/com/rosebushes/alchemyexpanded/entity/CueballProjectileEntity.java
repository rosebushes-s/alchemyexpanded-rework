package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.entity.underling.BasiliskEntity;
import com.mraof.minestuck.entity.underling.BasiliskPartEntity;
import com.mraof.minestuck.item.MSItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class CueballProjectileEntity extends ProjectileEntity {

    public CueballProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    public CueballProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    public CueballProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.CUEBALL_BULLET.get(), shooter, world);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if(!level().isClientSide()) {
            Entity target = result.getEntity();
            Entity shooter = getOwner();

            if(target instanceof BasiliskPartEntity) {
                BasiliskEntity basilisk = ((BasiliskPartEntity) target).getParent();
                boolean killed = shooter == null ? basilisk.hurt(AEDamage.cueballGun(level().registryAccess()), basilisk.getHealth() + 50.0F) : basilisk.hurt((AEDamage.cueballGun(level().registryAccess(), shooter)), basilisk.getHealth() + 50.0F);
            }
            else if ((target instanceof LivingEntity) && !(target instanceof ServerPlayer)) {
                boolean killed = shooter == null ? target.hurt(AEDamage.cueballGun(level().registryAccess()), ((LivingEntity) target).getHealth() + 50.0F) : target.hurt((AEDamage.cueballGun(level().registryAccess(), shooter)), (((LivingEntity) target).getHealth() + 50.0F));
                if(shooter != null) {
                    Vec3 eyePos = target.getEyePosition(1.0F);
                    Vec3 lookVec = shooter.getLookAngle();

                    this.sendEffectPacket((ServerLevel) shooter.level(), eyePos, lookVec);
                }
            }
            if(shooter != null && target instanceof ServerPlayer) {
                shooter.sendSystemMessage(Component.translatable("info.alchemyexpanded.cueball_gunshot_player"));
            }
        }
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(MSItems.CUEBALL.get());
    }
}
