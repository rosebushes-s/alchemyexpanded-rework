package com.rosebushes.alchemyexpanded.client.model.armor;

import com.rosebushes.alchemyexpanded.item.armor.CrewSuitItem;
import com.rosebushes.alchemyexpanded.item.armor.DeadShuffleDressItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DeadShuffleDressArmorModel extends GeoModel<DeadShuffleDressItem> {
    public DeadShuffleDressArmorModel() {
    }

    public ResourceLocation getModelResource(DeadShuffleDressItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "geo/dead_shuffle_model.geo.json");
    }

    public ResourceLocation getTextureResource(DeadShuffleDressItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "textures/models/armor/dead_shuffle_dress.png");
    }

    public ResourceLocation getAnimationResource(DeadShuffleDressItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "animations/dead_shuffle_dress.animation.json");
    }
}
