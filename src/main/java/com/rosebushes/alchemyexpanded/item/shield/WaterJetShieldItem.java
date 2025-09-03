package com.rosebushes.alchemyexpanded.item.shield;

import com.rosebushes.alchemyexpanded.item.AEItemTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WaterJetShieldItem extends AEShieldItem {
    private static final MobEffectInstance slowFallEffect = new MobEffectInstance(MobEffects.SLOW_FALLING, 20);
    public WaterJetShieldItem(Properties properties, double attackBonus, double armorRating, double movementSpeedDebuff) {
        super(AEItemTypes.SHIELD_TOOL_TYPE, properties, attackBonus, armorRating, movementSpeedDebuff);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player) {
            if(!player.getUseItem().isEmpty() && player.getUseItem().getItem() instanceof WaterJetShieldItem) {
                if(player.isInWater()) {
                    player.setDeltaMovement(player.getLookAngle().scale(0.5));
                }
                if(player.isFallFlying()) {
                    player.setDeltaMovement(player.getLookAngle().scale(0.75));
                    player.addEffect(new MobEffectInstance(slowFallEffect));
                }
            }
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }
}
