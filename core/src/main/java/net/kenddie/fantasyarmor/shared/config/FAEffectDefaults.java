package net.kenddie.fantasyarmor.shared.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class FAEffectDefaults {

    private static final String RESOURCE_PATH = "/effect_defaults.json";
    private static Map<String, List<EffectEntry>> cache;

    private FAEffectDefaults() {}

    public static Map<String, List<EffectEntry>> load() {
        if (cache != null) return cache;

        InputStream is = FAEffectDefaults.class.getResourceAsStream(RESOURCE_PATH);
        if (is == null) {
            throw new IllegalStateException("Missing resource: " + RESOURCE_PATH);
        }

        Type type = new TypeToken<Map<String, List<RawEffect>>>() {}.getType();
        Map<String, List<RawEffect>> raw = new Gson().fromJson(
                new InputStreamReader(is, StandardCharsets.UTF_8), type);

        Map<String, List<EffectEntry>> result = new LinkedHashMap<>();
        for (Map.Entry<String, List<RawEffect>> entry : raw.entrySet()) {
            List<EffectEntry> effects = entry.getValue().stream()
                    .map(r -> new EffectEntry(r.id, r.duration, r.amplifier))
                    .collect(java.util.stream.Collectors.toList());
            result.put(entry.getKey(), Collections.unmodifiableList(effects));
        }

        cache = Collections.unmodifiableMap(result);
        return cache;
    }

    public static List<EffectEntry> get(String setName) {
        Map<String, List<EffectEntry>> all = load();
        return all.getOrDefault(setName, Collections.emptyList());
    }

    private static class RawEffect {
        String id;
        int duration;
        int amplifier;
    }
}
