package net.glad0s.bobberdetector.register;

import net.createmod.catnip.render.BindableTexture;
import net.glad0s.bobberdetector.BobberDetector;
import net.minecraft.resources.ResourceLocation;

public enum BDSpecialTextures implements BindableTexture {
    FISH("fish.png"),
    ;

    public static final String ASSET_PATH = "textures/special/";
    private final ResourceLocation location;

    BDSpecialTextures(String filename) {
        location = BobberDetector.asResource(ASSET_PATH + filename);
    }

    public ResourceLocation getLocation() {
        return location;
    }
}
