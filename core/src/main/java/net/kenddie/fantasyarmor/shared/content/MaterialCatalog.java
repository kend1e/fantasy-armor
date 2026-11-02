package net.kenddie.fantasyarmor.shared.content;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public final class MaterialCatalog {
    public static final List<String> IDS = load();

    private static List<String> load() {
        java.io.InputStream stream = MaterialCatalog.class.getResourceAsStream("/material_catalog.json");
        if (stream == null) throw new IllegalStateException("Missing material catalog");
        try (InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            String[] ids = new Gson().fromJson(reader, String[].class);
            if (ids == null || Arrays.stream(ids).anyMatch(id -> id == null || !id.matches("[a-z0-9_]+"))
                    || Arrays.stream(ids).distinct().count() != ids.length) {
                throw new IllegalStateException("Invalid material catalog");
            }
            return java.util.Collections.unmodifiableList(Arrays.asList(ids));
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read material catalog", exception);
        }
    }

    private MaterialCatalog() {}
}
