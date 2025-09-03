package com.rosebushes.alchemyexpanded.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MagmaticArmorItem extends AEArmorItem {
    private final MobEffectInstance effect = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100);
    public MagmaticArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player playerIn) {
            if(playerIn.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof MagmaticArmorItem && playerIn.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof MagmaticArmorItem && playerIn.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof MagmaticArmorItem && playerIn.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof MagmaticArmorItem) {
                if(!playerIn.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                    playerIn.addEffect(new MobEffectInstance(effect));
                }
            }
        }
    }
}
