package com.rosebushes.alchemyexpanded.client.model.armor;

import com.rosebushes.alchemyexpanded.item.armor.AEArmorItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class AEArmorModels {
    private static final Map<ResourceLocation, HumanoidModel<?>> map = new HashMap();

    public AEArmorModels() {
    }

    public static void register(Item item, HumanoidModel<?> model) {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        if (map.containsKey(itemId)) {
            throw new IllegalArgumentException("A model has already been registered with this item.");
        } else {
            map.put(itemId, model);
        }
    }

    @Nullable
    public static HumanoidModel<?> get(Item item) {
        return (HumanoidModel)map.get(BuiltInRegistries.ITEM.getKey(item));
    }
}
