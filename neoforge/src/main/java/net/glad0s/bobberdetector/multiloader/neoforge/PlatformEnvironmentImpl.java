package net.glad0s.bobberdetector.multiloader.neoforge;

import net.glad0s.bobberdetector.multiloader.Platform;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

public class PlatformEnvironmentImpl {

    public static Platform.Environment getCurrent() {
        return FMLEnvironment.dist == Dist.CLIENT ? Platform.Environment.CLIENT : Platform.Environment.SERVER;
    }
}
