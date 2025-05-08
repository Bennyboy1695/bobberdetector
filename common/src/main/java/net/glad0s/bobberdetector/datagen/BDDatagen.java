package net.glad0s.bobberdetector.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.utility.FilesHelper;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.createmod.ponder.foundation.PonderIndex;
import net.glad0s.bobberdetector.BobberDetector;
import net.glad0s.bobberdetector.register.BDPonders;

import java.util.Map;
import java.util.function.BiConsumer;

public class BDDatagen {

    private static final CreateRegistrate REGISTRATE = BobberDetector.registrate();

    //TODO: Move back to common once fabric version is out
    @ExpectPlatform
    public static void addExtraRegistrateData() {
    }

    protected static void provideDefaultLang(String fileName, BiConsumer<String, String> consumer) {
        String path = "assets/bobberdetector/lang/default/" + fileName + ".json";
        JsonElement jsonElement = FilesHelper.loadJsonResource(path);
        if (jsonElement == null) {
            throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            consumer.accept(key, value);
        }
    }

    protected static void providePonderLang(BiConsumer<String, String> consumer) {
        PonderIndex.addPlugin(new BDPonders());

        PonderIndex.getLangAccess().provideLang(BobberDetector.MOD_ID, consumer);
    }
}
