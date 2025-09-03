package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.entity.underling.BasiliskEntity;
import com.mraof.minestuck.entity.underling.BasiliskPartEntity;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EffectProjectileEntity extends ProjectileEntity {
    protected MobEffectInstance effect;
    protected int duration;

    public EffectProjectileEntity(Level world, LivingEntity shooter) {
        this(AEEntities.EFFECT_BULLET.get(), shooter, world);
    }

    public EffectProjectileEntity(EntityType<? extends ProjectileEntity> type, Level world) {
        super(type, world);
    }

    protected EffectProjectileEntity(EntityType<? extends ProjectileEntity> type, LivingEntity shooter, Level world) {
        super(type, shooter, world);
    }

    @Override
    protected void onProjectileHitEntity(EntityHitResult raytrace) {
        super.onProjectileHitEntity(raytrace);
        Entity target = raytrace.getEntity();

        if(target instanceof BasiliskPartEntity) {
            BasiliskEntity basilisk = ((BasiliskPartEntity) target).getParent();
            if(!level().isClientSide()) {
                basilisk.addEffect(new MobEffectInstance(effect));
            }
        }
        if(target instanceof LivingEntity) {
            if(!level().isClientSide()) {
                ((LivingEntity) target).addEffect(new MobEffectInstance(effect));
            }
        }
    }

    @Override
    protected ParticleOptions getParticleTrail() {
        return ParticleTypes.EFFECT;
    }

    public void setEffect(MobEffectInstance effect){
        this.effect = effect;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
