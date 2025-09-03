package com.rosebushes.alchemyexpanded.data.loot_table;

import com.mraof.minestuck.item.MSItems;
import com.mraof.minestuck.item.loot.MSLootTables;
import com.rosebushes.alchemyexpanded.item.AEItems;
import com.rosebushes.alchemyexpanded.item.loot.AELootTables;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class AEChestLootTables implements LootTableSubProvider {
    public AEChestLootTables() {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> lootProcessor) {
        lootProcessor.accept(AELootTables.AMMO_LAND_LOOT_INJECT, LootTable.lootTable().withPool(LootPool.lootPool().name("alchemyexpanded").setRolls(UniformGenerator.between(0.0F, 6.0F)).add(LootItem.lootTableItem((ItemLike) AEItems.AMMO.get()).setWeight(14).setQuality(1).apply(this.countRange(0.0F, 4.0F))).add(LootItem.lootTableItem((ItemLike) AEItems.FLARE.get()).setWeight(8).setQuality(1).apply(this.countRange(0.0F, 2.0F))).add(LootItem.lootTableItem((ItemLike) AEItems.LASER_AMMO.get()).setWeight(8).setQuality(1).apply(this.countRange(0.0F, 4.0F))).add(LootItem.lootTableItem((ItemLike) AEItems.DITO.get()).setWeight(10).setQuality(1).apply(this.countRange(0.0F, 3.0F))).add(LootItem.lootTableItem((ItemLike) AEItems.GREEN_SUN_BOOK.get()).setWeight(1).setQuality(1).apply(this.countRange(0.0F, 1.0F)))));
    }

    public LootItemFunction.Builder countRange(float min, float max) {
        return SetItemCountFunction.setCount(UniformGenerator.between(min, max));
    }
}
