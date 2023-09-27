package com.axialeaa.pickmoreblocks;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientEntrypoint implements ClientModInitializer {
	public static final String MOD_ID = "pickmoreblocks";
	public static final String MOD_NAME = "PickMoreBlocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		LOGGER.info(MOD_NAME + " initialized.");
	}
}