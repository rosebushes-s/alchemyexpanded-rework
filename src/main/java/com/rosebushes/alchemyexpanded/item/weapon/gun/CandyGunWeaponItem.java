package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.rosebushes.alchemyexpanded.entity.CandyProjectileEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CandyGunWeaponItem extends GunWeaponItem {
    public CandyGunWeaponItem(Properties properties, float damage, double speed, int amount, float spread, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble) {
        super(properties, damage, speed, amount, spread, rate, ammoCap, ammoConsumption, reload, infinite, dualWield, ammo, iDouble);
    }

    @Override
    public void shoot(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount(); i++) {
            CandyProjectileEntity candyBullet = new CandyProjectileEntity(level, shooter);
            candyBullet.setWeapon(stack);

            candyBullet.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            candyBullet.setDamage(getWeaponDamage());

            level.addFreshEntity(candyBullet);
        }
    }

    @Override
    public void shootDouble(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount() + getAmount(); i++) {
            CandyProjectileEntity candyBullet = new CandyProjectileEntity(level, shooter);
            double dualWieldBonus = Math.round((getWeaponDamage() / 10) * 2) / 2.0F;
            candyBullet.setWeapon(stack);

            candyBullet.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            candyBullet.setDamage(getWeaponDamage() + dualWieldBonus);

            level.addFreshEntity(candyBullet);
        }
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(0.1F, 1.0F, 1.0F);
    }
}
