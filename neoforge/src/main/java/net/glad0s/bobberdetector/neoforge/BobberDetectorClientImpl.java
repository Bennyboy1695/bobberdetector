package net.glad0s.bobberdetector.neoforge;

import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.BobberDetectorClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = BobberDetector.MOD_ID, dist = Dist.CLIENT)
public class BobberDetectorClientImpl {

    public BobberDetectorClientImpl(FMLModContainer modContainer, IEventBus eventBus) {
        BobberDetectorClient.init();
        NeoForge.EVENT_BUS.addListener(EventPriority.NORMAL, false, RenderHighlightEvent.Block.class, event -> {
            ClientLevel level = Minecraft.getInstance().level;
            BobberDetectorClient.onBlockHighlight(level.getBlockEntity(event.getTarget().getBlockPos()));
        });
        eventBus.addListener(this::clientInit);
    }

    public void clientInit(final FMLClientSetupEvent event) {
     BobberDetectorClient.clientInit();
    }
}
