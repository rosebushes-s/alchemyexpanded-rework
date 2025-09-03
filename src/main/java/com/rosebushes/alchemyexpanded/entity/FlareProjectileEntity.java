package com.rosebushes.alchemyexpanded.entity;

import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class FlareProjectileEntity extends ProjectileEntity {
    protected int targetFireSeconds;

    public FlareProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.FLARE_PROJECTILE.get(), shooter, world);
    }

    protected FlareProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    public FlareProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    @Override
    protected void onProjectileHitEntity(EntityHitResult result) {
        super.onProjectileHitEntity(result);

        Entity target = result.getEntity();
        if(target instanceof LivingEntity) {
            target.setRemainingFireTicks(getTargetFireSeconds() * 20);
        }
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(AEItems.DUMMY_FLARE_BULLET.get());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        targetFireSeconds = compoundTag.getInt("fire_time");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("fire_time", targetFireSeconds);
    }

    public void setTargetFireSeconds(int seconds) {
        this.targetFireSeconds = seconds;
    }

    public int getTargetFireSeconds() {
        return this.targetFireSeconds;
    }
}
