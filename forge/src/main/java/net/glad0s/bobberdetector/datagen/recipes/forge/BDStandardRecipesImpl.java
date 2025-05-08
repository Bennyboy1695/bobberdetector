package net.glad0s.bobberdetector.datagen.recipes.forge;

import net.glad0s.bobberdetector.datagen.recipes.gen.GeneratedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public class BDStandardRecipesImpl {

    public static GeneratedRecipeBuilder create(Supplier<ItemLike> result) {
        return new GeneratedRecipeBuilderForge("/", result);
    }

    public static GeneratedRecipeBuilder create(ResourceLocation result) {
        return new GeneratedRecipeBuilderForge("/", result);
    }
}
