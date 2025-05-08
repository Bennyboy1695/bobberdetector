package net.glad0s.bobberdetector.forge;

import net.glad0s.bobberdetector.BobberDetectorClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;

public class BobberDetectorClientImpl {

    public static void init() {
        BobberDetectorClient.init();
        MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, false, RenderHighlightEvent.Block.class, event -> {
            ClientLevel level = Minecraft.getInstance().level;
            BobberDetectorClient.onBlockHighlight(level.getBlockEntity(event.getTarget().getBlockPos()));
        });
    }
}
