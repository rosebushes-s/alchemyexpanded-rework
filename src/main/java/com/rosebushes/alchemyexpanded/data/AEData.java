package com.rosebushes.alchemyexpanded.data;

import com.rosebushes.alchemyexpanded.data.loot_table.AELootTableProvider;
import com.rosebushes.alchemyexpanded.recipe.AERecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(
        modid = "alchemyexpanded"
)
public class AEData {
    public AEData() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        DatapackBuiltinEntriesProvider builtinEntries = (DatapackBuiltinEntriesProvider)gen.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), registrySetBuilder(), Set.of("alchemyexpanded")));
        CompletableFuture<HolderLookup.Provider> lookupProvider = builtinEntries.getRegistryProvider();
        gen.addProvider(event.includeServer(), new AERecipeProvider(output, lookupProvider));
        gen.addProvider(event.includeServer(), new AEDamageTypeProvider.Tags(output, lookupProvider, fileHelper));
        gen.addProvider(event.includeServer(), AELootTableProvider.create(output, lookupProvider));
    }

    private static RegistrySetBuilder registrySetBuilder() {
        return new RegistrySetBuilder().add(Registries.DAMAGE_TYPE, AEDamageTypeProvider::register);
    }
}
