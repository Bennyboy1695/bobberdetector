package net.glad0s.bobberdetector.util;

import net.glad0s.bobberdetector.multiloader.Platform;
import net.minecraft.world.entity.Entity;

public class EntityUtils {

    public static boolean isEntityClientPlayer(Entity entity) {
        return Platform.Environment.getCurrent() == Platform.Environment.CLIENT && ClientPlayerUtil.isEntityPlayer(entity);
    }

    public static boolean isEntityDeployer(Entity entity) {
        return Platform.Environment.getCurrent() == Platform.Environment.SERVER && ServerPlayerUtil.isEntityDeployer(entity);
    }
}
