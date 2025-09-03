package com.rosebushes.alchemyexpanded.item.armor;

import com.mraof.minestuck.entity.item.GristEntity;
import com.mraof.minestuck.player.GristCache;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class GristMagnetArmorItem extends AEArmorItem {
    private final int radius;
    public GristMagnetArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, int radius) {
        super(material, type, properties);
        this.radius = radius;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player) {
            if(player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GristMagnetArmorItem || player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GristMagnetArmorItem || player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GristMagnetArmorItem || player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GristMagnetArmorItem) {
                AABB bound = player.getBoundingBox();
                AABB newBound = bound.inflate(radius);

                List<Entity> entities = level.getEntities(player, newBound);

                for (Entity i : entities) {
                    if (i instanceof GristEntity grist) {
                        if(!player.isCrouching()) {
                            if (player instanceof ServerPlayer serverPlayer) {
                                long gristRemain = GristCache.get(serverPlayer).getRemainingCapacity(grist.getGristType());
                                if (gristRemain > 0L) {
                                    grist.setPos(player.getPosition(1));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
