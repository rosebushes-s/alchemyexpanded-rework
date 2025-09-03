package com.rosebushes.alchemyexpanded.item.loot;

import com.google.common.collect.Sets;
import com.mraof.minestuck.item.loot.MSLootTables;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;

import java.util.Set;

@EventBusSubscriber(
        modid = "alchemyexpanded"
)
public class AELootEvents {
    private static final Set<ResourceLocation> AMMO_LAND_LOOT_INJECT;

    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        inject(event, AMMO_LAND_LOOT_INJECT, AELootTables.AMMO_LAND_LOOT_INJECT,"ammo_land_inject");
    }

    private static void inject(LootTableLoadEvent event, Set<ResourceLocation> lootTableSet, ResourceKey<LootTable> injectionLootTable, String address) {
        if (lootTableSet.contains(event.getName())) {
            LootPool pool = LootPool.lootPool().add(NestedLootTable.lootTableReference(injectionLootTable)).name(address).build();
            event.getTable().addPool(pool);
        }
    }

    static {
        AMMO_LAND_LOOT_INJECT = Sets.newHashSet(new ResourceLocation[]{MSLootTables.BASIC_MEDIUM_CHEST.location()});
    }
}
