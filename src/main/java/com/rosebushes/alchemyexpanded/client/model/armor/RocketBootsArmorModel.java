package com.rosebushes.alchemyexpanded.client.model.armor;

import com.rosebushes.alchemyexpanded.item.armor.RocketBootsArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RocketBootsArmorModel extends GeoModel<RocketBootsArmorItem> {
    public RocketBootsArmorModel() {
    }

    public ResourceLocation getModelResource(RocketBootsArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("minestuck", "geo/iron_lass_armor.geo.json");
    }

    public ResourceLocation getTextureResource(RocketBootsArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "textures/models/armor/rocket_boots.png");
    }

    public ResourceLocation getAnimationResource(RocketBootsArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("minestuck", "animations/iron_lass.animation.json");
    }
}
