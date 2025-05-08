package net.glad0s.bobberdetector.register;

import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.multiloader.Platform;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import static net.glad0s.bobberdetector.register.BDTags.NameSpace.COMMON;
import static net.glad0s.bobberdetector.register.BDTags.NameSpace.MOD;

public class BDTags {

    public static <T> TagKey<T> optionalTag(Registry<T> registry, ResourceLocation id) {
        return TagKey.create(registry.key(), id);
    }

    public static <T> TagKey<T> commonTag(Registry<T> registry, String path) {
        return optionalTag(registry, new ResourceLocation((Platform.getCurrent().equals(Platform.FORGE) ? "forge" : "c"), path));
    }

    public static TagKey<EntityType<?>> commonEntityTag(String path) {
        return commonTag(BuiltInRegistries.ENTITY_TYPE, path);
    }

    public static TagKey<Block> commonBlockTag(String path) {
        return commonTag(BuiltInRegistries.BLOCK, path);
    }

    public static TagKey<Item> commonItemTag(String path) {
        return commonTag(BuiltInRegistries.ITEM, path);
    }

    public static TagKey<Fluid> commonFluidTag(String path) {
        return commonTag(BuiltInRegistries.FLUID, path);
    }

    public enum NameSpace {

        MOD(BobberDetector.MOD_ID, false, true),
        COMMON(Platform.getCurrent() == Platform.FORGE ? "forge" : "c", false, true);

        public final String id;
        public final boolean optionalDefault;
        public final boolean alwaysDatagenDefault;

        NameSpace(String id) {
            this(id, true, false);
        }

        NameSpace(String id, boolean optionalDefault, boolean alwaysDatagenDefault) {
            this.id = id;
            this.optionalDefault = optionalDefault;
            this.alwaysDatagenDefault = alwaysDatagenDefault;
        }
    }

    public static TagKey<EntityType<?>> BOBBER_TAG = BDTags.commonEntityTag("bobber");

    public enum Entities {
        BOBBER(COMMON);

        public final TagKey<EntityType<?>> tag;
        public final boolean alwaysDatagen;

        Entities() {
            this(MOD);
        }

        Entities(NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        Entities(NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        Entities(NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, null, optional, alwaysDatagen);
        }

        Entities(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = new ResourceLocation(namespace.id, path == null ? BDLang.asId(name()) : path);
            if (optional) {
                tag = optionalTag(BuiltInRegistries.ENTITY_TYPE, id);
            } else {
                tag = TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), id);
            }
            this.alwaysDatagen = alwaysDatagen;
        }

        public boolean matches(EntityType<?> entityType) {
            return entityType.is(tag);
        }

        private static void init() {
        }
    }
}
