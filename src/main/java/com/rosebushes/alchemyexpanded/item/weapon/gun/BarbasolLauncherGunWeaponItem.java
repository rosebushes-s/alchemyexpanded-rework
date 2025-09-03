package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.rosebushes.alchemyexpanded.entity.BarbasolBombProjectileEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BarbasolLauncherGunWeaponItem extends GunWeaponItem {

    public BarbasolLauncherGunWeaponItem(Properties properties, float damage, double speed, int amount, float spread, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble) {
        super(properties, damage, speed, amount, spread, rate, ammoCap, ammoConsumption, reload, infinite, dualWield, ammo, iDouble);
    }

    @Override
    public void shoot(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount(); i++) {
            BarbasolBombProjectileEntity bomb = new BarbasolBombProjectileEntity(level, shooter);
            bomb.setWeapon(stack);

            bomb.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            bomb.setDamage(getWeaponDamage());
            bomb.setExplodeRadius(3.0F);

            level.addFreshEntity(bomb);
        }
    }
}
