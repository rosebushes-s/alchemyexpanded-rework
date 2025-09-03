package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.Minestuck;
import com.rosebushes.alchemyexpanded.AlchemyExpanded;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AEDamage {
    public static final ResourceKey<DamageType> GUN = key("gun");
    public static final ResourceKey<DamageType> CUEBALL_GUN = key("cueball_gun");
    public static final ResourceKey<DamageType> LASER = key("laser");

    private static ResourceKey<DamageType> key(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, AlchemyExpanded.id(name));
    }

    private static Holder<DamageType> getType(RegistryAccess registryAccess, ResourceKey<DamageType> key) {
        return registryAccess.registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key);
    }

    public static DamageSource gun(RegistryAccess registryAccess) {
        return new DamageSource(getType(registryAccess, GUN));
    }

    public static DamageSource gun(RegistryAccess registryAccess, Entity shooter) {
        return new DamageSource(getType(registryAccess, GUN), shooter);
    }

    public static DamageSource gun(RegistryAccess registryAccess, Entity projectile, Entity shooter) {
        return new DamageSource(getType(registryAccess, GUN), projectile, shooter);
    }

    public static DamageSource cueballGun(RegistryAccess registryAccess) {
        return new DamageSource(getType(registryAccess, CUEBALL_GUN));
    }

    public static DamageSource cueballGun(RegistryAccess registryAccess, Entity shooter) {
        return new DamageSource(getType(registryAccess, CUEBALL_GUN), shooter);
    }

    public static DamageSource cueballGun(RegistryAccess registryAccess, Entity projectile, Entity shooter) {
        return new DamageSource(getType(registryAccess, CUEBALL_GUN), projectile, shooter);
    }

    public static DamageSource laser(RegistryAccess registryAccess) {
        return new DamageSource(getType(registryAccess, LASER));
    }

    public static DamageSource laser(RegistryAccess registryAccess, Entity shooter) {
        return new DamageSource(getType(registryAccess, LASER), shooter);
    }

    public static DamageSource laser(RegistryAccess registryAccess, Entity projectile, Entity shooter) {
        return new DamageSource(getType(registryAccess, LASER), projectile, shooter);
    }
}
