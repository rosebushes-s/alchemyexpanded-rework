package com.rosebushes.alchemyexpanded.data.loot_table;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AELootTableProvider {
    public AELootTableProvider() {
    }

    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry((provider) -> new AEChestLootTables(), LootContextParamSets.CHEST)), lookup);
    }
}
