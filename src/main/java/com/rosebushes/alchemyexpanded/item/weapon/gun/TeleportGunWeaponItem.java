package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.rosebushes.alchemyexpanded.entity.TeleportProjectileEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TeleportGunWeaponItem extends GunWeaponItem {

    protected int teleportXMin;
    protected int teleportXMax;
    protected int teleportY;
    protected int teleportZMin;
    protected int teleportZMax;

    public TeleportGunWeaponItem(Properties properties, float damage, double speed, int amount, float spread, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble, int tpXMin, int tpXMax, int tpY, int tpZMin, int tpZMax) {
        super(properties, damage, speed, amount, spread, rate, ammoCap, ammoConsumption, reload, infinite, dualWield, ammo, iDouble);
        this.teleportXMin = tpXMin;
        this.teleportXMax = tpXMax;
        this.teleportY = tpY;
        this.teleportZMin = tpZMin;
        this.teleportZMax = tpZMax;
    }

    @Override
    public void shoot(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount(); i++) {
            TeleportProjectileEntity bullet = new TeleportProjectileEntity(level, shooter);
            bullet.setWeapon(stack);
            bullet.setTeleportAmount(getTeleportXMin(), getTeleportXMax(), getTeleportY(), getTeleportZMin(), getTeleportZMax());

            bullet.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            bullet.setDamage(getWeaponDamage());

            level.addFreshEntity(bullet);
        }
    }

    @Override
    public void shootDouble(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount() + getAmount(); i++) {
            TeleportProjectileEntity bullet = new TeleportProjectileEntity(level, shooter);
            double dualWieldBonus = Math.round((getWeaponDamage() / 10) * 2) / 2.0F;
            bullet.setWeapon(stack);
            bullet.setTeleportAmount(getTeleportXMin(), getTeleportXMax(), getTeleportY(), getTeleportZMin(), getTeleportZMax());

            bullet.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            bullet.setDamage(getWeaponDamage() + dualWieldBonus);

            level.addFreshEntity(bullet);
        }
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(0.2F, 1.0F, 1.0F);
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
