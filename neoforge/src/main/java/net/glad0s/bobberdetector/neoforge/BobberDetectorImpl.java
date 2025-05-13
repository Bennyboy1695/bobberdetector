package net.glad0s.bobberdetector.neoforge;

import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.datagen.neoforge.BDDatagenImpl;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = BobberDetector.MOD_ID)
public final class BobberDetectorImpl {

    static IEventBus bus;

    public BobberDetectorImpl(IEventBus modBus, ModContainer container) {
        bus = modBus;
        // Run our common setup.
        BobberDetector.init();
        bus.addListener(EventPriority.LOWEST, BDDatagenImpl::gatherData);
    }

    public static void finalizeRegistrate() {
        BobberDetector.registrate().registerEventListeners(bus);
    }
}
