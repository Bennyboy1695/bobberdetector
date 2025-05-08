package net.glad0s.bobberdetector.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ClientPlayerUtil {

    public static Player getPlayer(Entity original) {
        return Minecraft.getInstance().player;
    }

    public static boolean isEntityPlayer(Entity original) {
        return original instanceof LocalPlayer;
    }
}
