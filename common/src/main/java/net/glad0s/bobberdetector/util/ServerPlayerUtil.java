package net.glad0s.bobberdetector.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ServerPlayerUtil {

    public static Player getPlayer(Entity original) {
        return (Player) original;
    }

    @ExpectPlatform
    public static boolean isEntityDeployer(Entity original) {
        throw new AssertionError("Should never appear!");
    }
}
