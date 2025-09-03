package com.rosebushes.alchemyexpanded.client.util;

import com.mraof.minestuck.util.MSSoundEvents;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;

public class BulletEffect {
    public BulletEffect() {

    }

    public static void rangedCollisionEffect(ParticleOptions particle, boolean explosiveFinish, ClientLevel level, Vec3 vecPos) {
        int particles = 25 + level.random.nextInt(10);
        if (explosiveFinish) {
            level.addParticle(ParticleTypes.FLASH, vecPos.x, vecPos.y, vecPos.z, (double)0.0F, (double)0.0F, (double)0.0F);

            for(int a = 0; a < particles; ++a) {
                level.addParticle(particle, true, vecPos.x, vecPos.y, vecPos.z, level.random.nextGaussian() * 0.12, level.random.nextGaussian() * 0.12, level.random.nextGaussian() * 0.12);
            }
        } else {
            for(int a = 0; a < particles; ++a) {
                level.addParticle(ParticleTypes.CRIT, true, vecPos.x, vecPos.y, vecPos.z, level.random.nextGaussian(), level.random.nextGaussian(), level.random.nextGaussian());
            }
        }

    }
}
