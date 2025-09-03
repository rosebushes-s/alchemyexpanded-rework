package com.rosebushes.alchemyexpanded.recipe;

import com.mraof.minestuck.item.MSItems;
import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AERecipeProvider extends RecipeProvider {

    public AERecipeProvider(PackOutput output, CompletableFuture< HolderLookup.Provider> registries) {
        super(output, registries);
    }

    protected void buildRecipes(RecipeOutput recipeBuilder) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, (ItemLike)Items.CAKE, 1).requires((ItemLike)AEItems.SADAKOS_MIXING_BOWL.get()).requires((ItemLike)MSItems.CAKE_MIX.get()).unlockedBy("has_sadakos_mixing_bowl", has((ItemLike)AEItems.SADAKOS_MIXING_BOWL.get())).save(recipeBuilder);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, (ItemLike)AEItems.AMMO.get(), 2).requires(Items.IRON_INGOT).requires(Items.GUNPOWDER).requires(Items.PAPER).unlockedBy("has_gunpowder", has((ItemLike)Items.GUNPOWDER)).save(recipeBuilder);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)AEItems.FLINTLOCK_PISTOL.get()).define('#', (ItemLike)Items.TRIPWIRE_HOOK).define('X', (ItemLike)Items.FLINT).define('Y', (ItemLike)Items.COPPER_INGOT).define('Z', (ItemLike)Items.GUNPOWDER).define('W', (ItemLike)AEItems.AMMO.get()).pattern("#XY").pattern("ZW ").pattern("Y  ").unlockedBy("has_ammo", has((ItemLike)AEItems.AMMO.get())).save(recipeBuilder);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)AEItems.FLINTLOCK_RIFLE.get()).define('#', (ItemLike)AEItems.FLINTLOCK_PISTOL.get()).define('!', (ItemLike)Items.COPPER_INGOT).define('@', (ItemLike)Items.IRON_INGOT).pattern("  !").pattern(" # ").pattern("@  ").unlockedBy("has_flintlock_pistol", has((ItemLike)AEItems.FLINTLOCK_PISTOL.get())).save(recipeBuilder);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)AEItems.YOYO.get()).define('#', (ItemLike)Items.GOLD_INGOT).define('&', (ItemLike)Items.IRON_NUGGET).define('%', (ItemLike)Items.STRING).pattern(" # ").pattern("#&#").pattern(" #%").unlockedBy("has_gold", has((ItemLike)Items.GOLD_INGOT)).save(recipeBuilder);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)AEItems.BOXING_GLOVE.get()).define('#', (ItemLike)Items.LEATHER).define('&', (ItemLike)Items.IRON_INGOT).define('*', (ItemLike)Items.STRING).pattern("###").pattern("#&#").pattern("##*").unlockedBy("has_leather", has((ItemLike)Items.LEATHER)).save(recipeBuilder);
        AEGristCostProvider.buildRecipes(recipeBuilder);
        AECombinationsProvider.buildRecipes(recipeBuilder);
    }

}
