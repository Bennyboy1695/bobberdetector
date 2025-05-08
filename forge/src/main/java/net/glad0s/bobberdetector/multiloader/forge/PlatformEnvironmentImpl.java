package net.glad0s.bobberdetector.multiloader.forge;

import net.glad0s.bobberdetector.multiloader.Platform;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class PlatformEnvironmentImpl {

    public static Platform.Environment getCurrent() {
        return FMLEnvironment.dist == Dist.CLIENT ? Platform.Environment.CLIENT : Platform.Environment.SERVER;
    }
}
