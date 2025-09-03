package com.rosebushes.alchemyexpanded.item.weapon;

import com.rosebushes.alchemyexpanded.entity.AEEntities;
import com.rosebushes.alchemyexpanded.entity.CandyYoYoProjectileEntity;
import com.rosebushes.alchemyexpanded.entity.YoYoProjectileEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CandyYoYoWeaponItem extends YoYoWeaponItem {
    public CandyYoYoWeaponItem(Properties properties, int dmg, int cooldown, int stringLength, Item item) {
        super(properties, dmg, cooldown, stringLength, item);
    }

    @Override
    public void yoYo(ServerPlayer playerIn, Level level, float damageMod) {
        CandyYoYoProjectileEntity yoyo = new CandyYoYoProjectileEntity((EntityType) AEEntities.CANDY_YOYO_PROJECTILE.get(), playerIn, level, (this.damage * damageMod), this.stringLength, 20);
        yoyo.setItem(new ItemStack(this.yoyoProj));
        yoyo.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 1.0F, 0.1F);
        yoyo.setNoGravity(true);

        level.addFreshEntity(yoyo);
    }
}
