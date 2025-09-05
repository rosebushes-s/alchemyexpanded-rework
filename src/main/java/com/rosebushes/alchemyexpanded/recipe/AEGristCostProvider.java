package com.rosebushes.alchemyexpanded.recipe;

import com.mraof.minestuck.api.alchemy.GristTypes;
import com.mraof.minestuck.api.alchemy.recipe.GristCostRecipeBuilder;
import com.mraof.minestuck.data.recipe.GeneratedGristCostBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import com.rosebushes.alchemyexpanded.item.AEItems;

public final class AEGristCostProvider {
    public AEGristCostProvider() {

    }

    public static void buildRecipes(RecipeOutput recipeSaver) {
        GeneratedGristCostBuilder.create().build(recipeSaver, ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "generated"));
        GristCostRecipeBuilder.of((ItemLike)AEItems.GUN_PARTS.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.RUST, 1L).grist(GristTypes.CAULK, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.AMMO.get()).grist(GristTypes.BUILD, 8L).grist(GristTypes.RUST, 2L).grist(GristTypes.SULFUR, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.FLARE.get()).grist(GristTypes.BUILD, 8L).grist(GristTypes.TAR, 4L).grist(GristTypes.SULFUR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CROCKERCORP_AMMO.get()).grist(GristTypes.RUBY, 10L).grist(GristTypes.RUST, 6L).grist(GristTypes.SULFUR, 3L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.LASER_AMMO.get()).grist(GristTypes.BUILD, 10L).grist(GristTypes.RUST, 4L).grist(GristTypes.URANIUM, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.AMBER_CHUNK.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.AMBER, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CURSED_TAPE.get()).grist(GristTypes.BUILD, 6L).grist(GristTypes.AMETHYST, 6L).grist(GristTypes.SHALE, 6L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SADAKOS_MIXING_BOWL.get()).grist(GristTypes.AMETHYST, 444L).grist(GristTypes.TAR, 1444L).grist(GristTypes.SULFUR, 444L).grist(GristTypes.COBALT, 44L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GREEN_SUN_BOOK.get()).grist(GristTypes.BUILD, 50L).grist(GristTypes.URANIUM, 30L).grist(GristTypes.CHALK, 30L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.FLAY_DOH.get()).grist(GristTypes.BUILD, 14L).grist(GristTypes.RUST, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.RUST_DYE.get()).grist(GristTypes.GARNET, 3L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BRONZE_DYE.get()).grist(GristTypes.IODINE, 3L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.JADE_DYE.get()).grist(GristTypes.CHALK, 2L).grist(GristTypes.URANIUM, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.INDIGO_DYE.get()).grist(GristTypes.TAR, 2L).grist(GristTypes.COBALT, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.VIOLET_DYE.get()).grist(GristTypes.MARBLE, 3L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.DITO.get()).grist(GristTypes.BUILD, 1L).grist(GristTypes.IODINE, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.DITO_DETRITUS.get()).grist(GristTypes.BUILD, 3L).grist(GristTypes.IODINE, 2L).grist(GristTypes.SHALE, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.NUCLEAR_WARHEAD.get()).grist(GristTypes.BUILD, 1L).grist(GristTypes.IODINE, 1L).grist(GristTypes.URANIUM, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CHICKEN_CLUB_SALAD.get()).grist(GristTypes.BUILD, 26L).grist(GristTypes.IODINE, 16L).grist(GristTypes.RUST, 6L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WIZARD_BERRIES.get()).grist(GristTypes.BUILD, 26L).grist(GristTypes.GOLD, 12L).grist(GristTypes.DIAMOND, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WIZARDBERRY_GUSHERS.get()).grist(GristTypes.BUILD, 74L).grist(GristTypes.GOLD, 36L).grist(GristTypes.MERCURY, 42L).grist(GristTypes.DIAMOND, 16L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.HONEY_GUSHERS.get()).grist(GristTypes.BUILD, 52L).grist(GristTypes.IODINE, 33L).grist(GristTypes.AMBER, 24L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.MILK_GUSHERS.get()).grist(GristTypes.BUILD, 68L).grist(GristTypes.CHALK, 54L).grist(GristTypes.IODINE, 43L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.CHICKEN_CLUB_STAR.get()).grist(GristTypes.BUILD, 22L).grist(GristTypes.RUST, 3L).grist(GristTypes.CHALK, 4L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.COOKING_WITH_SADAKO.get()).grist(GristTypes.AMETHYST, 44L).grist(GristTypes.TAR, 444L).grist(GristTypes.SULFUR, 44L).grist(GristTypes.COBALT, 4L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.DRAGON_SAW.get()).grist(GristTypes.BUILD, 58L).grist(GristTypes.RUBY, 38L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.CARVED_WAND.get()).grist(GristTypes.BUILD, 45L).grist(GristTypes.DIAMOND, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.RESIN_WAND.get()).grist(GristTypes.BUILD, 86L).grist(GristTypes.AMBER, 62L).grist(GristTypes.RUBY, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BREAK_AUGUR.get()).grist(GristTypes.AMETHYST, 130L).grist(GristTypes.COBALT, 130L).grist(GristTypes.DIAMOND, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ANVIL_AURAWAND.get()).grist(GristTypes.BUILD, 202L).grist(GristTypes.RUST, 106L).grist(GristTypes.SULFUR, 126L).grist(GristTypes.RUBY, 1L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.GHOST_IN_THE_MACHINE.get()).grist(GristTypes.BUILD, 666L).grist(GristTypes.AMETHYST, 66L).grist(GristTypes.RUBY, 6L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.TILDEATH_DO_US_PART.get()).grist(GristTypes.BUILD, 44L).grist(GristTypes.TAR, 4L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.BELL_BAT.get()).grist(GristTypes.BUILD, 16L).grist(GristTypes.GOLD, 6L).grist(GristTypes.COBALT, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.DEAD_RINGER.get()).grist(GristTypes.BUILD, 244L).grist(GristTypes.TAR, 44L).grist(GristTypes.GOLD, 12L).grist(GristTypes.COBALT, 4L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.SQUARE_GLASSES.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ROUND_GLASSES.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SHADES.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ANIME_SHADES.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_SPIROGRAPH.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_SPORK.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_HOUSE.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_CARD.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_PICKAXE.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_PORKCHOP.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_SWORD.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_SHULKER.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_SLIME_GHOST.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_SQUIDDLE.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_RECORD.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_DEVILBEAST.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_FRIGHTENING_BEAST.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_CAT.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_HAT.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_SHIRT_SKULL.get()).grist(GristTypes.BUILD, 4L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_HEARTS.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_CLUBS.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_DIAMONDS.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_SPADES.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_CANCER.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_ARIES.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_TAURUS.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_GEMINI.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_LEO.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_VIRGO.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_LIBRA.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_SCORPIO.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_SAGITTARIUS.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_CAPRICORN.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_AQUARIUS.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_SHIRT_PISCES.get()).grist(GristTypes.BUILD, 4L).grist(GristTypes.TAR, 2L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.SUIT_CHEST.get()).grist(GristTypes.BUILD, 5L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SUIT_PANTS.get()).grist(GristTypes.BUILD, 5L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SUIT_SHOES.get()).grist(GristTypes.BUILD, 5L).grist(GristTypes.TAR, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SLIME_SUIT_CHEST.get()).grist(GristTypes.BUILD, 10L).grist(GristTypes.SHALE, 6L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SLIME_SUIT_PANTS.get()).grist(GristTypes.BUILD, 10L).grist(GristTypes.SHALE, 6L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WISE_GUY_SLIME_SUIT_CHEST.get()).grist(GristTypes.BUILD, 20L).grist(GristTypes.SHALE, 14L).grist(GristTypes.TAR, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WISE_GUY_SLIME_SUIT_PANTS.get()).grist(GristTypes.BUILD, 20L).grist(GristTypes.SHALE, 14L).grist(GristTypes.TAR, 10L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.CREW_TOP.get()).grist(GristTypes.BUILD, 6L).grist(GristTypes.AMETHYST, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CREW_SKIRT.get()).grist(GristTypes.BUILD, 6L).grist(GristTypes.AMETHYST, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CREW_BOOTS.get()).grist(GristTypes.BUILD, 6L).grist(GristTypes.AMETHYST, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.TOP_OF_ECLECTICA.get()).grist(GristTypes.COBALT, 8L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SKIRT_OF_ECLECTICA.get()).grist(GristTypes.COBALT, 8L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SLIPPERS_OF_ECLECTICA.get()).grist(GristTypes.COBALT, 8L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.DEAD_SHUFFLE_TOP.get()).grist(GristTypes.TAR, 13L).grist(GristTypes.GARNET, 13L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.DEAD_SHUFFLE_SKIRT.get()).grist(GristTypes.TAR, 13L).grist(GristTypes.GARNET, 13L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.DEAD_SHUFFLE_BOOTS.get()).grist(GristTypes.TAR, 13L).grist(GristTypes.GARNET, 13L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.ITEM_MAGNET_HELMET.get()).grist(GristTypes.BUILD, 6000L).grist(GristTypes.RUST, 848L).grist(GristTypes.RUBY, 524L).grist(GristTypes.URANIUM, 756L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GRIST_MAGNET_HELMET.get()).grist(GristTypes.BUILD, 10000L).grist(GristTypes.RUST, 956L).grist(GristTypes.URANIUM, 778L).grist(GristTypes.MERCURY, 984L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SKAIANET_SNEAKERS.get()).grist(GristTypes.BUILD, 3500L).grist(GristTypes.URANIUM, 500L).grist(GristTypes.DIAMOND, 1L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.MAGMATIC_HELMET.get()).grist(GristTypes.BUILD, 238L).grist(GristTypes.SULFUR, 164L).grist(GristTypes.TAR, 182L).grist(GristTypes.GARNET, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.MAGMATIC_CHESTPLATE.get()).grist(GristTypes.BUILD, 238L).grist(GristTypes.SULFUR, 164L).grist(GristTypes.TAR, 182L).grist(GristTypes.GARNET, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.MAGMATIC_LEGGINGS.get()).grist(GristTypes.BUILD, 238L).grist(GristTypes.SULFUR, 164L).grist(GristTypes.TAR, 182L).grist(GristTypes.GARNET, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.MAGMATIC_BOOTS.get()).grist(GristTypes.BUILD, 238L).grist(GristTypes.SULFUR, 164L).grist(GristTypes.TAR, 182L).grist(GristTypes.GARNET, 1L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.COPPER_SHIELD.get()).grist(GristTypes.BUILD, 24L).grist(GristTypes.RUST, 14L).grist(GristTypes.GARNET, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.STEAM_POWERED_HYDROFAN.get()).grist(GristTypes.BUILD, 74L).grist(GristTypes.RUST, 46L).grist(GristTypes.RUBY, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.PYRE_PROTECTOR.get()).grist(GristTypes.BUILD, 46L).grist(GristTypes.SULFUR, 26L).grist(GristTypes.TAR, 36L).grist(GristTypes.RUBY, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ROSE_BRAMBLE_BUCKLER.get()).grist(GristTypes.BUILD, 53L).grist(GristTypes.IODINE, 38L).grist(GristTypes.AMBER, 22L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.RAZOR_SHIELD.get()).grist(GristTypes.BUILD, 62L).grist(GristTypes.RUST, 54L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.POGO_SHIELD.get()).grist(GristTypes.BUILD, 45L).grist(GristTypes.SHALE, 28L).grist(GristTypes.TAR, 28L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.REGISHIELD.get()).grist(GristTypes.AMETHYST, 72L).grist(GristTypes.TAR, 64L).grist(GristTypes.GOLD, 44L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.YOYO.get()).grist(GristTypes.BUILD, 12L).grist(GristTypes.GOLD, 8L).grist(GristTypes.MERCURY, 9L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ROSE_ROTATOR.get()).grist(GristTypes.BUILD, 16L).grist(GristTypes.MARBLE, 8L).grist(GristTypes.MERCURY, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ROLLUP_ROTATOR.get()).grist(GristTypes.BUILD, 18L).grist(GristTypes.IODINE, 12L).grist(GristTypes.MARBLE, 10L).grist(GristTypes.RUBY, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CERULEAN_STACKS.get()).grist(GristTypes.BUILD, 32L).grist(GristTypes.COBALT, 16L).grist(GristTypes.MERCURY, 18L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WIZARD_SPINNER.get()).grist(GristTypes.BUILD, 25L).grist(GristTypes.GOLD, 10L).grist(GristTypes.MERCURY, 11L).grist(GristTypes.GARNET, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.FIRESCALE_THROWER.get()).grist(GristTypes.BUILD, 94L).grist(GristTypes.TAR, 45L).grist(GristTypes.MERCURY, 38L).grist(GristTypes.RUBY, 3L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CARBON_ORACLE.get()).grist(GristTypes.DIAMOND, 146L).grist(GristTypes.COBALT, 42L).grist(GristTypes.MERCURY, 64L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.REGIYOYO.get()).grist(GristTypes.AMETHYST, 28L).grist(GristTypes.TAR, 16L).grist(GristTypes.GOLD, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.DEATHS_COUNTERWEIGHT.get()).grist(GristTypes.BUILD, 114L).grist(GristTypes.TAR, 73L).grist(GristTypes.SULFUR, 62L).grist(GristTypes.QUARTZ, 4L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ROTATIONAL_GENESIS.get()).grist(GristTypes.BUILD, 413L).grist(GristTypes.AMETHYST, 184L).grist(GristTypes.RUBY, 184L).grist(GristTypes.DIAMOND, 184L).grist(GristTypes.URANIUM, 184L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SPINNER_OF_THE_CYCLE.get()).grist(GristTypes.BUILD, 1143L).grist(GristTypes.GOLD, 946L).grist(GristTypes.AMBER, 1082L).grist(GristTypes.DIAMOND, 428L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GREEN_SUN_SLEEPER.get()).grist(GristTypes.BUILD, 1368L).grist(GristTypes.URANIUM, 856L).grist(GristTypes.CHALK, 1048L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SUN_RISES.get()).grist(GristTypes.BUILD, 485L).grist(GristTypes.GOLD, 264L).grist(GristTypes.URANIUM, 320L).grist(GristTypes.DIAMOND, 32L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_DRAGON_DEATH_WHIRLER.get()).grist(GristTypes.BUILD, 516L).grist(GristTypes.TAR, 364L).grist(GristTypes.AMETHYST, 232L).grist(GristTypes.COBALT, 52L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.BOXING_GLOVE.get()).grist(GristTypes.BUILD, 24L).grist(GristTypes.TAR, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.KNUCKLE_DUSTER.get()).grist(GristTypes.BUILD, 30L).grist(GristTypes.RUST, 12L).grist(GristTypes.MERCURY, 6L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.REGIKNUCKLE.get()).grist(GristTypes.AMETHYST, 63L).grist(GristTypes.TAR, 52L).grist(GristTypes.GOLD, 14L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ROYAL_KNUCKLE.get()).grist(GristTypes.GOLD, 85L).grist(GristTypes.DIAMOND, 55L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GAUNTLET.get()).grist(GristTypes.BUILD, 36L).grist(GristTypes.RUST, 12L).grist(GristTypes.GOLD, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.NIGHTTIME_KNOCKOUT.get()).grist(GristTypes.TAR, 38L).grist(GristTypes.AMETHYST, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.MIDNIGHT_BRUISER.get()).grist(GristTypes.AMETHYST, 76L).grist(GristTypes.TAR, 56L).grist(GristTypes.DIAMOND, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.FORTUNES_HAND.get()).grist(GristTypes.BUILD, 40L).grist(GristTypes.TAR, 20L).grist(GristTypes.COBALT, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BOMBING_GLOVE.get()).grist(GristTypes.BUILD, 162L).grist(GristTypes.SULFUR, 82L).grist(GristTypes.TAR, 66L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.COBALT_CRYSTAL_PULVERIZER.get()).grist(GristTypes.DIAMOND, 84L).grist(GristTypes.COBALT, 84L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.MELTDOWN_MITT.get()).grist(GristTypes.BUILD, 425L).grist(GristTypes.SULFUR, 262L).grist(GristTypes.URANIUM, 138L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CRYSTAL_CLAWED_DRAGON_GRIP.get()).grist(GristTypes.DIAMOND, 114L).grist(GristTypes.RUBY, 54L).grist(GristTypes.GOLD, 64L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.LIGHTEST_TOUCH.get()).grist(GristTypes.BUILD, 228L).grist(GristTypes.CHALK, 145L).grist(GristTypes.QUARTZ, 30L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.FLINTLOCK_PISTOL.get()).grist(GristTypes.BUILD, 12L).grist(GristTypes.RUST, 6L).grist(GristTypes.SULFUR, 3L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.FLARE_GUN.get()).grist(GristTypes.BUILD, 30L).grist(GristTypes.RUST, 12L).grist(GristTypes.SULFUR, 20L).grist(GristTypes.TAR, 12L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GAMMA_BLASTER.get()).grist(GristTypes.BUILD, 55L).grist(GristTypes.URANIUM, 18L).grist(GristTypes.GOLD, 14L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BREATH_BLASTER.get()).grist(GristTypes.BUILD, 56L).grist(GristTypes.AMETHYST, 24L).grist(GristTypes.URANIUM, 12L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.NOXIOUS_BURST_CANNON.get()).grist(GristTypes.BUILD, 113L).grist(GristTypes.URANIUM, 84L).grist(GristTypes.RUBY, 26L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.REVOLVER.get()).grist(GristTypes.BUILD, 50L).grist(GristTypes.RUST, 25L).grist(GristTypes.MERCURY, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SIXLET_SIXSHOOTER.get()).grist(GristTypes.BUILD, 55L).grist(GristTypes.CHALK, 30L).grist(GristTypes.IODINE, 16L).grist(GristTypes.MERCURY, 12L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.DAPPLE_DEULY.get()).grist(GristTypes.BUILD, 63L).grist(GristTypes.RUST, 28L).grist(GristTypes.GOLD, 14L).grist(GristTypes.QUARTZ, 2L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.LASER_PISTOL.get()).grist(GristTypes.BUILD, 120L).grist(GristTypes.RUST, 44L).grist(GristTypes.URANIUM, 30L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WYVERN_FIRE.get()).grist(GristTypes.BUILD, 162L).grist(GristTypes.SULFUR, 66L).grist(GristTypes.TAR, 48L).grist(GristTypes.RUBY, 12L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BERETTA.get()).grist(GristTypes.BUILD, 74L).grist(GristTypes.RUST, 30L).grist(GristTypes.TAR, 15L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.REGIPISTOL.get()).grist(GristTypes.AMETHYST, 34L).grist(GristTypes.TAR, 86L).grist(GristTypes.GOLD, 24L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.NETHERITE_KING_KILLER.get()).grist(GristTypes.RUST, 482L).grist(GristTypes.SULFUR, 365L).grist(GristTypes.SHALE, 408L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GOLDEN_GRIP.get()).grist(GristTypes.GOLD, 197L).grist(GristTypes.RUBY, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.FORESIGHT_DUELER.get()).grist(GristTypes.COBALT, 824L).grist(GristTypes.QUARTZ, 15L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GREEN_SUN_SLAMMER.get()).grist(GristTypes.BUILD, 2235L).grist(GristTypes.URANIUM, 504L).grist(GristTypes.CHALK, 760L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.WHITE_MAGNUM.get()).grist(GristTypes.BUILD, 6120).grist(GristTypes.GOLD, 4612).grist(GristTypes.URANIUM, 3413).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.APPEARIFIER_PISTOL.get()).grist(GristTypes.RUBY, 630L).grist(GristTypes.RUST, 240L).grist(GristTypes.URANIUM, 334L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.FLINTLOCK_RIFLE.get()).grist(GristTypes.BUILD, 14L).grist(GristTypes.RUST, 8L).grist(GristTypes.SULFUR, 5L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.RIFLE.get()).grist(GristTypes.BUILD, 40L).grist(GristTypes.RUST, 20L).grist(GristTypes.AMBER, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GUNBLADE.get()).grist(GristTypes.BUILD, 46L).grist(GristTypes.RUST, 24L).grist(GristTypes.GARNET, 3L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.CANDY_CARBINE.get()).grist(GristTypes.BUILD, 45L).grist(GristTypes.IODINE, 25L).grist(GristTypes.GOLD, 12L).grist(GristTypes.CHALK, 16L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLACK_ASSAULT_RIFLE.get()).grist(GristTypes.BUILD, 116L).grist(GristTypes.RUST, 58L).grist(GristTypes.TAR, 28L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GOLD_ASSAULT_RIFLE.get()).grist(GristTypes.BUILD, 174L).grist(GristTypes.GOLD, 86L).grist(GristTypes.RUBY, 42L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ENGLISH_EXECUTIONER.get()).grist(GristTypes.GOLD, 9612L).grist(GristTypes.CHALK, 7612L).grist(GristTypes.URANIUM, 2160L).grist(GristTypes.ZILLIUM, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.SNIPER_RIFLE.get()).grist(GristTypes.BUILD, 76L).grist(GristTypes.RUST, 54L).grist(GristTypes.CAULK, 46L).grist(GristTypes.QUARTZ, 1L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.REGIRIFLE.get()).grist(GristTypes.AMETHYST, 57L).grist(GristTypes.TAR, 84L).grist(GristTypes.GOLD, 32L).grist(GristTypes.QUARTZ, 3L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.LASER_RIFLE.get()).grist(GristTypes.BUILD, 140L).grist(GristTypes.RUST, 66L).grist(GristTypes.URANIUM, 40L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.ANNIES_GOT_A_GUN.get()).grist(GristTypes.BUILD, 340L).grist(GristTypes.CHALK, 142L).grist(GristTypes.DIAMOND, 55L).grist(GristTypes.MARBLE, 73L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.MACHINE_GUN.get()).grist(GristTypes.BUILD, 120L).grist(GristTypes.RUST, 30L).grist(GristTypes.TAR, 50L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GIRLS_BEST_FRIEND.get()).grist(GristTypes.DIAMOND, 1555L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.GREEN_SUN_STREETSWEEPER.get()).grist(GristTypes.BUILD, 2770L).grist(GristTypes.URANIUM, 450L).grist(GristTypes.CHALK, 1260L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.APPEARIFIER_RIFLE.get()).grist(GristTypes.RUBY, 645L).grist(GristTypes.RUST, 256L).grist(GristTypes.URANIUM, 367L).build(recipeSaver);

        GristCostRecipeBuilder.of((ItemLike)AEItems.SHOTGUN.get()).grist(GristTypes.BUILD, 62L).grist(GristTypes.RUST, 43L).grist(GristTypes.SULFUR, 36L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BLUNDERBUSS.get()).grist(GristTypes.BUILD, 220L).grist(GristTypes.RUST, 165L).grist(GristTypes.SULFUR, 73L).grist(GristTypes.GOLD, 15L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BOOMSTICK.get()).grist(GristTypes.SULFUR, 456L).grist(GristTypes.TAR, 532L).grist(GristTypes.AMETHYST, 10L).build(recipeSaver);
        GristCostRecipeBuilder.of((ItemLike)AEItems.BARBASOL_BOMB_LAUNCHER.get()).grist(GristTypes.BUILD, 120L).grist(GristTypes.RUST, 92L).grist(GristTypes.SHALE, 40L).build(recipeSaver);
    }
}
