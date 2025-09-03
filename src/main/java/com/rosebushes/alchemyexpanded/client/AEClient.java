package com.rosebushes.alchemyexpanded.client;

import com.rosebushes.alchemyexpanded.AlchemyExpanded;
import com.rosebushes.alchemyexpanded.client.model.armor.AEArmorModels;
import com.rosebushes.alchemyexpanded.client.model.armor.ClothesArmorModel;
import com.rosebushes.alchemyexpanded.client.model.armor.GlassesArmorModel;
import com.rosebushes.alchemyexpanded.entity.*;
import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = AlchemyExpanded.MODID, value = Dist.CLIENT)
public class AEClient {
    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        registerShieldPropertyOverrides(AEItems.COPPER_SHIELD.get());
        registerShieldPropertyOverrides(AEItems.STEAM_POWERED_HYDROFAN.get());
        registerShieldPropertyOverrides(AEItems.PYRE_PROTECTOR.get());
        registerShieldPropertyOverrides(AEItems.ROSE_BRAMBLE_BUCKLER.get());
        registerShieldPropertyOverrides(AEItems.RAZOR_SHIELD.get());
        registerShieldPropertyOverrides(AEItems.POGO_SHIELD.get());
        registerShieldPropertyOverrides(AEItems.REGISHIELD.get());
        registerArmorModels();
    }

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AEEntities.YOYO_PROJECTILE.get(), (context) -> new ThrownItemRenderer<YoYoProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.CANDY_YOYO_PROJECTILE.get(), (context) -> new ThrownItemRenderer<CandyYoYoProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.FIRE_YOYO_PROJECTILE.get(), (context) -> new ThrownItemRenderer<FireYoYoProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.BASIC_BULLET.get(), (context) -> new ThrownItemRenderer<ProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.CANDY_BULLET.get(), (context) -> new ThrownItemRenderer<CandyProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.GREEN_SUN_BULLET.get(), (context) -> new ThrownItemRenderer<TeleportProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.FLARE_PROJECTILE.get(), (context) -> new ThrownItemRenderer<FlareProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.EFFECT_BULLET.get(), (context) -> new ThrownItemRenderer<EffectProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.EFFECT_FLARE_PROJECTILE.get(), (context) -> new ThrownItemRenderer<EffectCloudProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.BARBASOL_BOMB_PROJECTILE.get(), (context) -> new ThrownItemRenderer<BarbasolBombProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.APPEARIFIER_PROJECTILE.get(), (context) -> new ThrownItemRenderer<AppearifierProjectileEntity>(context));
        event.registerEntityRenderer(AEEntities.CUEBALL_BULLET.get(), (context) -> new ThrownItemRenderer<CueballProjectileEntity>(context));
    }

    private static void registerArmorModels() {
        HumanoidModel<?> clothesModel = new HumanoidModel(ClothesArmorModel.createBodyLayer().bakeRoot());
        HumanoidModel<?> glassesModel = new HumanoidModel(GlassesArmorModel.createBodyLayer().bakeRoot());
        HumanoidModel<?> armorModel = new HumanoidArmorModel(HumanoidArmorModel.createBodyLayer(new CubeDeformation(0.8F)).getRoot().bake(64, 32));

        AEArmorModels.register(AEItems.SQUARE_GLASSES.get(), glassesModel);
        AEArmorModels.register(AEItems.ROUND_GLASSES.get(), glassesModel);
        AEArmorModels.register(AEItems.SHADES.get(), glassesModel);
        AEArmorModels.register(AEItems.ANIME_SHADES.get(), glassesModel);

        AEArmorModels.register(AEItems.WHITE_SHIRT.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_SPIROGRAPH.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_SPORK.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_HOUSE.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_CARD.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_PICKAXE.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_PORKCHOP.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_SWORD.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_SHULKER.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_SLIME_GHOST.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_SQUIDDLE.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_RECORD.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_DEVILBEAST.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_FRIGHTENING_BEAST.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_CAT.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_HAT.get(), clothesModel);
        AEArmorModels.register(AEItems.WHITE_SHIRT_SKULL.get(), clothesModel);

        AEArmorModels.register(AEItems.BLACK_SHIRT.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_HEARTS.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_CLUBS.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_DIAMONDS.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_SPADES.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_CANCER.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_ARIES.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_TAURUS.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_GEMINI.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_LEO.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_VIRGO.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_LIBRA.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_SCORPIO.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_SAGITTARIUS.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_CAPRICORN.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_AQUARIUS.get(), clothesModel);
        AEArmorModels.register(AEItems.BLACK_SHIRT_PISCES.get(), clothesModel);

        AEArmorModels.register(AEItems.SUIT_CHEST.get(), clothesModel);
        AEArmorModels.register(AEItems.SUIT_PANTS.get(), clothesModel);
        AEArmorModels.register(AEItems.SUIT_SHOES.get(), clothesModel);
        AEArmorModels.register(AEItems.SLIME_SUIT_CHEST.get(), clothesModel);
        AEArmorModels.register(AEItems.SLIME_SUIT_PANTS.get(), clothesModel);
        AEArmorModels.register(AEItems.WISE_GUY_SLIME_SUIT_CHEST.get(), clothesModel);
        AEArmorModels.register(AEItems.WISE_GUY_SLIME_SUIT_PANTS.get(), clothesModel);

        AEArmorModels.register(AEItems.ITEM_MAGNET_HELMET.get(), armorModel);
        AEArmorModels.register(AEItems.GRIST_MAGNET_HELMET.get(), armorModel);
        AEArmorModels.register(AEItems.SKAIANET_SNEAKERS.get(), clothesModel);

        AEArmorModels.register(AEItems.MAGMATIC_HELMET.get(), armorModel);
        AEArmorModels.register(AEItems.MAGMATIC_CHESTPLATE.get(), armorModel);
        AEArmorModels.register(AEItems.MAGMATIC_LEGGINGS.get(), armorModel);
        AEArmorModels.register(AEItems.MAGMATIC_BOOTS.get(), armorModel);
    }

    public static void registerShieldPropertyOverrides(Item item)
    {
        ItemProperties.register(item, ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "blocking"), (stack, world, living, value) ->
        {
            return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0f : 0.0f;
        });
    }
}
