package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.entity.underling.UnderlingEntity;
import com.mraof.minestuck.item.MSItems;
import com.rosebushes.alchemyexpanded.item.AEItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class CandyProjectileEntity extends ProjectileEntity {

    public CandyProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.CANDY_BULLET.get(), shooter, world);
    }

    public CandyProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    protected CandyProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    @Override
    protected void onProjectileHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();

        if(entity instanceof UnderlingEntity) {
            ((UnderlingEntity) entity).dropCandy = true;
        }
        super.onProjectileHitEntity(result);
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(AEItems.DUMMY_CANDY_BULLET.get());
    }
}
