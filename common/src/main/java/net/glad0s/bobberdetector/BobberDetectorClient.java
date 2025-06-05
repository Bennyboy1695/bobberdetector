package net.glad0s.bobberdetector;

import com.simibubi.create.AllSpecialTextures;
import net.createmod.catnip.outliner.Outliner;
import net.createmod.ponder.foundation.PonderIndex;
import net.glad0s.bobberdetector.content.entity.BobberDetectorBlockEntity;
import net.glad0s.bobberdetector.register.BDPonders;
import net.minecraft.world.level.block.entity.BlockEntity;

public class BobberDetectorClient {

    public static void init() {

    }

    public static void onBlockHighlight(BlockEntity target) {
        if (target instanceof BobberDetectorBlockEntity be) {
            Outliner.getInstance().chaseAABB(new Object(), be.getAffectedArea())
                    .colored(0xb2ffff)
                    .withFaceTexture(AllSpecialTextures.SELECTION)
                    .lineWidth(0.5f /16f);
        }
    }

    public static void clientInit() {
        PonderIndex.addPlugin(new BDPonders());
    }
}
