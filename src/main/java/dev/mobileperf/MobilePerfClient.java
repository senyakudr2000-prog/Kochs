package dev.mobileperf;

import net.fabricmc.api.ClientModInitializer;

public class MobilePerfClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PerfConfig.get();
    }
}
