package com.rosebushes.alchemyexpanded.item.weapon;

import com.rosebushes.alchemyexpanded.entity.AEEntities;
import com.rosebushes.alchemyexpanded.entity.FireYoYoProjectileEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FireYoYoWeaponItem extends YoYoWeaponItem {
    public FireYoYoWeaponItem(Properties properties, int dmg, int cooldown, int stringLength, Item item) {
        super(properties, dmg, cooldown, stringLength, item);
    }

    @Override
    public void yoYo(ServerPlayer playerIn, Level level, float damageMod) {
        FireYoYoProjectileEntity yoyo = new FireYoYoProjectileEntity((EntityType) AEEntities.FIRE_YOYO_PROJECTILE.get(), playerIn, level, (this.damage * damageMod), this.stringLength, 20);
        yoyo.setItem(new ItemStack(this.yoyoProj));
        yoyo.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 1.0F, 0.1F);
        yoyo.setNoGravity(true);

        level.addFreshEntity(yoyo);
    }
}
