package com.chyzman.ctft.Registries;

import com.chyzman.ctft.util.CtftMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.wispforest.owo.moddata.ModDataConsumer;
import io.wispforest.owo.moddata.ModDataLoader;
import net.minecraft.util.Identifier;

import java.util.SortedMap;
import java.util.TreeMap;

public class CtftStats {
    public static final SortedMap<String, CtftMaterial> MATERIALS = new TreeMap<>();

    static {
        ModDataLoader.load(new StatsLoader());
    }

    private static class StatsLoader implements ModDataConsumer {
        private static final Gson GSON = new Gson();

        @Override
        public String getDataSubdirectory() {
            return "ctft_stats";
        }

        @Override
        public void acceptParsedFile(Identifier id, JsonObject object) {
            CtftMaterial material = GSON.fromJson(GSON.toJson(object), CtftMaterial.class);
            MATERIALS.put(material.name, material);
        }
    }
}