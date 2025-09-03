package com.rosebushes.alchemyexpanded.item.loot;

import com.rosebushes.alchemyexpanded.AlchemyExpanded;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class AELootTables {
    public static final ResourceKey<LootTable> AMMO_LAND_LOOT_INJECT = resourceKey("chests/injections/ammo_land_loot_inject");

    public AELootTables() {

    }

    private static ResourceKey<LootTable> resourceKey(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, AlchemyExpanded.id(name));
    }
}
