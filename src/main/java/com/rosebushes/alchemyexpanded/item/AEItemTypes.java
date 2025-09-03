package com.rosebushes.alchemyexpanded.item;

import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.item.weapon.MSToolType;
import com.rosebushes.alchemyexpanded.AlchemyExpanded;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class AEItemTypes {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIAL_REGISTRY;
    public static final Holder<ArmorMaterial> CLOTHES_ARMOR;
    public static final Holder<ArmorMaterial> SUIT_ARMOR;
    public static final Holder<ArmorMaterial> SLIME_SUIT_ARMOR;
    public static final Holder<ArmorMaterial> WISE_GUY_SLIME_SUIT_ARMOR;
    public static final Holder<ArmorMaterial> ECLECTICA_ARMOR;
    public static final Holder<ArmorMaterial> DEAD_SHUFFLE_ARMOR;
    public static final Holder<ArmorMaterial> SHADES_ARMOR;
    public static final Holder<ArmorMaterial> MAGNET_ARMOR;
    public static final Holder<ArmorMaterial> ROCKET_ARMOR;
    public static final Holder<ArmorMaterial> MAGMATIC_ARMOR;
    public static final MSToolType SHIELD_TOOL_TYPE;

    public AEItemTypes() {
    }

    public static Holder<ArmorMaterial> registerArmorMaterial(String name, Map<ArmorItem.Type, Integer> damageReductionByType, int enchantability, Holder<SoundEvent> soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        return ARMOR_MATERIAL_REGISTRY.register(name, () -> new ArmorMaterial(damageReductionByType, enchantability, soundEvent, repairMaterial, List.of(new ArmorMaterial.Layer(AlchemyExpanded.id(name))), toughness, knockbackResistance));
    }

    static {
        ARMOR_MATERIAL_REGISTRY = DeferredRegister.create(Registries.ARMOR_MATERIAL, "alchemyexpanded");
        CLOTHES_ARMOR = registerArmorMaterial("clothes", Map.of(ArmorItem.Type.HELMET, 1, ArmorItem.Type.CHESTPLATE, 3, ArmorItem.Type.LEGGINGS, 2, ArmorItem.Type.BOOTS, 1), 6, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.of(new ItemLike[]{Items.WHITE_WOOL}));
        SUIT_ARMOR = registerArmorMaterial("suit", Map.of(ArmorItem.Type.HELMET, 1, ArmorItem.Type.CHESTPLATE, 3, ArmorItem.Type.LEGGINGS, 2, ArmorItem.Type.BOOTS, 1), 12, SoundEvents.ARMOR_EQUIP_LEATHER, 0.5F, 0.0F, () -> Ingredient.of(new ItemLike[]{Items.BLACK_WOOL}));
        SLIME_SUIT_ARMOR = registerArmorMaterial("slime_suit", Map.of(ArmorItem.Type.HELMET, 3, ArmorItem.Type.CHESTPLATE, 5, ArmorItem.Type.LEGGINGS, 4, ArmorItem.Type.BOOTS, 3), 16, SoundEvents.ARMOR_EQUIP_LEATHER, 1.0F, 0.0F, () -> Ingredient.of(new ItemLike[]{Items.SLIME_BALL}));
        WISE_GUY_SLIME_SUIT_ARMOR = registerArmorMaterial("wise_guy_slime_suit", Map.of(ArmorItem.Type.HELMET, 1, ArmorItem.Type.CHESTPLATE, 3, ArmorItem.Type.LEGGINGS, 2, ArmorItem.Type.BOOTS, 1), 6, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.1F, () -> Ingredient.of(new ItemLike[]{Items.SLIME_BALL}));
        ECLECTICA_ARMOR = registerArmorMaterial("eclectica", Map.of(ArmorItem.Type.HELMET, 2, ArmorItem.Type.CHESTPLATE, 4, ArmorItem.Type.LEGGINGS, 3, ArmorItem.Type.BOOTS, 2), 16, SoundEvents.ARMOR_EQUIP_LEATHER, 0.5F, 0.0F, () -> Ingredient.of(new ItemLike[]{Items.LAPIS_LAZULI}));
        DEAD_SHUFFLE_ARMOR = registerArmorMaterial("dead_shuffle", Map.of(ArmorItem.Type.HELMET, 3, ArmorItem.Type.CHESTPLATE, 5, ArmorItem.Type.LEGGINGS, 3, ArmorItem.Type.BOOTS, 3), 20, SoundEvents.ARMOR_EQUIP_LEATHER, 1.0F, 0.1F, () -> Ingredient.of(new ItemLike[]{Items.ROTTEN_FLESH}));
        SHADES_ARMOR = registerArmorMaterial("shades", Map.of(ArmorItem.Type.HELMET, 2, ArmorItem.Type.CHESTPLATE, 1, ArmorItem.Type.LEGGINGS, 1, ArmorItem.Type.BOOTS, 1), 20, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, () -> Ingredient.of(new ItemLike[]{Items.BLACK_STAINED_GLASS}));
        MAGNET_ARMOR = registerArmorMaterial("magnet", Map.of(ArmorItem.Type.HELMET, 2, ArmorItem.Type.CHESTPLATE, 4, ArmorItem.Type.LEGGINGS, 3, ArmorItem.Type.BOOTS, 2), 5, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, () -> Ingredient.of(new ItemLike[]{Items.IRON_INGOT}));
        ROCKET_ARMOR = registerArmorMaterial("rocket", Map.of(ArmorItem.Type.HELMET, 2, ArmorItem.Type.CHESTPLATE, 4, ArmorItem.Type.LEGGINGS, 3, ArmorItem.Type.BOOTS, 2), 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(new ItemLike[]{Items.FIREWORK_ROCKET}));
        MAGMATIC_ARMOR = registerArmorMaterial("magmatic", Map.of(ArmorItem.Type.HELMET, 4, ArmorItem.Type.CHESTPLATE, 6, ArmorItem.Type.LEGGINGS, 5, ArmorItem.Type.BOOTS, 4), 24, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.5F, 0.0F, () -> Ingredient.of(new ItemLike[]{Items.MAGMA_CREAM}));
        SHIELD_TOOL_TYPE = new MSToolType(null, ItemAbilities.SHIELD_BLOCK);
    }
}
