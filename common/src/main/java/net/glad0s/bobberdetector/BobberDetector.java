package net.glad0s.bobberdetector;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.createmod.catnip.lang.FontHelper;
import net.glad0s.bobberdetector.datagen.recipes.BDStandardRecipes;
import net.glad0s.bobberdetector.register.BDBlockEntities;
import net.glad0s.bobberdetector.register.BDBlocks;
import net.glad0s.bobberdetector.register.BDCreativeTabs;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public final class BobberDetector {
    public static final String MOD_ID = "bobberdetector";
    /**
     * For user-facing non-translatable display names
     */
    public static final String NAME = "BobberDetector";

    public static final Logger LOGGER = LoggerFactory.getLogger("BobberDetector");
    private static CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
            .setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                    .andThen(TooltipModifier.mapNull(KineticStats.create(item))));

    public static void init() {
        REGISTRATE.modifyCreativeModeTab(CreativeModeTabs.REDSTONE_BLOCKS, BDCreativeTabs::modifyTab);
        BDBlocks.init();
        BDBlockEntities.init();

        finalizeRegistrate();
    }

    public static void gatherData(DataGenerator.PackGenerator gen, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        gen.addProvider(output -> new BDStandardRecipes(output, lookupProvider));
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    @ExpectPlatform
    public static void finalizeRegistrate() {
        throw new AssertionError();
    }
}
