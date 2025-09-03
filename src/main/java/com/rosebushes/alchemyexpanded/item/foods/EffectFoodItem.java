package com.rosebushes.alchemyexpanded.item.foods;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EffectFoodItem extends Item {
    protected MobEffectInstance effect;

    public EffectFoodItem(Properties properties, Holder<MobEffect> eff, int dur, int amp) {
        super(properties);
        this.effect = new MobEffectInstance(eff, dur, amp);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if(!livingEntity.hasEffect(effect.getEffect())) {
            livingEntity.addEffect(new MobEffectInstance(effect));
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
