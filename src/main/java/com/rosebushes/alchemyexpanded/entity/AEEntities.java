package com.rosebushes.alchemyexpanded.entity;

import com.mraof.minestuck.entity.item.BarbasolBombEntity;
import com.mraof.minestuck.entity.item.ConsumableProjectileEntity;
import com.rosebushes.alchemyexpanded.item.weapon.CandyYoYoWeaponItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class AEEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER;
    public static final Supplier<EntityType<YoYoProjectileEntity>> YOYO_PROJECTILE;
    public static final Supplier<EntityType<CandyYoYoProjectileEntity>> CANDY_YOYO_PROJECTILE;
    public static final Supplier<EntityType<FireYoYoProjectileEntity>> FIRE_YOYO_PROJECTILE;
    public static final Supplier<EntityType<ProjectileEntity>> BASIC_BULLET;
    public static final Supplier<EntityType<CandyProjectileEntity>> CANDY_BULLET;
    public static final Supplier<EntityType<TeleportProjectileEntity>> GREEN_SUN_BULLET;
    public static final Supplier<EntityType<FlareProjectileEntity>> FLARE_PROJECTILE;
    public static final Supplier<EntityType<EffectProjectileEntity>> EFFECT_BULLET;
    public static final Supplier<EntityType<EffectCloudProjectileEntity>> EFFECT_FLARE_PROJECTILE;
    public static final Supplier<EntityType<BarbasolBombProjectileEntity>> BARBASOL_BOMB_PROJECTILE;
    public static final Supplier<EntityType<AppearifierProjectileEntity>> APPEARIFIER_PROJECTILE;
    public static final Supplier<EntityType<CueballProjectileEntity>> CUEBALL_BULLET;

    static {
        REGISTER = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, "alchemyexpanded");

        YOYO_PROJECTILE = REGISTER.register("yoyo", () -> EntityType.Builder.<YoYoProjectileEntity>of(YoYoProjectileEntity::new, MobCategory.MISC).sized(0.75F, 0.75F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "yoyo")).toString()));
        CANDY_YOYO_PROJECTILE = REGISTER.register("candy_yoyo", () -> EntityType.Builder.<CandyYoYoProjectileEntity>of(CandyYoYoProjectileEntity::new, MobCategory.MISC).sized(0.75F, 0.75F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "candy_yoyo")).toString()));
        FIRE_YOYO_PROJECTILE = REGISTER.register("fire_yoyo", () -> EntityType.Builder.<FireYoYoProjectileEntity>of(FireYoYoProjectileEntity::new, MobCategory.MISC).sized(0.75F, 0.75F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "fire_yoyo").toString())));

        BASIC_BULLET = REGISTER.register("bullet", () -> EntityType.Builder.<ProjectileEntity>of(ProjectileEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "bullet")).toString()));
        CANDY_BULLET = REGISTER.register("candy_bullet", () -> EntityType.Builder.<CandyProjectileEntity>of(CandyProjectileEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "candy_bullet")).toString()));
        GREEN_SUN_BULLET = REGISTER.register("green_sun_bullet", () -> EntityType.Builder.<TeleportProjectileEntity>of(TeleportProjectileEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "green_sun_bullet")).toString()));
        FLARE_PROJECTILE = REGISTER.register("flare_projectile", () -> EntityType.Builder.<FlareProjectileEntity>of(FlareProjectileEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "flare_projectile")).toString()));
        EFFECT_BULLET = REGISTER.register("effect_bullet", () -> EntityType.Builder.<EffectProjectileEntity>of(EffectProjectileEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "effect_bullet")).toString()));
        EFFECT_FLARE_PROJECTILE = REGISTER.register("effect_flare_projectile", () -> EntityType.Builder.<EffectCloudProjectileEntity>of(EffectCloudProjectileEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "effect_flare_projectile")).toString()));
        BARBASOL_BOMB_PROJECTILE = REGISTER.register("barbasol_bomb_projectile", () -> EntityType.Builder.<BarbasolBombProjectileEntity>of(BarbasolBombProjectileEntity::new, MobCategory.MISC).sized(1.0F, 1.0F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "barbasol_bomb_projectile")).toString()));
        APPEARIFIER_PROJECTILE = REGISTER.register("appearifier_bullet", () -> EntityType.Builder.<AppearifierProjectileEntity>of(AppearifierProjectileEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "appearifier_bullet")).toString()));
        CUEBALL_BULLET = REGISTER.register("cueball_bullet", () -> EntityType.Builder.<CueballProjectileEntity>of(CueballProjectileEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setTrackingRange(64).setUpdateInterval(2).fireImmune().build((ResourceLocation.fromNamespaceAndPath("alchemyexpanded", "cueball_bullet")).toString()));
    }
}
