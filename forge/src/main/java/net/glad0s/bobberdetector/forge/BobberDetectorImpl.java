package net.glad0s.bobberdetector.forge;

import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.datagen.forge.BDDatagenImpl;
import net.glad0s.bobberdetector.multiloader.Platform;
import net.glad0s.bobberdetector.register.BDBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

@Mod(BobberDetector.MOD_ID)
public final class BobberDetectorImpl {

    static IEventBus bus;

    public BobberDetectorImpl() {
        bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Run our common setup.
        BobberDetector.init();
        Platform.Environment.CLIENT.runIfCurrent(() -> BobberDetectorClientImpl::init);
        bus.addListener(EventPriority.LOWEST, BDDatagenImpl::gatherData);
    }

    public static void finalizeRegistrate() {
        BobberDetector.registrate().registerEventListeners(bus);
    }
}
