package com.rosebushes.alchemyexpanded.item.foods;

import com.mraof.minestuck.item.foods.HealingFoodItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MilkGushersItem extends HealingFoodItem {
    public MilkGushersItem(float healAmount, Properties properties) {
        super(healAmount, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        entityLiving.removeAllEffects();
        return super.finishUsingItem(stack, level, entityLiving);
    }
}
