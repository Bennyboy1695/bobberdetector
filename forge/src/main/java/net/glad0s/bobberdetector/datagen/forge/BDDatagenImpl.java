package net.glad0s.bobberdetector.datagen.forge;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.ProviderType;
import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.datagen.BDDatagen;
import net.glad0s.bobberdetector.datagen.BDTagGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

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

        if (event.includeServer()) {
            BobberDetector.gatherData(generator.getVanillaPack(true));
        }
    }
}
