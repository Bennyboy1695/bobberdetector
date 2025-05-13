package net.glad0s.bobberdetector.datagen.recipes.gen;

import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.datagen.recipes.gen.GeneratedRecipeBuilder.GeneratedRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class BobberDetectorRecipeProvider extends RecipeProvider {

    protected static final List<GeneratedRecipe> all = new ArrayList<>();

    public BobberDetectorRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static GeneratedRecipe register(GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }

    @Override
    public void buildRecipes(@NotNull RecipeOutput output) {
        all.forEach(recipe -> recipe.register(output));
        BobberDetector.LOGGER.info("{} registered {} recipe{}", getName(), all.size(), all.size() == 1 ? "" : "s");
    }

}
