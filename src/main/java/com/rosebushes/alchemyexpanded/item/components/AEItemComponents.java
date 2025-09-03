package com.rosebushes.alchemyexpanded.item.components;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.xml.crypto.Data;
import java.util.function.Supplier;

public final class AEItemComponents {
    public static final DeferredRegister.DataComponents REGISTRY;
    public static final Supplier<DataComponentType<Integer>> GLOVE_HIT_COUNT;
    public static final Supplier<DataComponentType<Integer>> GLOVE_COMBO_TIMER;
    public static final Supplier<DataComponentType<Integer>> GUN_COOLDOWN_FIRE;
    public static final Supplier<DataComponentType<Integer>> GUN_COOLDOWN_RELOAD;
    public static final Supplier<DataComponentType<Integer>> GUN_AMMO_COUNT;
    public static final Supplier<DataComponentType<Integer>> TIME_SINCE_FIRED;
    public static final Supplier<DataComponentType<Double>> PROJECTILE_DAMAGE;

    public AEItemComponents() {

    }

    static {
        REGISTRY = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, "alchemyexpanded");
        GLOVE_HIT_COUNT = REGISTRY.registerComponentType("glove_hit_count", (builder) -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));
        GLOVE_COMBO_TIMER = REGISTRY.registerComponentType("glove_combo_timer", (builder) -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));
        GUN_COOLDOWN_FIRE = REGISTRY.registerComponentType("gun_cooldown_fire", (builder) -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));
        GUN_COOLDOWN_RELOAD = REGISTRY.registerComponentType("gun_cooldown_reload", (builder) -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));
        GUN_AMMO_COUNT = REGISTRY.registerComponentType("gun_ammo_count", (builder) -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));
        TIME_SINCE_FIRED = REGISTRY.registerComponentType("time_since_fired", (builder) -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));
        PROJECTILE_DAMAGE = REGISTRY.registerComponentType("projectile_damage", (builder) -> builder.persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE));
    }
}
