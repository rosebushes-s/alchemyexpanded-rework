package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.rosebushes.alchemyexpanded.entity.FlareProjectileEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FlareGunWeaponItem extends GunWeaponItem {

    public FlareGunWeaponItem(Properties properties, float damage, double speed, int amount, float spread, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble) {
        super(properties, damage, speed, amount, spread, rate, ammoCap, ammoConsumption, reload, infinite, dualWield, ammo, iDouble);
    }

    @Override
    public void shoot(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount(); i++) {
            FlareProjectileEntity flare = new FlareProjectileEntity(level, shooter);
            flare.setWeapon(stack);

            flare.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            flare.setDamage(getWeaponDamage());
            flare.setTargetFireSeconds(5);

            level.addFreshEntity(flare);
        }
    }

    @Override
    public void shootDouble(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount() + getAmount(); i++) {
            FlareProjectileEntity flare = new FlareProjectileEntity(level, shooter);
            double dualWieldBonus = Math.round((getWeaponDamage() / 10) * 2) / 2.0F;
            flare.setWeapon(stack);

            flare.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            flare.setDamage(getWeaponDamage() + dualWieldBonus);
            flare.setTargetFireSeconds(5);

            level.addFreshEntity(flare);
        }
    }
}
