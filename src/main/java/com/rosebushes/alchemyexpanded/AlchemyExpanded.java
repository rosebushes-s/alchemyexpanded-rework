package com.rosebushes.alchemyexpanded;

import com.rosebushes.alchemyexpanded.block.AEBlocks;
import com.rosebushes.alchemyexpanded.entity.AEEntities;
import com.rosebushes.alchemyexpanded.item.AECreativeTabs;
import com.rosebushes.alchemyexpanded.item.AEItems;
import com.rosebushes.alchemyexpanded.util.AESoundEvents;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(AlchemyExpanded.MODID)
public class AlchemyExpanded
{
    public static final String MODID = "alchemyexpanded";

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", path);
    }

    public AlchemyExpanded(IEventBus modEventBus)
    {
        AEItems.REGISTER.register(modEventBus);
        AEBlocks.REGISTER.register(modEventBus);
        AEEntities.REGISTER.register(modEventBus);
        AECreativeTabs.REGISTER.register(modEventBus);
        AESoundEvents.REGISTER.register(modEventBus);
    }

}
