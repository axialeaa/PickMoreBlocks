package com.axialeaa.pickmoreblocks;

import com.axialeaa.pickmoreblocks.util.CustomPickLogic;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PickMoreBlocks implements ClientModInitializer {

    // public static final String MOD_ID = "pickmoreblocks";
    public static final String MOD_NAME = "PickMoreBlocks";
    public static Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitializeClient() {
        LOGGER.info(MOD_NAME + " initialized. Pick your battles!");
        CustomPickLogic.registerPickFluid();
    }

}
