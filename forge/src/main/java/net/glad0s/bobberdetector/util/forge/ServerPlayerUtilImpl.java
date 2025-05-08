package net.glad0s.bobberdetector.util.forge;

import com.simibubi.create.content.kinetics.deployer.DeployerFakePlayer;
import net.minecraft.world.entity.Entity;

public class ServerPlayerUtilImpl {

    public static boolean isEntityDeployer(Entity original) {
        return original instanceof DeployerFakePlayer;
    }
}
