package com.rosebushes.alchemyexpanded.item.weapon;

import com.rosebushes.alchemyexpanded.util.DiceEffectHelper;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DiceWeaponItem extends Item {
    protected int diceAmount;
    protected int diceValue;
    protected int diceDamage;
    protected boolean enchanted;

    public DiceWeaponItem(Properties properties, int amount, int value, int damage, boolean enchanted) {
        super(properties);
        this.diceAmount = amount;
        this.diceValue = value;
        this.diceDamage = damage;
        this.enchanted = enchanted;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        DiceEffectHelper dice = new DiceEffectHelper();

        float damage = dice.getDiceDamage(diceAmount, diceValue, diceDamage, attacker, target, enchanted);
        if(attacker instanceof Player) {
            target.hurt(attacker.damageSources().playerAttack((Player)attacker), damage);
        }
        else {
            target.hurt(attacker.damageSources().mobAttack(attacker), damage);
        }
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }
}
