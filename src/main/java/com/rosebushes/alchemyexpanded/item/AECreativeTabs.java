package com.rosebushes.alchemyexpanded.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class AECreativeTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTER;
    public static final Supplier<CreativeModeTab> MAIN;
    public static final Supplier<CreativeModeTab> FOOD;
    public static final Supplier<CreativeModeTab> WEAPONS;
    public static final Supplier<CreativeModeTab> OUTFITS;

    public AECreativeTabs() {
    }

    private static void buildMainTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept((ItemLike) AEItems.GUN_PARTS.get());
        output.accept((ItemLike) AEItems.AMBER_CHUNK.get());
        output.accept((ItemLike) AEItems.BLUE_BEAUTY.get());
        output.accept((ItemLike) AEItems.CURSED_TAPE.get());
        output.accept((ItemLike) AEItems.SADAKOS_MIXING_BOWL.get());
        output.accept((ItemLike) AEItems.GREEN_SUN_BOOK.get());
        output.accept((ItemLike) AEItems.FLAY_DOH.get());
        output.accept((ItemLike) AEItems.RUST_DYE.get());
        output.accept((ItemLike) AEItems.BRONZE_DYE.get());
        output.accept((ItemLike) AEItems.JADE_DYE.get());
        output.accept((ItemLike) AEItems.INDIGO_DYE.get());
        output.accept((ItemLike) AEItems.VIOLET_DYE.get());
    }

    private static void buildFoodTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept((ItemLike) AEItems.DITO.get());
        output.accept((ItemLike) AEItems.DITO_DETRITUS.get());
        output.accept((ItemLike) AEItems.NUCLEAR_WARHEAD.get());
        output.accept((ItemLike) AEItems.CHICKEN_CLUB_SALAD.get());
        output.accept((ItemLike) AEItems.WIZARD_BERRIES.get());
        output.accept((ItemLike) AEItems.WIZARDBERRY_GUSHERS.get());
        output.accept((ItemLike) AEItems.HONEY_GUSHERS.get());
        output.accept((ItemLike) AEItems.MILK_GUSHERS.get());
    }

    private static void buildWeaponsTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept((ItemLike) AEItems.AMMO.get());
        output.accept((ItemLike) AEItems.FLARE.get());
        output.accept((ItemLike) AEItems.CROCKERCORP_AMMO.get());
        output.accept((ItemLike) AEItems.LASER_AMMO.get());

        output.accept((ItemLike) AEItems.COPPER_SHIELD.get());
        output.accept((ItemLike) AEItems.STEAM_POWERED_HYDROFAN.get());
        output.accept((ItemLike) AEItems.PYRE_PROTECTOR.get());
        output.accept((ItemLike) AEItems.ROSE_BRAMBLE_BUCKLER.get());
        output.accept((ItemLike) AEItems.RAZOR_SHIELD.get());
        output.accept((ItemLike) AEItems.POGO_SHIELD.get());
        output.accept((ItemLike) AEItems.REGISHIELD.get());

        output.accept((ItemLike) AEItems.CHICKEN_CLUB_STAR.get());

        output.accept((ItemLike) AEItems.COOKING_WITH_SADAKO.get());

        output.accept((ItemLike) AEItems.DRAGON_SAW.get());

        output.accept((ItemLike) AEItems.CARVED_WAND.get());
        output.accept((ItemLike) AEItems.RESIN_WAND.get());
        output.accept((ItemLike) AEItems.BREAK_AUGUR.get());
        output.accept((ItemLike) AEItems.ANVIL_AURAWAND.get());

        output.accept((ItemLike) AEItems.GHOST_IN_THE_MACHINE.get());

        output.accept((ItemLike) AEItems.TILDEATH_DO_US_PART.get());

        output.accept((ItemLike) AEItems.BELL_BAT.get());
        output.accept((ItemLike) AEItems.DEAD_RINGER.get());

        output.accept((ItemLike) AEItems.KEY.get());

        output.accept((ItemLike) AEItems.DEULING_BLADE.get());
        output.accept((ItemLike) AEItems.FRONTIER_AXE.get());
        output.accept((ItemLike) AEItems.ASHEN_CHAINSAW.get());
        output.accept((ItemLike) AEItems.BLACK_SCEPTER.get());
        output.accept((ItemLike) AEItems.GOLD_SCEPTER.get());
        output.accept((ItemLike) AEItems.GREEN_SUN_CUESTAFF.get());
        output.accept((ItemLike) AEItems.WHITE_WAND.get());

        //output.accept((ItemLike) AEItems.TOPAZ_QUARTET.get());
        //output.accept((ItemLike) AEItems.OPAL_DECATET.get());

        output.accept((ItemLike) AEItems.YOYO.get());
        output.accept((ItemLike) AEItems.ROSE_ROTATOR.get());
        output.accept((ItemLike) AEItems.ROLLUP_ROTATOR.get());
        output.accept((ItemLike) AEItems.CERULEAN_STACKS.get());
        output.accept((ItemLike) AEItems.WIZARD_SPINNER.get());
        output.accept((ItemLike) AEItems.FIRESCALE_THROWER.get());
        output.accept((ItemLike) AEItems.CARBON_ORACLE.get());
        output.accept((ItemLike) AEItems.REGIYOYO.get());
        output.accept((ItemLike) AEItems.DEATHS_COUNTERWEIGHT.get());
        output.accept((ItemLike) AEItems.ROTATIONAL_GENESIS.get());
        output.accept((ItemLike) AEItems.SPINNER_OF_THE_CYCLE.get());
        output.accept((ItemLike) AEItems.GREEN_SUN_SLEEPER.get());
        output.accept((ItemLike) AEItems.SUN_RISES.get());
        output.accept((ItemLike) AEItems.BLACK_DRAGON_DEATH_WHIRLER.get());
        output.accept((ItemLike) AEItems.OLWYN_LLINYNNOL.get());

        output.accept((ItemLike) AEItems.BOXING_GLOVE.get());
        output.accept((ItemLike) AEItems.KNUCKLE_DUSTER.get());
        output.accept((ItemLike) AEItems.REGIKNUCKLE.get());
        output.accept((ItemLike) AEItems.ROYAL_KNUCKLE.get());
        output.accept((ItemLike) AEItems.GAUNTLET.get());
        output.accept((ItemLike) AEItems.NIGHTTIME_KNOCKOUT.get());
        output.accept((ItemLike) AEItems.MIDNIGHT_BRUISER.get());
        output.accept((ItemLike) AEItems.FORTUNES_HAND.get());
        output.accept((ItemLike) AEItems.BOMBING_GLOVE.get());
        output.accept((ItemLike) AEItems.COBALT_CRYSTAL_PULVERIZER.get());
        output.accept((ItemLike) AEItems.MELTDOWN_MITT.get());
        output.accept((ItemLike) AEItems.CRYSTAL_CLAWED_DRAGON_GRIP.get());
        output.accept((ItemLike) AEItems.LIGHTEST_TOUCH.get());
        output.accept((ItemLike) AEItems.MANEG.get());

        output.accept((ItemLike) AEItems.FLINTLOCK_PISTOL.get());
        output.accept((ItemLike) AEItems.FLARE_GUN.get());
        output.accept((ItemLike) AEItems.GAMMA_BLASTER.get());
        output.accept((ItemLike) AEItems.BREATH_BLASTER.get());
        output.accept((ItemLike) AEItems.NOXIOUS_BURST_CANNON.get());
        output.accept((ItemLike) AEItems.REVOLVER.get());
        output.accept((ItemLike) AEItems.SIXLET_SIXSHOOTER.get());
        output.accept((ItemLike) AEItems.DAPPLE_DEULY.get());
        output.accept((ItemLike) AEItems.LASER_PISTOL.get());
        output.accept((ItemLike) AEItems.WYVERN_FIRE.get());
        output.accept((ItemLike) AEItems.BERETTA.get());
        output.accept((ItemLike) AEItems.REGIPISTOL.get());
        output.accept((ItemLike) AEItems.NETHERITE_KING_KILLER.get());
        output.accept((ItemLike) AEItems.GOLDEN_GRIP.get());
        output.accept((ItemLike) AEItems.FORESIGHT_DUELER.get());
        output.accept((ItemLike) AEItems.GREEN_SUN_SLAMMER.get());
        output.accept((ItemLike) AEItems.APPEARIFIER_PISTOL.get());
        output.accept((ItemLike) AEItems.WHITE_MAGNUM.get());
        output.accept((ItemLike) AEItems.FLINTLOCK_OF_ZILLYHAU.get());

        output.accept((ItemLike) AEItems.FLINTLOCK_RIFLE.get());
        output.accept((ItemLike) AEItems.SHOTGUN.get());
        output.accept((ItemLike) AEItems.BLUNDERBUSS.get());
        output.accept((ItemLike) AEItems.BOOMSTICK.get());
        output.accept((ItemLike) AEItems.RIFLE.get());
        output.accept((ItemLike) AEItems.GUNBLADE.get());
        output.accept((ItemLike) AEItems.CANDY_CARBINE.get());
        output.accept((ItemLike) AEItems.BLACK_ASSAULT_RIFLE.get());
        output.accept((ItemLike) AEItems.GOLD_ASSAULT_RIFLE.get());
        output.accept((ItemLike) AEItems.ENGLISH_EXECUTIONER.get());
        output.accept((ItemLike) AEItems.SNIPER_RIFLE.get());
        output.accept((ItemLike) AEItems.REGIRIFLE.get());
        output.accept((ItemLike) AEItems.LASER_RIFLE.get());
        output.accept((ItemLike) AEItems.ANNIES_GOT_A_GUN.get());
        output.accept((ItemLike) AEItems.BARBASOL_BOMB_LAUNCHER.get());
        output.accept((ItemLike) AEItems.MACHINE_GUN.get());
        output.accept((ItemLike) AEItems.GIRLS_BEST_FRIEND.get());
        output.accept((ItemLike) AEItems.GREEN_SUN_STREETSWEEPER.get());
        output.accept((ItemLike) AEItems.APPEARIFIER_RIFLE.get());
        output.accept((ItemLike) AEItems.BLUNDERBUSS_OF_ZILLYWIGH.get());
    }

    private static void buildOutfitsTab(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept((ItemLike) AEItems.SQUARE_GLASSES.get());
        output.accept((ItemLike) AEItems.ROUND_GLASSES.get());
        output.accept((ItemLike) AEItems.SHADES.get());
        output.accept((ItemLike) AEItems.ANIME_SHADES.get());

        output.accept((ItemLike) AEItems.WHITE_SHIRT.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_SPIROGRAPH.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_SPORK.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_HOUSE.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_CARD.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_PICKAXE.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_PORKCHOP.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_SWORD.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_SHULKER.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_SLIME_GHOST.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_SQUIDDLE.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_RECORD.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_DEVILBEAST.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_FRIGHTENING_BEAST.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_CAT.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_HAT.get());
        output.accept((ItemLike) AEItems.WHITE_SHIRT_SKULL.get());

        output.accept((ItemLike) AEItems.BLACK_SHIRT.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_HEARTS.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_CLUBS.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_DIAMONDS.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_SPADES.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_CANCER.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_ARIES.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_TAURUS.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_GEMINI.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_LEO.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_VIRGO.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_LIBRA.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_SCORPIO.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_SAGITTARIUS.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_CAPRICORN.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_AQUARIUS.get());
        output.accept((ItemLike) AEItems.BLACK_SHIRT_PISCES.get());

        output.accept((ItemLike) AEItems.SUIT_CHEST.get());
        output.accept((ItemLike) AEItems.SUIT_PANTS.get());
        output.accept((ItemLike) AEItems.SUIT_SHOES.get());
        output.accept((ItemLike) AEItems.SLIME_SUIT_CHEST.get());
        output.accept((ItemLike) AEItems.SLIME_SUIT_PANTS.get());
        output.accept((ItemLike) AEItems.WISE_GUY_SLIME_SUIT_CHEST.get());
        output.accept((ItemLike) AEItems.WISE_GUY_SLIME_SUIT_PANTS.get());

        output.accept((ItemLike) AEItems.CREW_TOP.get());
        output.accept((ItemLike) AEItems.CREW_SKIRT.get());
        output.accept((ItemLike) AEItems.CREW_BOOTS.get());
        output.accept((ItemLike) AEItems.TOP_OF_ECLECTICA.get());
        output.accept((ItemLike) AEItems.SKIRT_OF_ECLECTICA.get());
        output.accept((ItemLike) AEItems.SLIPPERS_OF_ECLECTICA.get());
        output.accept((ItemLike) AEItems.DEAD_SHUFFLE_TOP.get());
        output.accept((ItemLike) AEItems.DEAD_SHUFFLE_SKIRT.get());
        output.accept((ItemLike) AEItems.DEAD_SHUFFLE_BOOTS.get());

        output.accept((ItemLike) AEItems.ITEM_MAGNET_HELMET.get());
        output.accept((ItemLike) AEItems.GRIST_MAGNET_HELMET.get());
        output.accept((ItemLike) AEItems.SKAIANET_SNEAKERS.get());

        output.accept((ItemLike) AEItems.MAGMATIC_HELMET.get());
        output.accept((ItemLike) AEItems.MAGMATIC_CHESTPLATE.get());
        output.accept((ItemLike) AEItems.MAGMATIC_LEGGINGS.get());
        output.accept((ItemLike) AEItems.MAGMATIC_BOOTS.get());
    }

    static {
        REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "alchemyexpanded");
        MAIN = REGISTER.register("main", () -> CreativeModeTab.builder().title(Component.translatable("alchemyexpanded.item_group.main")).icon(() -> new ItemStack((ItemLike)AEItems.GREEN_SUN_BOOK.get())).displayItems(AECreativeTabs::buildMainTab).build());
        FOOD = REGISTER.register("food", () -> CreativeModeTab.builder().title(Component.translatable("alchemyexpanded.item_group.food")).icon(() -> new ItemStack((ItemLike)AEItems.DITO.get())).displayItems(AECreativeTabs::buildFoodTab).build());
        WEAPONS = REGISTER.register("weapons", () -> CreativeModeTab.builder().title(Component.translatable("alchemyexpanded.item_group.weapons")).icon(() -> new ItemStack((ItemLike)AEItems.ENGLISH_EXECUTIONER.get())).displayItems(AECreativeTabs::buildWeaponsTab).build());
        OUTFITS = REGISTER.register("outfits", () -> CreativeModeTab.builder().title(Component.translatable("alchemyexpanded.item_group.outfits")).icon(() -> new ItemStack((ItemLike)AEItems.WHITE_SHIRT_HOUSE.get())).displayItems(AECreativeTabs::buildOutfitsTab).build());
    }
}
