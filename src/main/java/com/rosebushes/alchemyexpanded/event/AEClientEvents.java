package com.rosebushes.alchemyexpanded.event;

import com.rosebushes.alchemyexpanded.client.util.AEKeyHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(
        value = {Dist.CLIENT},
        modid = "alchemyexpanded"
)
public class AEClientEvents {

    public AEClientEvents() {
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        AEKeyHandler.registerKeys(event);
    }

}
