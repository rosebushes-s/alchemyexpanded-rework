package com.rosebushes.alchemyexpanded.item.weapon;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.rosebushes.alchemyexpanded.item.components.AEItemComponents;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

public class GloveWeaponItem extends Item {
    private final int meleeDamage;
    private final float attackSpeed;
    private final MobEffectInstance knockoutEffect;
    private final ItemAttributeModifiers modifiers;

    public GloveWeaponItem(Properties properties, int atkDamage, float atkSpeed, Holder<MobEffect> effect) {
        super(properties);
        this.meleeDamage = atkDamage;
        this.attackSpeed = atkSpeed;
        this.knockoutEffect = new MobEffectInstance(effect, 80, 2);

        ItemAttributeModifiers tempModifiers = ItemAttributeModifiers.EMPTY;
        tempModifiers = tempModifiers.withModifierAdded(Attributes.ATTACK_DAMAGE, new AttributeModifier(ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "glove_attack_modifier"), (double)this.meleeDamage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND);
        tempModifiers = tempModifiers.withModifierAdded(Attributes.ATTACK_SPEED, new AttributeModifier(ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "glove_attack_speed_modifier"), (double)this.attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND);

        modifiers = tempModifiers;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(getComboTimer(stack) >= 80) {
            setComboTimer(stack, 0);
            setHitCount(stack, 0);
        }

        if(getComboTimer(stack) > 0) {
            setComboTimer(stack, (getComboTimer(stack) + 1));
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(getComboTimer(stack) < 80 && getComboTimer(stack) > 0) {
            if(getHitCount(stack) >= 5) {
                boolean playerDamage = attacker instanceof Player ? target.hurt(attacker.damageSources().playerAttack((Player)attacker), this.meleeDamage * 2.0F) : target.hurt(attacker.damageSources().mobAttack(attacker), this.meleeDamage * 1.5F);
                doKnockoutExtras(stack, target, attacker);
                if(playerDamage) {
                    Player player = (Player)attacker;
                    target.addEffect(new MobEffectInstance(knockoutEffect));
                    player.displayClientMessage(Component.translatable("message.alchemyexpanded.glove.combo_max"), true);
                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.0F, 0.8F);
                }
                setHitCount(stack, 0);
                setComboTimer(stack, 0);
            }
            else {
                setHitCount(stack, getHitCount(stack) + 1);
            }
        }
        else {
            setComboTimer(stack, 1);
            setHitCount(stack, getHitCount(stack) + 1);
        }

        if(attacker instanceof Player player) {
            stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    public void doKnockoutExtras(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!target.level().isClientSide) {
            target.level().explode(attacker, target.getX(), target.getY(), target.getZ(), 2, Level.ExplosionInteraction.NONE);
        }
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        return this.modifiers;
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    private void setHitCount(ItemStack stack, int amount) {
        stack.set(AEItemComponents.GLOVE_HIT_COUNT, amount);
    }

    private int getHitCount(ItemStack stack) {
        return stack.getOrDefault(AEItemComponents.GLOVE_HIT_COUNT, 0);
    }

    private void setComboTimer(ItemStack stack, int amount) {
        stack.set(AEItemComponents.GLOVE_COMBO_TIMER, amount);
    }

    private int getComboTimer(ItemStack stack) {
        return stack.getOrDefault(AEItemComponents.GLOVE_COMBO_TIMER, 0);
    }

    public int getMeleeDamage() {
        return this.meleeDamage;
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }
}
