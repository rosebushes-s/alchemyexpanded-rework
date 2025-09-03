package com.rosebushes.alchemyexpanded.item.foods;

import com.mraof.minestuck.item.foods.HealingFoodItem;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HoneyGushersItem extends HealingFoodItem {
    public HoneyGushersItem(float healAmount, Properties properties) {
        super(healAmount, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        if(entityLiving.hasEffect(MobEffects.POISON)) {
            entityLiving.removeEffect(MobEffects.POISON);
        }
        return super.finishUsingItem(stack, level, entityLiving);
    }
}
