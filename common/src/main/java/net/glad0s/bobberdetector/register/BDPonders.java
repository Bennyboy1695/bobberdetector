package net.glad0s.bobberdetector.register;

import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
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
        PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.addToTag(AllCreatePonderTags.REDSTONE)
                .add(BDBlocks.BASIC_BOBBER_BLOCK);
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        helper.addStoryBoard(BDBlocks.BASIC_BOBBER_BLOCK.getId(), "bobber_detector_ponder", BobberPonder::bobberBasic, AllCreatePonderTags.REDSTONE);
    }
}
