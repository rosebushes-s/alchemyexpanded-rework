package com.rosebushes.alchemyexpanded.recipe;

import com.mraof.minestuck.api.alchemy.recipe.combination.CombinationRecipeBuilder;
import com.mraof.minestuck.item.MSItems;
import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;

public class AECombinationsProvider {
    public AECombinationsProvider() {

    }

    public static void buildRecipes(RecipeOutput consumer) {
        CombinationRecipeBuilder.of(AEItems.AMMO).input(Items.IRON_INGOT).or().input(Items.GUNPOWDER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.FLARE).input(AEItems.AMMO).or().input(Items.FIRE_CHARGE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CROCKERCORP_AMMO).input(AEItems.AMMO).or().input(MSItems.CAKE_MIX).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.LASER_AMMO).input(AEItems.AMMO).or().input(MSItems.BATTERY).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GUN_PARTS).input(AEItems.AMMO).and().input(Items.ANVIL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.AMBER_CHUNK).input(Items.HONEY_BLOCK).and().input(MSItems.BUG_ON_A_STICK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLUE_BEAUTY).input(Items.LAPIS_LAZULI).and().input(MSItems.GAMEGRL_MAGAZINE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CURSED_TAPE).input(MSItems.CRYPTID_PHOTO).and().input(MSItems.CASSETTE_11).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SADAKOS_MIXING_BOWL).input(AEItems.COOKING_WITH_SADAKO).and().input(Items.BOWL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.FLAY_DOH).input(Items.CLAY_BALL).and().input(MSItems.GRUB_SAUCE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GREEN_SUN_BOOK).input(Items.BOOK).or().input(MSItems.RAW_URANIUM).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.RUST_DYE).input(MSItems.GRUB_SAUCE).and().input(Items.RED_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BRONZE_DYE).input(MSItems.GRUB_SAUCE).and().input(Items.BROWN_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.JADE_DYE).input(MSItems.GRUB_SAUCE).and().input(Items.GREEN_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.INDIGO_DYE).input(MSItems.GRUB_SAUCE).and().input(Items.BLUE_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.VIOLET_DYE).input(MSItems.GRUB_SAUCE).and().input(Items.MAGENTA_DYE).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.DITO).input(MSItems.GAMEBRO_MAGAZINE).or().input(Items.FLINT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.DITO_DETRITUS).input(AEItems.DITO).and().input(MSItems.PHLEGM_GUSHERS).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.NUCLEAR_WARHEAD).input(MSItems.CANDY_CORN).and().input(MSItems.RAW_URANIUM).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CHICKEN_CLUB_SALAD).input(Items.COOKED_CHICKEN).and().input(MSItems.CLUBS_SUITARANG).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WIZARD_BERRIES).input(Items.SWEET_BERRIES).or().input(MSItems.MINI_WIZARD_STATUE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WIZARDBERRY_GUSHERS).input(MSItems.PHLEGM_GUSHERS).and().input(AEItems.WIZARD_BERRIES).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.HONEY_GUSHERS).input(MSItems.PHLEGM_GUSHERS).and().input(Items.HONEY_BOTTLE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.MILK_GUSHERS).input(MSItems.PHLEGM_GUSHERS).and().input(Items.MILK_BUCKET).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.SQUARE_GLASSES).input(Items.GLASS_PANE).and().input(Items.STICK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ROUND_GLASSES).input(AEItems.SQUARE_GLASSES).or().input(MSItems.BLANK_DISK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SHADES).input(AEItems.SQUARE_GLASSES).and().input(Items.BLACK_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ANIME_SHADES).input(AEItems.SHADES).or().input(MSItems.GAMEBRO_MAGAZINE).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT).input(Items.LEATHER_CHESTPLATE).and().input(Items.WHITE_WOOL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_SPIROGRAPH).input(AEItems.WHITE_SHIRT).or().input(MSItems.SERVER_DISK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_SPORK).input(AEItems.WHITE_SHIRT).or().input(MSItems.GRIST_WIDGET).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_HOUSE).input(AEItems.WHITE_SHIRT).or().input(MSItems.CLIENT_DISK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_CARD).input(AEItems.WHITE_SHIRT).or().input(MSItems.CAPTCHA_CARD).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_PICKAXE).input(AEItems.WHITE_SHIRT).or().input(Items.DIAMOND_PICKAXE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_PORKCHOP).input(AEItems.WHITE_SHIRT).or().input(Items.COOKED_PORKCHOP).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_SWORD).input(AEItems.WHITE_SHIRT).or().input(Items.DIAMOND_SWORD).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_SHULKER).input(AEItems.WHITE_SHIRT).or().input(Items.SHULKER_SHELL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_SLIME_GHOST).input(AEItems.WHITE_SHIRT).or().input(Items.SLIME_BALL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_SQUIDDLE).input(AEItems.WHITE_SHIRT).or().input(Items.INK_SAC).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_RECORD).input(AEItems.WHITE_SHIRT).or().input(Items.MUSIC_DISC_CAT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_DEVILBEAST).input(AEItems.WHITE_SHIRT).or().input(MSItems.RAW_URANIUM).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_FRIGHTENING_BEAST).input(AEItems.WHITE_SHIRT).or().input(MSItems.CROCKER_SPOON).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_CAT).input(AEItems.WHITE_SHIRT).or().input(MSItems.PLUSH_MUTATED_CAT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_HAT).input(AEItems.WHITE_SHIRT).or().input(AEItems.ANIME_SHADES).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_SHIRT_SKULL).input(AEItems.WHITE_SHIRT).or().input(Items.SKELETON_SKULL).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT).input(AEItems.WHITE_SHIRT).or().input(Items.BLACK_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_HEARTS).input(AEItems.BLACK_SHIRT).or().input(MSItems.ACE_OF_HEARTS).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_CLUBS).input(AEItems.BLACK_SHIRT).or().input(MSItems.ACE_OF_CLUBS).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_DIAMONDS).input(AEItems.BLACK_SHIRT).or().input(MSItems.ACE_OF_DIAMONDS).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_SPADES).input(AEItems.BLACK_SHIRT).or().input(MSItems.ACE_OF_SPADES).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_CANCER).input(AEItems.BLACK_SHIRT).or().input(Items.RED_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_ARIES).input(AEItems.BLACK_SHIRT).or().input(AEItems.RUST_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_TAURUS).input(AEItems.BLACK_SHIRT).or().input(AEItems.BRONZE_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_GEMINI).input(AEItems.BLACK_SHIRT).or().input(Items.YELLOW_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_LEO).input(AEItems.BLACK_SHIRT).or().input(Items.GREEN_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_VIRGO).input(AEItems.BLACK_SHIRT).or().input(AEItems.JADE_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_LIBRA).input(AEItems.BLACK_SHIRT).or().input(Items.CYAN_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_SCORPIO).input(AEItems.BLACK_SHIRT).or().input(Items.BLUE_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_SAGITTARIUS).input(AEItems.BLACK_SHIRT).or().input(AEItems.INDIGO_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_CAPRICORN).input(AEItems.BLACK_SHIRT).or().input(Items.PURPLE_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_AQUARIUS).input(AEItems.BLACK_SHIRT).or().input(AEItems.VIOLET_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_SHIRT_PISCES).input(AEItems.BLACK_SHIRT).or().input(Items.MAGENTA_DYE).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.SUIT_CHEST).input(Items.LEATHER_CHESTPLATE).and().input(Items.BLACK_WOOL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SUIT_PANTS).input(Items.LEATHER_LEGGINGS).and().input(Items.BLACK_WOOL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SUIT_SHOES).input(Items.LEATHER_BOOTS).and().input(Items.BLACK_CONCRETE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SLIME_SUIT_CHEST).input(AEItems.SUIT_CHEST).and().input(AEItems.WHITE_SHIRT_SLIME_GHOST).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SLIME_SUIT_PANTS).input(AEItems.SUIT_PANTS).and().input(AEItems.WHITE_SHIRT_SLIME_GHOST).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WISE_GUY_SLIME_SUIT_CHEST).input(AEItems.SLIME_SUIT_CHEST).and().input(MSItems.WISEGUY).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WISE_GUY_SLIME_SUIT_PANTS).input(AEItems.SLIME_SUIT_PANTS).and().input(MSItems.WISEGUY).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.CREW_TOP).input(Items.LEATHER_CHESTPLATE).and().input(MSItems.CREW_POSTER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CREW_SKIRT).input(Items.LEATHER_LEGGINGS).and().input(MSItems.CREW_POSTER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CREW_BOOTS).input(Items.LEATHER_BOOTS).and().input(MSItems.CREW_POSTER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.TOP_OF_ECLECTICA).input(AEItems.WHITE_SHIRT_DEVILBEAST).and().input(AEItems.BLUE_BEAUTY).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SKIRT_OF_ECLECTICA).input(Items.LEATHER_LEGGINGS).and().input(AEItems.BLUE_BEAUTY).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SLIPPERS_OF_ECLECTICA).input(Items.LEATHER_BOOTS).and().input(AEItems.BLUE_BEAUTY).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.DEAD_SHUFFLE_TOP).input(AEItems.CREW_TOP).or().input(Items.ROTTEN_FLESH).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.DEAD_SHUFFLE_SKIRT).input(AEItems.CREW_SKIRT).or().input(Items.ROTTEN_FLESH).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.DEAD_SHUFFLE_BOOTS).input(AEItems.CREW_BOOTS).or().input(Items.ROTTEN_FLESH).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.ITEM_MAGNET_HELMET).input(Items.IRON_HELMET).and().input(MSItems.SENDIFICATOR).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GRIST_MAGNET_HELMET).input(AEItems.ITEM_MAGNET_HELMET).and().input(MSItems.GRIST_COLLECTOR).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SKAIANET_SNEAKERS).input(Items.LEATHER_BOOTS).and().input(MSItems.POWER_HUB).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.MAGMATIC_HELMET).input(Items.DIAMOND_HELMET).and().input(Items.MAGMA_BLOCK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.MAGMATIC_CHESTPLATE).input(Items.DIAMOND_CHESTPLATE).and().input(Items.MAGMA_BLOCK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.MAGMATIC_LEGGINGS).input(Items.DIAMOND_LEGGINGS).and().input(Items.MAGMA_BLOCK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.MAGMATIC_BOOTS).input(Items.DIAMOND_BOOTS).and().input(Items.MAGMA_BLOCK).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.COPPER_SHIELD).input(Items.SHIELD).or().input(Items.COPPER_INGOT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.STEAM_POWERED_HYDROFAN).input(AEItems.COPPER_SHIELD).and().input(Items.CLOCK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.PYRE_PROTECTOR).input(AEItems.COPPER_SHIELD).and().input(Items.BLAZE_POWDER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ROSE_BRAMBLE_BUCKLER).input(AEItems.COPPER_SHIELD).and().input(Items.ROSE_BUSH).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.RAZOR_SHIELD).input(AEItems.COPPER_SHIELD).and().input(MSItems.RAZOR_BLADE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.POGO_SHIELD).input(AEItems.COPPER_SHIELD).and().input(Items.SLIME_BALL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.REGISHIELD).input(AEItems.COPPER_SHIELD).and().input(MSItems.CHESSBOARD).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.CHICKEN_CLUB_STAR).input(Items.COOKED_CHICKEN).or().input(MSItems.CLUBS_SUITARANG).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.COOKING_WITH_SADAKO).input(MSItems.SILVER_SPOON).and().input(AEItems.CURSED_TAPE).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.DRAGON_SAW).input(MSItems.LIPSTICK_CHAINSAW).or().input(MSItems.SCALEMATE_APPLESCAB).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.CARVED_WAND).input(MSItems.WAND).and().input(Items.DARK_OAK_DOOR).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.RESIN_WAND).input(MSItems.WAND).or().input(AEItems.AMBER_CHUNK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BREAK_AUGUR).input(MSItems.POOL_CUE_WAND).and().input(MSItems.EIGHTBALL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ANVIL_AURAWAND).input(AEItems.RESIN_WAND).and().input(Items.ANVIL).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.GHOST_IN_THE_MACHINE).input(MSItems.KEY_TO_THE_MACHINE).or().input(AEItems.CURSED_TAPE).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.TILDEATH_DO_US_PART).input(MSItems.SCYTHE).and().input(MSItems.TILLDEATH_HANDBOOK).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.BELL_BAT).input(MSItems.METAL_BAT).and().input(Items.BELL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.DEAD_RINGER).input(AEItems.BELL_BAT).or().input(Items.ROTTEN_FLESH).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.YOYO).input(MSItems.BLANK_DISK).and().input(Items.STRING).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ROSE_ROTATOR).input(AEItems.YOYO).and().input(Items.PINK_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ROLLUP_ROTATOR).input(AEItems.ROSE_ROTATOR).or().input(MSItems.CANDY_CORN).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CERULEAN_STACKS).input(AEItems.YOYO).and().input(MSItems.EIGHTBALL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WIZARD_SPINNER).input(AEItems.YOYO).and().input(MSItems.MINI_WIZARD_STATUE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.FIRESCALE_THROWER).input(AEItems.WIZARD_SPINNER).or().input(MSItems.SCALEMATE_APPLESCAB).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CARBON_ORACLE).input(AEItems.CERULEAN_STACKS).and().input(Items.DIAMOND).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.REGIYOYO).input(AEItems.YOYO).or().input(MSItems.CHESSBOARD).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.DEATHS_COUNTERWEIGHT).input(AEItems.ROSE_ROTATOR).or().input(MSItems.TILLDEATH_HANDBOOK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ROTATIONAL_GENESIS).input(AEItems.ROSE_ROTATOR).or().input(MSItems.FROG).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SPINNER_OF_THE_CYCLE).input(AEItems.ROTATIONAL_GENESIS).and().input(AEItems.DEATHS_COUNTERWEIGHT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GREEN_SUN_SLEEPER).input(AEItems.ROSE_ROTATOR).or().input(AEItems.GREEN_SUN_BOOK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SUN_RISES).input(AEItems.CARBON_ORACLE).and().input(MSItems.STAR_RAY).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_DRAGON_DEATH_WHIRLER).input(AEItems.FIRESCALE_THROWER).and().input(MSItems.OBSIDIATOR).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.OLWYN_LLINYNNOL).input(AEItems.ROSE_ROTATOR).and().input(MSItems.CUEBALL).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.BOXING_GLOVE).input(Items.LEATHER).and().input(Items.SPIDER_EYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.KNUCKLE_DUSTER).input(AEItems.BOXING_GLOVE).and().input(Items.IRON_INGOT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.REGIKNUCKLE).input(AEItems.KNUCKLE_DUSTER).and().input(MSItems.CHESSBOARD).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ROYAL_KNUCKLE).input(AEItems.REGIKNUCKLE).and().input(Items.GOLD_INGOT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GAUNTLET).input(AEItems.KNUCKLE_DUSTER).and().input(Items.CHAIN).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.NIGHTTIME_KNOCKOUT).input(AEItems.BOXING_GLOVE).or().input(MSItems.INK_SQUID_PRO_QUO).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.MIDNIGHT_BRUISER).input(AEItems.NIGHTTIME_KNOCKOUT).or().input(MSItems.CREW_POSTER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.FORTUNES_HAND).input(AEItems.GAUNTLET).and().input(MSItems.EIGHTBALL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BOMBING_GLOVE).input(AEItems.BOXING_GLOVE).or().input(Items.TNT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.COBALT_CRYSTAL_PULVERIZER).input(AEItems.FORTUNES_HAND).or().input(Items.DIAMOND).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.MELTDOWN_MITT).input(AEItems.BOMBING_GLOVE).and().input(AEItems.NUCLEAR_WARHEAD).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CRYSTAL_CLAWED_DRAGON_GRIP).input(AEItems.COBALT_CRYSTAL_PULVERIZER).and().input(MSItems.SCALEMATE_APPLESCAB).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.LIGHTEST_TOUCH).input(AEItems.GAUNTLET).and().input(Items.PHANTOM_MEMBRANE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.MANEG).input(AEItems.GAUNTLET).and().input(MSItems.CUEBALL).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.FLINTLOCK_PISTOL).input(AEItems.FLINTLOCK_RIFLE).or().input(MSItems.MIRROR).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.FLARE_GUN).input(AEItems.FLINTLOCK_PISTOL).and().input(AEItems.FLARE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GAMMA_BLASTER).input(AEItems.FLARE_GUN).and().input(MSItems.RAW_URANIUM).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BREATH_BLASTER).input(AEItems.FLARE_GUN).and().input(Items.DRAGON_BREATH).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.NOXIOUS_BURST_CANNON).input(AEItems.BREATH_BLASTER).or().input(MSItems.FUNGAL_SPORE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.REVOLVER).input(AEItems.FLINTLOCK_PISTOL).and().input(MSItems.HOUSE_KEY).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SIXLET_SIXSHOOTER).input(AEItems.REVOLVER).or().input(MSItems.MERCURY_SIXLETS).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.DAPPLE_DEULY).input(AEItems.REVOLVER).and().input(MSItems.CRUMPLY_HAT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.LASER_PISTOL).input(AEItems.REVOLVER).and().input(AEItems.LASER_AMMO).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WYVERN_FIRE).input(AEItems.LASER_PISTOL).and().input(MSItems.SCALEMATE_APPLESCAB).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BERETTA).input(AEItems.REVOLVER).or().input(Items.BLACK_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.REGIPISTOL).input(AEItems.BERETTA).or().input(MSItems.CHESSBOARD).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.NETHERITE_KING_KILLER).input(AEItems.REGIPISTOL).and().input(Items.NETHERITE_INGOT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GOLDEN_GRIP).input(AEItems.BERETTA).and().input(Items.GOLD_INGOT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.FORESIGHT_DUELER).input(AEItems.GOLDEN_GRIP).or().input(MSItems.EIGHTBALL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GREEN_SUN_SLAMMER).input(AEItems.FORESIGHT_DUELER).or().input(AEItems.GREEN_SUN_BOOK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.WHITE_MAGNUM).input(AEItems.REVOLVER).and().input(MSItems.CUEBALL).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.APPEARIFIER_PISTOL).input(AEItems.LASER_PISTOL).or().input(MSItems.TRANSPORTALIZER).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.FLINTLOCK_RIFLE).input(AEItems.GUN_PARTS).and().input(Items.FLINT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.RIFLE).input(AEItems.FLINTLOCK_RIFLE).and().input(Items.LEATHER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GUNBLADE).input(AEItems.RIFLE).and().input(Items.IRON_SWORD).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.CANDY_CARBINE).input(AEItems.RIFLE).or().input(MSItems.CANDY_CORN).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLACK_ASSAULT_RIFLE).input(AEItems.RIFLE).and().input(Items.BLACK_DYE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GOLD_ASSAULT_RIFLE).input(AEItems.BLACK_ASSAULT_RIFLE).or().input(Items.GOLD_INGOT).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ENGLISH_EXECUTIONER).input(AEItems.GOLD_ASSAULT_RIFLE).and().input(AEItems.GREEN_SUN_BOOK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.SNIPER_RIFLE).input(AEItems.RIFLE).and().input(Items.SPYGLASS).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.REGIRIFLE).input(AEItems.SNIPER_RIFLE).or().input(MSItems.CHESSBOARD).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.LASER_RIFLE).input(AEItems.RIFLE).and().input(AEItems.LASER_AMMO).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.ANNIES_GOT_A_GUN).input(AEItems.RIFLE).or().input(MSItems.GAMEGRL_MAGAZINE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.MACHINE_GUN).input(AEItems.RIFLE).or().input(Items.REPEATER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GIRLS_BEST_FRIEND).input(AEItems.MACHINE_GUN).or().input(MSItems.CREW_POSTER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.GREEN_SUN_STREETSWEEPER).input(AEItems.GIRLS_BEST_FRIEND).or().input(AEItems.GREEN_SUN_BOOK).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.APPEARIFIER_RIFLE).input(AEItems.LASER_RIFLE).or().input(MSItems.TRANSPORTALIZER).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.BARBASOL_BOMB_LAUNCHER).input(AEItems.RIFLE).or().input(MSItems.BARBASOL_BOMB).buildFor(consumer, "alchemyexpanded");

        CombinationRecipeBuilder.of(AEItems.SHOTGUN).input(AEItems.GUN_PARTS).and().input(Items.BLAZE_POWDER).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BLUNDERBUSS).input(AEItems.SHOTGUN).or().input(AEItems.FLINTLOCK_RIFLE).buildFor(consumer, "alchemyexpanded");
        CombinationRecipeBuilder.of(AEItems.BOOMSTICK).input(AEItems.SHOTGUN).and().input(AEItems.CURSED_TAPE).buildFor(consumer, "alchemyexpanded");
    }
}
