package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.rosebushes.alchemyexpanded.entity.AppearifierProjectileEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class AppearifierGunWeaponItem extends GunWeaponItem {
    public AppearifierGunWeaponItem(Properties properties, double speed, float spread, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, Item ammo, @Nullable Item iDouble) {
        super(properties, 0, speed, 1, spread, rate, ammoCap, ammoConsumption, reload, infinite, false, ammo, iDouble);
    }

    @Override
    public void shoot(Level level, Player shooter, ItemStack stack) {
        AppearifierProjectileEntity appear = new AppearifierProjectileEntity(level, shooter);
        appear.setWeapon(stack);

        appear.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
        appear.setDamage(getWeaponDamage());

        level.addFreshEntity(appear);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(0.0F, 1.0F, 1.0F);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int rate = getRate();
        double reloadTime = (double) Math.round((getReload() * 0.05) * 2) / 2.0F;
        int ammoCap = getAmmo();
        int ammoConsumption = getAmmoConsume();
        double timeFireClip = ((rate * 0.05) * ammoCap);
        double ratePerMinuteWithReload = 60 / (timeFireClip + reloadTime);
        double roundsPerMinuteFired =  ratePerMinuteWithReload * ammoCap;
        String ammoType = getAmmoType().getDescriptionId();

        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.reload_time", new Object[]{reloadTime}).withStyle(ChatFormatting.GRAY));
        if(!getInfinite()) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_max", new Object[]{ammoCap}).withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_consume", new Object[]{ammoConsumption}).withStyle(ChatFormatting.GRAY).append(Component.translatable(ammoType).withStyle(ChatFormatting.GRAY)));
        }
        else tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.infinite").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD));
        if(roundsPerMinuteFired <= 50) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_very_slow").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD)));
        }
        else if(roundsPerMinuteFired <= 100) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_slow").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD)));
        }
        else if(roundsPerMinuteFired <= 150) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_medium").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.BOLD)));
        }
        else {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_fast").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD)));
        }
    }
}
