package com.rosebushes.alchemyexpanded.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MixingBowlItem extends Item {
    public MixingBowlItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return new ItemStack(AEItems.SADAKOS_MIXING_BOWL.get());
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }
}
