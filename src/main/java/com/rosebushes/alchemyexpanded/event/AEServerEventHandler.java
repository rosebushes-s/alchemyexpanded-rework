package com.rosebushes.alchemyexpanded.event;

import com.rosebushes.alchemyexpanded.entity.CueballProjectileEntity;
import com.rosebushes.alchemyexpanded.entity.ProjectileEntity;
import com.rosebushes.alchemyexpanded.entity.TeleportProjectileEntity;
import com.rosebushes.alchemyexpanded.item.armor.SkaianetSneakersArmorItem;
import com.rosebushes.alchemyexpanded.item.shield.AEShieldItem;
import com.rosebushes.alchemyexpanded.item.shield.DamagingShieldItem;
import com.rosebushes.alchemyexpanded.item.shield.FireShieldItem;
import com.rosebushes.alchemyexpanded.item.shield.PogoShieldItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;

import java.util.UUID;

@EventBusSubscriber(
        modid = "alchemyexpanded"
)
public class AEServerEventHandler {
    private static boolean hitByGun;
    private static final AttributeModifier STEP_MODIFIER = new AttributeModifier(ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "step_height_increase"), 1.0, AttributeModifier.Operation.ADD_VALUE);
    private static final AttributeModifier SPEED_MODIFIER = new AttributeModifier(ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "walk_speed_increase"), 0.05, AttributeModifier.Operation.ADD_VALUE);

    public AEServerEventHandler() {

    }

    @SubscribeEvent (
            priority = EventPriority.HIGHEST
    )
    public static void onEntityDamagedEvent (LivingIncomingDamageEvent event) {
        DamageSource source = event.getEntity().getLastDamageSource();

        if(source.getDirectEntity() instanceof ProjectileEntity || source.getDirectEntity() instanceof TeleportProjectileEntity || source.getDirectEntity() instanceof CueballProjectileEntity) {
            hitByGun = true;
        }
    }

    public static boolean wasHitByGun() {
        return hitByGun;
    }

    @SubscribeEvent (
            priority = EventPriority.LOWEST
    )
    public static void onEntityKnockbackEvent (LivingKnockBackEvent event) {
        if(wasHitByGun()) {
            event.setStrength(0.0F);
            hitByGun = false;
        }
    }

    @SubscribeEvent
    public static void onItemAttributeModifierEvent(ItemAttributeModifierEvent event) {
        if(event.getItemStack().getEquipmentSlot() != null && event.getItemStack().getEquipmentSlot().equals(EquipmentSlot.FEET)) {
            if(event.getItemStack().getItem() instanceof SkaianetSneakersArmorItem) {
                event.addModifier(Attributes.STEP_HEIGHT.getDelegate(), STEP_MODIFIER, EquipmentSlotGroup.FEET);
                event.addModifier(Attributes.MOVEMENT_SPEED.getDelegate(), SPEED_MODIFIER, EquipmentSlotGroup.FEET);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingAttackEvent(LivingIncomingDamageEvent event) {
        float damage = event.getAmount();

        if(event.getEntity() instanceof Player player) {
            Entity sourceEntity = event.getSource().getDirectEntity();

            if(!player.getUseItem().isEmpty() && player.getUseItem().getItem() instanceof AEShieldItem && sourceEntity != null) {
                ItemStack shield = player.getUseItem();

                if(damage >= 3.0F && !shield.isEmpty() && sourceEntity instanceof LivingEntity) {
                    if(player.getUsedItemHand() == InteractionHand.MAIN_HAND) {
                        shield.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                    }
                    else {
                        shield.hurtAndBreak(1, player, EquipmentSlot.OFFHAND);
                    }
                }

                if(sourceEntity instanceof LivingEntity livingAttacker) {
                    if(shield.getItem() instanceof FireShieldItem) {
                        livingAttacker.setRemainingFireTicks(5);
                    }

                    if(shield.getItem() instanceof DamagingShieldItem) {
                        livingAttacker.hurt(player.damageSources().playerAttack(player), damage / 10);
                    }

                    if(shield.getItem() instanceof PogoShieldItem) {
                        livingAttacker.setDeltaMovement(livingAttacker.getLookAngle().reverse().scale(0.5));
                    }
                }
            }
        }
    }
}
