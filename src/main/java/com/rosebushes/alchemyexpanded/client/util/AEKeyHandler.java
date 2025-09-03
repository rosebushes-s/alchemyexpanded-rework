package com.rosebushes.alchemyexpanded.client.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class AEKeyHandler {

    public static final String CATEGORY = "key.categories.alchemyexpanded";
    public static final String GUN_ZOOM = "key.alchemyexpanded.gun_zoom";
    public static KeyMapping zoomKey;

    public AEKeyHandler() {
    }

    public static void registerKeys(RegisterKeyMappingsEvent event) {
        if (zoomKey != null) {
            throw new IllegalStateException("Alchemy Expanded keys have already been registered!");
        } else {
            zoomKey = new KeyMapping(GUN_ZOOM, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, CATEGORY);
            event.register(zoomKey);
        }
    }
}
