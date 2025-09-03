package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.mraof.minestuck.item.MSItems;
import com.rosebushes.alchemyexpanded.entity.CueballProjectileEntity;
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

public class CueballGunWeaponItem extends GunWeaponItem {

    public CueballGunWeaponItem(Properties properties, double speed, float spread, int rate, int reload, Item iDouble) {
        super(properties, 0, speed, 1, spread, rate, 1, 1, reload, false, false, MSItems.CUEBALL.get(), iDouble);
    }

    @Override
    public void shoot(Level level, Player shooter, ItemStack stack) {
        CueballProjectileEntity cueball = new CueballProjectileEntity(level, shooter);
        cueball.setWeapon(stack);

        cueball.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
        cueball.setDamage(getWeaponDamage());

        level.addFreshEntity(cueball);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(0.0F, 0.0F, 1.0F);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        double reloadTime = (double) Math.round((getReload() * 0.05) * 2) / 2.0F;
        int ammoConsumption = getAmmoConsume();
        String ammoType = getAmmoType().getDescriptionId();

        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_one").withStyle(ChatFormatting.WHITE));
        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.reload_time", new Object[]{reloadTime}).withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_consume", new Object[]{ammoConsumption}).withStyle(ChatFormatting.GRAY).append(Component.translatable(ammoType).withStyle(ChatFormatting.WHITE)));
        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_perfect").withStyle(ChatFormatting.WHITE).withStyle(ChatFormatting.BOLD)));
    }
}
