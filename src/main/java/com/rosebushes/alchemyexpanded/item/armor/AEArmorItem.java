package com.rosebushes.alchemyexpanded.item.armor;

import com.rosebushes.alchemyexpanded.client.model.armor.AEArmorModels;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class AEArmorItem extends ArmorItem {
    private final String texture;

    public AEArmorItem(Holder<ArmorMaterial> material, ArmorItem.Type type, Item.Properties properties) {
        this("", material, type, properties);
    }

    public AEArmorItem(String texture, Holder<ArmorMaterial> material, ArmorItem.Type type, Item.Properties properties) {
        super(material, type, properties);
        this.texture = texture;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (equipmentSlot == AEArmorItem.this.type.getSlot()) {
                    HumanoidModel<?> model = AEArmorModels.get(AEArmorItem.this);
                    if (model != null) {
                        model.rightLeg.visible = AEArmorItem.this.type == Type.LEGGINGS || AEArmorItem.this.type == Type.BOOTS;
                        model.leftLeg.visible = AEArmorItem.this.type == Type.LEGGINGS || AEArmorItem.this.type == Type.BOOTS;
                        model.body.visible = AEArmorItem.this.type == Type.CHESTPLATE;
                        model.leftArm.visible = AEArmorItem.this.type == Type.CHESTPLATE;
                        model.rightArm.visible = AEArmorItem.this.type == Type.CHESTPLATE;
                        model.head.visible = AEArmorItem.this.type == Type.HELMET;
                        model.hat.visible = AEArmorItem.this.type == Type.HELMET;
                        model.crouching = original.crouching;
                        model.riding = original.riding;
                        model.young = original.young;
                        model.rightArmPose = original.rightArmPose;
                        model.leftArmPose = original.leftArmPose;
                        return model;
                    }
                }

                return original;
            }
        });
    }

    @Nullable
    public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        ResourceLocation name = BuiltInRegistries.ITEM.getKey(this);
        String var10001 = this.texture.isEmpty() ? name.getPath() : this.texture;
        return name.withPath("textures/models/armor/" + var10001 + ".png");
    }
}
