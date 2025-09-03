package com.rosebushes.alchemyexpanded.item.foods;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EffectHealingFoodItem extends EffectFoodItem {
    private final float healAmount;
    public EffectHealingFoodItem(Properties properties, Holder<MobEffect> eff, int dur, int amp, float healAmount) {
        super(properties, eff, dur, amp);
        this.healAmount = healAmount;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        livingEntity.heal(this.healAmount);
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
