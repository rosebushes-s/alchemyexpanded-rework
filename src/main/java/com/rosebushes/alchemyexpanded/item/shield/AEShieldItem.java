package com.rosebushes.alchemyexpanded.item.shield;

import com.mraof.minestuck.item.weapon.MSToolType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.neoforge.common.ItemAbility;

public class AEShieldItem extends Item implements Equipable {
    protected final MSToolType toolType;
    protected final double attackBonus;
    protected final double armorRating;
    protected final double movementSpeedDebuff;

    public AEShieldItem(MSToolType toolType, Properties properties, double attackBonus, double armorRating, double movementSpeedDebuff) {
        super(properties);
        this.toolType = toolType;
        this.attackBonus = attackBonus;
        this.armorRating = armorRating;
        this.movementSpeedDebuff = movementSpeedDebuff;
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return this.toolType.hasAction(itemAbility);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BLOCK;
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        ItemAttributeModifiers attributes = ItemAttributeModifiers.EMPTY;

        attributes = attributes.withModifierAdded(Attributes.ATTACK_DAMAGE, new AttributeModifier(ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "shield_attack_bonus"), this.attackBonus, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND);
        attributes = attributes.withModifierAdded(Attributes.ARMOR, new AttributeModifier(ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "shield_armor_bonus"), this.armorRating, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND);
        attributes = attributes.withModifierAdded(Attributes.MOVEMENT_SPEED, new AttributeModifier(ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "shield_movement_bonus"), this.movementSpeedDebuff, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), EquipmentSlotGroup.HAND);

        return attributes;
    }
}
