package net.glad0s.bobberdetector.datagen.recipes;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.glad0s.bobberdetector.datagen.recipes.gen.BobberDetectorRecipeProvider;
import net.glad0s.bobberdetector.datagen.recipes.gen.GeneratedRecipeBuilder;
import net.glad0s.bobberdetector.multiloader.Platform;
import net.glad0s.bobberdetector.register.BDBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class BDStandardRecipes extends BobberDetectorRecipeProvider {

    GeneratedRecipeBuilder.GeneratedRecipe BOBBER_DETECTOR = create(BDBlocks.BASIC_BOBBER_BLOCK)
            .unlockedBy(() -> Items.FISHING_ROD)
            .viaShaped(builder -> builder
                    .pattern("AFA")
                    .pattern("R#R")
                    .pattern("ARA")
                    .define('A', AllItems.ANDESITE_ALLOY)
                    .define('F', Items.FISHING_ROD)
                    .define('R', Items.REDSTONE)
                    .define('#', AllBlocks.SMART_OBSERVER));

    @ExpectPlatform
    static GeneratedRecipeBuilder create(Supplier<ItemLike> result) {
        throw new AssertionError();
    }

    @ExpectPlatform
    static GeneratedRecipeBuilder create(ResourceLocation result) {
        throw new AssertionError();
    }

    static GeneratedRecipeBuilder create(ItemProviderEntry<? extends ItemLike, ?> result) {
        return create(result::get);
    }

    static GeneratedRecipeBuilder create(ItemLike result) {
        return create(() -> result);
    }

    public BDStandardRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public enum TaggedIngredients {
        ;

        private final TagKey<Item> forge;
        private final TagKey<Item> fabric;

        TaggedIngredients(TagKey<Item> forge, TagKey<Item> fabric) {
            this.forge = forge;
            this.fabric = fabric;
        }

        public TagKey<Item> getTag() {
            return Platform.getCurrent().equals(Platform.NEOFORGE) ? this.forge : this.fabric;
        }
    }
}
