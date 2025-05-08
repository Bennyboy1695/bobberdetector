package net.glad0s.bobberdetector.register;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.content.entity.BobberDetectorBlockEntity;

public class BDBlockEntities {

    private static final CreateRegistrate REGISTRATE = BobberDetector.registrate();

    public static final BlockEntityEntry<BobberDetectorBlockEntity> BOBBER_BLOCK_ENTITY =
            REGISTRATE.blockEntity("bobber_detector", BobberDetectorBlockEntity::new)
                    .validBlocks(BDBlocks.BASIC_BOBBER_BLOCK/*, BDBlocks.ADVANCED_BOBBER_BLOCK*/)
                    .register();


    public static void init() {

    }
}
