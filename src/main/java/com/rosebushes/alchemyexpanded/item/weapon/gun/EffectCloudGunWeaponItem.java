package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.rosebushes.alchemyexpanded.entity.EffectCloudProjectileEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class EffectCloudGunWeaponItem extends GunWeaponItem {
    protected int cloudDuration;
    protected int cloudRadius;
    protected int cloudColor;
    protected Potion cloudEffect;

    public EffectCloudGunWeaponItem(Properties properties, float damage, double speed, int amount, float spread, int rate, int ammoCap, int ammoConsumption, int reload, int cDuraton, int cRadius, int cColor, Potion cEffect, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble) {
        super(properties, damage, speed, amount, spread, rate, ammoCap, ammoConsumption, reload, infinite, dualWield, ammo, iDouble);
        this.cloudDuration = cDuraton;
        this.cloudRadius = cRadius;
        this.cloudColor = cColor;
        this.cloudEffect = cEffect;
    }

    @Override
    public void shoot(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount(); i++) {
            EffectCloudProjectileEntity cloudBullet = new EffectCloudProjectileEntity(level, shooter);
            cloudBullet.setWeapon(stack);
            cloudBullet.setDuration(getCloudDuration());
            cloudBullet.setRadius(getCloudRadius());
            cloudBullet.setColor(getCloudColor());
            cloudBullet.setPotionEffect(getCloudEffect());

            cloudBullet.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            cloudBullet.setDamage(getWeaponDamage());

            level.addFreshEntity(cloudBullet);
        }
    }

    @Override
    public void shootDouble(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount() + getAmount(); i++) {
            EffectCloudProjectileEntity cloudBullet = new EffectCloudProjectileEntity(level, shooter);
            double dualWieldBonus = Math.round((getWeaponDamage() / 10) * 2) / 2.0F;
            cloudBullet.setWeapon(stack);
            cloudBullet.setDuration(getCloudDuration());
            cloudBullet.setRadius(getCloudRadius());
            cloudBullet.setColor(getCloudColor());
            cloudBullet.setPotionEffect(getCloudEffect());

            cloudBullet.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            cloudBullet.setDamage(getWeaponDamage() + dualWieldBonus);

            level.addFreshEntity(cloudBullet);
        }
    }

    public int getCloudDuration() {
        return this.cloudDuration;
    }

    public int getCloudRadius() {
        return this.cloudRadius;
    }

    public int getCloudColor() {
        return this.cloudColor;
    }

    public Potion getCloudEffect() {
        return this.cloudEffect;
    }
}
