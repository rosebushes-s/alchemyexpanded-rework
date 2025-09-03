package com.rosebushes.alchemyexpanded.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ItemMagnetArmorItem extends AEArmorItem {
    private final int radius;

    public ItemMagnetArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, int radius) {
        super(material, type, properties);
        this.radius = radius;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player) {
            if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof ItemMagnetArmorItem || player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ItemMagnetArmorItem || player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof ItemMagnetArmorItem || player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof ItemMagnetArmorItem) {
                AABB bound = player.getBoundingBox();
                AABB newBound = bound.inflate(radius);

                List<Entity> entities = level.getEntities(player, newBound);

                for (Entity i : entities) {
                    if (i instanceof ItemEntity item) {
                        if((player.getInventory().getSlotWithRemainingSpace(item.getItem()) != -1) || (player.getInventory().getFreeSlot() != -1)) {
                            if (!player.isCrouching() && !level.isClientSide()) {
                                item.setPos(player.getPosition(1));
                            }
                        }
                    }
                }
            }
        }
    }
}
