package com.example.examplemod;

import net.fabricmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class ExampleMod implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        Constants.LOG.info("Hello Quilt world!");
        CommonClass.init();
    }
}
