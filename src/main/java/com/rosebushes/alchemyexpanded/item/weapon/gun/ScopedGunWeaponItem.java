package com.rosebushes.alchemyexpanded.item.weapon.gun;

import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class ScopedGunWeaponItem extends GunWeaponItem {
    public ScopedGunWeaponItem(Properties properties, float damage, double speed, int amount, float spread, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble) {
        super(properties, damage, speed, amount, spread, rate, ammoCap, ammoConsumption, reload, infinite, dualWield, ammo, iDouble);
    }
}
