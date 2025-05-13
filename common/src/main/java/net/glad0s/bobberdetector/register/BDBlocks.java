package net.glad0s.bobberdetector.register;

import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.content.BobberDetectorBlock;
import net.glad0s.bobberdetector.content.entity.BobberDetectorBlockEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BDBlocks {

    private static final CreateRegistrate REGISTRATE = BobberDetector.registrate();

    public static final BlockEntry<BobberDetectorBlock> BASIC_BOBBER_BLOCK =
            REGISTRATE.block("bobber_detector", BobberDetectorBlock::new)
                    .initialProperties(() -> Blocks.DISPENSER)
                    .properties(p -> p.lightLevel(state -> state.getValue(BobberDetectorBlock.LIT) ? 5 : 0))
                    .blockEntity(BobberDetectorBlockEntity::new)
                    .build()
                    .blockstate(NonNullBiConsumer.noop())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, BlockTags.MINEABLE_WITH_PICKAXE)
                    .simpleItem()
                    .register();

/*    public static final BlockEntry<BobberDetectorBlock> ADVANCED_BOBBER_BLOCK =
            REGISTRATE.block("advanced_bobber_detector", BobberDetectorBlock::new)
                    .properties(p -> p.lightLevel(state -> state.getValue(BobberDetectorBlock.LIT) ? 5 : 0))
                    .blockEntity(BobberDetectorBlockEntity::new)
                    .build()
                    .blockstate(NonNullBiConsumer.noop())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, BlockTags.MINEABLE_WITH_PICKAXE)
                    .simpleItem()
                    .register();*/

    public static void init() {

    }
}
