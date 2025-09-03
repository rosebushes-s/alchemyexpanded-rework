package com.rosebushes.alchemyexpanded.data;

import com.rosebushes.alchemyexpanded.entity.AEDamage;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AEDamageTypeProvider {
    public static final String GUN_MSG = "alchemyexpanded.gun";
    public static final String CUEBALL_GUN_MSG = "alchemyexpanded.cueball_gun";
    public static final String LASER_MSG = "alchemyexpanded.laser";

    public AEDamageTypeProvider() {

    }

    public static void register(BootstrapContext<DamageType> context) {
        context.register(AEDamage.GUN, new DamageType(GUN_MSG, DamageScaling.ALWAYS, 0.0F));
        context.register(AEDamage.CUEBALL_GUN, new DamageType(CUEBALL_GUN_MSG, DamageScaling.ALWAYS, 0.0F));
        context.register(AEDamage.LASER, new DamageType(LASER_MSG, DamageScaling.ALWAYS, 0.0F));
    }

    public static class Tags extends DamageTypeTagsProvider {
        public Tags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, provider, "alchemyexpanded", existingFileHelper);
        }

        protected void addTags(HolderLookup.Provider provider) {
            this.tag(DamageTypeTags.IS_PROJECTILE).add(AEDamage.GUN);
            this.tag(DamageTypeTags.IS_PROJECTILE).add(AEDamage.CUEBALL_GUN);
        }
    }
}
