package net.glad0s.bobberdetector.datagen;

import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.register.BDTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class BDTagGen {

    public static void addGenerators() {
        BobberDetector.registrate().addDataGenerator(ProviderType.ENTITY_TAGS, BDTagGen::genEntityTags);
    }

    private static void genEntityTags(RegistrateTagsProvider<EntityType<?>> provIn) {
        TagGen.CreateTagsProvider<EntityType<?>> prov = new TagGen.CreateTagsProvider<>(provIn, EntityType::builtInRegistryHolder);
        prov.tag(TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), BDTags.Entities.BOBBER.tag.location()))
                .add(EntityType.FISHING_BOBBER)
                .addOptional(ResourceLocation.tryBuild("netherdepthsupgrade","lava_fishing_bobber"))
                .addOptional(ResourceLocation.tryBuild("aquaculture","bobber"));
    }
}
