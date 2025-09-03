package com.rosebushes.alchemyexpanded.util;

import com.mraof.minestuck.Minestuck;
import com.rosebushes.alchemyexpanded.AlchemyExpanded;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AESoundEvents {
    public static final DeferredRegister<SoundEvent> REGISTER;
    public static final Supplier<SoundEvent> BASIC_GUNSHOT;
    public static final Supplier<SoundEvent> BASIC_GUN_RELOAD;
    public static final Supplier<SoundEvent> LASER;

    public AESoundEvents() {
    }

    private static Supplier<SoundEvent> register(String name) {
        return REGISTER.register(name, () -> SoundEvent.createVariableRangeEvent(AlchemyExpanded.id(name)));
    }

    static {
        REGISTER = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, "alchemyexpanded");
        BASIC_GUNSHOT = register("item.gun.shoot");
        BASIC_GUN_RELOAD = register("item.gun.reload");
        LASER = register("item.gun.laser");
    }
}
