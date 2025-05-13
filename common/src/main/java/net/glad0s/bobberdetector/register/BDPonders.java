package net.glad0s.bobberdetector.register;

import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.createmod.catnip.registry.RegisteredObjectsHelper;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.ponder.BobberPonder;
import net.minecraft.resources.ResourceLocation;

public class BDPonders implements PonderPlugin {

    @Override
    public String getModId() {
        return BobberDetector.MOD_ID;
    }

    @Override
    public void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderTagRegistrationHelper<ItemProviderEntry<?,?>> HELPER = helper.withKeyFunction(RegisteredObjectsHelper::getKeyOrThrow);

        HELPER.addToTag(AllCreatePonderTags.REDSTONE)
                .add(BDBlocks.BASIC_BOBBER_BLOCK);
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> HELPER = helper.withKeyFunction(RegisteredObjectsHelper::getKeyOrThrow);
        HELPER.forComponents(BDBlocks.BASIC_BOBBER_BLOCK)
                        .addStoryBoard("bobber_detector_ponder", BobberPonder::bobberBasic, AllCreatePonderTags.REDSTONE);
    }
}
