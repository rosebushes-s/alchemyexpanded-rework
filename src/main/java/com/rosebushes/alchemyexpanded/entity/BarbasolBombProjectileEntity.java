package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.item.MSItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BarbasolBombProjectileEntity extends ExplodingProjectileEntity {

    public BarbasolBombProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.BARBASOL_BOMB_PROJECTILE.get(), shooter, world);
    }

    public BarbasolBombProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    public BarbasolBombProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(MSItems.BARBASOL_BOMB.get());
    }
}
