package com.chyzman.ctft.registries;

import com.chyzman.ctft.util.CtftMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.wispforest.owo.moddata.ModDataConsumer;
import io.wispforest.owo.moddata.ModDataLoader;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.chyzman.ctft.Ctft.MODID;
import static com.chyzman.ctft.util.CtftRegistryHelper.id;

public class CtftStats {
    public static final SortedMap<Identifier, CtftMaterial> MATERIALS = new TreeMap<>();

    private static class StatsLoader extends JsonDataLoader implements IdentifiableResourceReloadListener {
        private static final Gson GSON = new Gson();

        public StatsLoader() {
            super(GSON, "ctft_stats");
        }

        @Override
        protected void apply(Map<Identifier, JsonElement> prepared, ResourceManager manager, Profiler profiler) {
            prepared.forEach((identifier, jsonElement) -> {
                CtftMaterial material = GSON.fromJson(GSON.toJson(jsonElement), CtftMaterial.class);
                MATERIALS.put(identifier, material);
            });
        }

        @Override
        public Identifier getFabricId() {
            return id("stats_loader");
        }
    }

    public static void Init() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new StatsLoader());
    }
}