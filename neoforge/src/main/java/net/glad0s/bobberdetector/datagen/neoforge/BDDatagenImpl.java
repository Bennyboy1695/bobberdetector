package net.glad0s.bobberdetector.datagen.neoforge;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateDataProvider;
import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.datagen.BDDatagen;
import net.glad0s.bobberdetector.datagen.BDTagGen;
import net.glad0s.bobberdetector.datagen.recipes.BDStandardRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class BDDatagenImpl extends BDDatagen {

    private static final CreateRegistrate REGISTRATE = BobberDetector.registrate();

    public static void addExtraRegistrateData() {
        BDTagGen.addGenerators();

        REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
            BiConsumer<String, String> langConsumer = provider::add;

            provideDefaultLang("interface", langConsumer);
            provideDefaultLang("tooltips", langConsumer);
            providePonderLang(langConsumer);
        });
    }

    public static void gatherData(GatherDataEvent event) {
        addExtraRegistrateData();

        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new BDStandardRecipes(output, lookupProvider));

        event.getGenerator().addProvider(true, BobberDetector.registrate().setDataProvider(new RegistrateDataProvider(BobberDetector.registrate(), BobberDetector.MOD_ID, event)));
    }
}
