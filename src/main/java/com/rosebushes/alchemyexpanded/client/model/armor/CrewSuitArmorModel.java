package com.rosebushes.alchemyexpanded.client.model.armor;

import com.rosebushes.alchemyexpanded.item.armor.CrewSuitItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CrewSuitArmorModel extends GeoModel<CrewSuitItem> {
    public CrewSuitArmorModel() {
    }

    public ResourceLocation getModelResource(CrewSuitItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "geo/skirt_clothes_model.geo.json");
    }

    public ResourceLocation getTextureResource(CrewSuitItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "textures/models/armor/crew_businesswear.png");
    }

    public ResourceLocation getAnimationResource(CrewSuitItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "animations/crew_businesswear.animation.json");
    }
}
