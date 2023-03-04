package net.lichpunk.lichtweaks.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_SAMPLE = "key.category.lichtweaks.sample";
    public static final String KEY_FUNCTION_SAMPLE = "key.lichtweaks.function";

    public static final String C2S_FUNCTION_SAMPLE = "key.lichtweaks.c2s";

    public static final KeyMapping FUNCTION_KEY = new KeyMapping(KEY_FUNCTION_SAMPLE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_SAMPLE);

    public static final KeyMapping C2S_KEY = new KeyMapping(C2S_FUNCTION_SAMPLE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_EQUAL, KEY_CATEGORY_SAMPLE);

//    public static final KeyMapping MOUSE = new KeyMapping(KEY_FUNCTION_SAMPLE, KeyConflictContext.IN_GAME,
//            InputConstants.Type.MOUSE, GLFW., KEY_CATEGORY_SAMPLE);
}


