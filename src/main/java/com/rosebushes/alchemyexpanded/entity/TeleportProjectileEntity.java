package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.entity.underling.BasiliskPartEntity;
import com.mraof.minestuck.util.MSParticleType;
import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import java.util.Random;

public class TeleportProjectileEntity extends ProjectileEntity {

    protected int teleportXMin;
    protected int teleportXMax;
    protected int teleportY;
    protected int teleportZMin;
    protected int teleportZMax;

    public TeleportProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.GREEN_SUN_BULLET.get(), shooter, world);
    }

    protected TeleportProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    public TeleportProjectileEntity(Level world, LivingEntity shooter, int tpXMin, int tpXMax, int tpY, int tpZMin, int tpZMax) {
        super(world, shooter);
        this.teleportXMin = tpXMin;
        this.teleportXMax = tpXMax;
        this.teleportY = tpY;
        this.teleportZMin = tpZMin;
        this.teleportZMax = tpZMax;
    }

    public TeleportProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    @SuppressWarnings("resource")
    @Override
    protected void onProjectileHitEntity(EntityHitResult result) {
        super.onProjectileHitEntity(result);

        Entity target = result.getEntity();
        Random random = new Random();
        int randomX = random.nextInt(getTeleportXMax() + 1 - getTeleportXMin()) + getTeleportXMin();
        int randomZ = random.nextInt(getTeleportZMax() + 1 - getTeleportZMin()) + getTeleportZMin();
        boolean shouldPlusOrMinusX = (random.nextInt(10 + 1 - 1)) + 1 > 5;
        boolean shouldPlusOrMinusZ = (random.nextInt(10 + 1 - 1)) + 1 > 5;

        if(!shouldPlusOrMinusX) {
            randomX = -randomX;
        }
        if(!shouldPlusOrMinusZ) {
            randomZ = -randomZ;
        }

        if(!target.level().isClientSide() && (target instanceof LivingEntity || target instanceof BasiliskPartEntity)) {
            target.setPos(target.getX() + randomX, target.getY() + getTeleportY(), target.getZ() + randomZ);
        }
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(AEItems.DUMMY_GREEN_SUN_BULLET.get());
    }

    @Override
    protected ParticleOptions getParticleTrail() {
        return ParticleTypes.COMPOSTER;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        setTeleportAmount(compoundTag.getInt("tpXMin"), compoundTag.getInt("tpXMax"), compoundTag.getInt("tpY"), compoundTag.getInt("tpZMin"), compoundTag.getInt("tpZMax"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        addTeleportTags(compoundTag);
    }

    public void setTeleportAmount(int tpXMin, int tpXMax, int tpY, int tpZMin, int tpZMax) {
        this.teleportXMin = tpXMin;
        this.teleportXMax = tpXMax;
        this.teleportY = tpY;
        this.teleportZMin = tpZMin;
        this.teleportZMax = tpZMax;
    }

    public void addTeleportTags(CompoundTag tag) {
        tag.putInt("tpXMin", teleportXMin);
        tag.putInt("tpXMax", teleportXMax);
        tag.putInt("tpY", teleportY);
        tag.putInt("tpZMin", teleportZMin);
        tag.putInt("tpZMax", teleportZMax);
    }

    public int getTeleportXMin() {
        return this.teleportXMin;
    }

    public int getTeleportXMax() {
        return this.teleportXMax;
    }

    public int getTeleportY() {
        return this.teleportY;
    }

    public int getTeleportZMin() {
        return this.teleportZMin;
    }

    public int getTeleportZMax() {
        return this.teleportZMax;
    }
}
