package net.glad0s.bobberdetector.register;

import com.tterrag.registrate.util.CreativeModeTabModifier;

public class BDCreativeTabs {

    public static void modifyTab(CreativeModeTabModifier modifier) {
        modifier.accept(
                BDBlocks.BASIC_BOBBER_BLOCK.get()
        );
/*        modifier.accept(
                BDBlocks.ADVANCED_BOBBER_BLOCK.get()
        );*/
    }
}
