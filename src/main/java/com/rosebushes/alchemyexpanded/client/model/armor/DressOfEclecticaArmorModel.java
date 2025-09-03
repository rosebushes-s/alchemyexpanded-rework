package com.rosebushes.alchemyexpanded.client.model.armor;

import com.rosebushes.alchemyexpanded.item.armor.DressOfEclecticaItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DressOfEclecticaArmorModel extends GeoModel<DressOfEclecticaItem> {
    public DressOfEclecticaArmorModel() {
    }

    public ResourceLocation getModelResource(DressOfEclecticaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "geo/skirt_clothes_model.geo.json");
    }

    public ResourceLocation getTextureResource(DressOfEclecticaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "textures/models/armor/dress_of_eclectica.png");
    }

    public ResourceLocation getAnimationResource(DressOfEclecticaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "animations/dress_of_eclectica.animation.json");
    }
}
