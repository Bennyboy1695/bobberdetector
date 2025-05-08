package net.glad0s.bobberdetector.datagen.recipes.gen;

import com.simibubi.create.foundation.data.recipe.CreateRecipeProvider;
import net.glad0s.bobberdetector.BobberDetector;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class BobberDetectorRecipeProvider extends RecipeProvider {

    protected static final List<GeneratedRecipeBuilder.GeneratedRecipe> all = new ArrayList<>();

    public BobberDetectorRecipeProvider(PackOutput output) {
        super(output);
    }

    public void registerRecipes(@NotNull Consumer<FinishedRecipe> p_200404_1_) {
        all.forEach(c -> c.register(p_200404_1_));
        BobberDetector.LOGGER.info(getName() + " registered " + all.size() + " recipe" + (all.size() == 1 ? "" : "s"));
    }

    public static GeneratedRecipeBuilder.GeneratedRecipe register(GeneratedRecipeBuilder.GeneratedRecipe recipe) {
        all.add(recipe);
        return recipe;
    }

    @Override
    public void buildRecipes(@NotNull Consumer<FinishedRecipe> writer) {
        all.forEach(recipe -> recipe.register(writer));
    }

}
