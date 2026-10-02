package dev.mobileperf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PerfConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static PerfConfig instance;

    public boolean particleCull = true;
    public int particleMaxDistance = 48;
    public boolean entityCull = true;
    public int entityMaxDistance = 64;

    private static Path path() {
        return FabricLoader.getInstance().getConfigDir().resolve("mobileperf.json");
    }

    public static synchronized PerfConfig get() {
        if (instance == null) {
            instance = load();
        }
        return instance;
    }

    private static PerfConfig load() {
        Path p = path();
        if (Files.exists(p)) {
            try {
                PerfConfig c = GSON.fromJson(Files.readString(p), PerfConfig.class);
                if (c != null) {
                    return c;
                }
            } catch (Exception e) {
                System.err.println("[mobileperf] failed to read config, using defaults: " + e);
            }
        }
        PerfConfig c = new PerfConfig();
        c.write();
        return c;
    }

    public static void save() {
        get().write();
    }

    private void write() {
        try {
            Files.writeString(path(), GSON.toJson(this));
        } catch (IOException e) {
            System.err.println("[mobileperf] failed to save config: " + e);
        }
    }
}
