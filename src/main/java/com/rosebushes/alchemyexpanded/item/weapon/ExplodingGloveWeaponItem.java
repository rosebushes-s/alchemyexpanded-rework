package com.rosebushes.alchemyexpanded.item.weapon;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExplodingGloveWeaponItem extends GloveWeaponItem {
    private final int explosionRadius;
    public ExplodingGloveWeaponItem(Properties properties, int atkDamage, float atkSpeed, Holder<MobEffect> effect, int radius) {
        super(properties, atkDamage, atkSpeed, effect);
        this.explosionRadius = radius;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!target.level().isClientSide) {
            target.level().explode((Entity)null, target.getX(), target.getY(), target.getZ(), this.explosionRadius, Level.ExplosionInteraction.NONE);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
