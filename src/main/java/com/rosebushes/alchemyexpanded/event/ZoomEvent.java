package com.rosebushes.alchemyexpanded.event;

import com.rosebushes.alchemyexpanded.client.util.AEKeyHandler;
import com.rosebushes.alchemyexpanded.item.weapon.gun.ScopedGunWeaponItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;

@EventBusSubscriber(
        value = {Dist.CLIENT},
        modid = "alchemyexpanded"
)
public class ZoomEvent {
    public static final Minecraft mc = Minecraft.getInstance();
    protected static boolean shouldZoom;

    public ZoomEvent() {
    }

    @SubscribeEvent
    public static void onClientTickEvent(ClientTickEvent.Post event) {
        Player player = mc.player;

        if(player != null) {
            ItemStack itemInHand = player.getItemInHand(InteractionHand.MAIN_HAND);
            if (player.level().isClientSide()) {
                shouldZoom = AEKeyHandler.zoomKey.isDown() && itemInHand.getItem() instanceof ScopedGunWeaponItem;
            }
        }
    }

    @SubscribeEvent(
            priority = EventPriority.LOWEST
    )
    public static void onFOVEvent(ViewportEvent.ComputeFov event) {
        if(shouldZoom) {
            event.setFOV(event.getFOV() / 4);
        }
    }
}
