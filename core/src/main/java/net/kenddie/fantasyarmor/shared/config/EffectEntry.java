package net.kenddie.fantasyarmor.shared.config;

import java.util.Optional;
import java.util.regex.Pattern;

public final class EffectEntry {
    private final String id;
    private final int duration;
    private final int amplifier;

    public String id() { return id; }
    public int duration() { return duration; }
    public int amplifier() { return amplifier; }

    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof EffectEntry)) return false;
        EffectEntry that = (EffectEntry) other;
        return duration == that.duration && amplifier == that.amplifier && id.equals(that.id);
    }

    @Override public int hashCode() { return java.util.Objects.hash(id, duration, amplifier); }

    private static final Pattern ID = Pattern.compile("[a-z0-9_.-]+:[a-z0-9/._-]+");

    public EffectEntry(String id, int duration, int amplifier) {
        this.id = id;
        this.duration = duration;
        this.amplifier = amplifier;
        if (id == null || !ID.matcher(id).matches()) {
            throw new IllegalArgumentException("Invalid effect identifier: " + id);
        }
        if (duration != -1 && duration <= 0) {
            throw new IllegalArgumentException("Effect duration must be positive or -1 (infinite)");
        }
        if (amplifier < 0 || amplifier > 255) {
            throw new IllegalArgumentException("Effect amplifier must be between 0 and 255");
        }
    }

    /** Config syntax is independent of Minecraft's version-specific registry API. */
    public static Optional<EffectEntry> parse(Object value) {
        if (!(value instanceof String)) return Optional.empty();
        String[] parts = ((String) value).split(",", -1);
        if (parts.length != 3) return Optional.empty();
        try {
            return validated(parts[0], Integer.parseInt(parts[1].trim()), Integer.parseInt(parts[2].trim()));
        } catch (NumberFormatException exception) {
            return Optional.empty();
        }
    }

    public static Optional<EffectEntry> validated(String id, int duration, int amplifier) {
        if (id == null) return Optional.empty();
        id = id.trim();
        if (!id.contains(":")) id = "minecraft:" + id;
        try {
            return Optional.of(new EffectEntry(id, duration, amplifier));
        } catch (IllegalArgumentException exception) {
            return Optional.empty();
        }
    }

    /** The configured interval is a remaining-duration threshold, not a tick schedule. */
    public static boolean shouldRefresh(int remainingDuration, int threshold) {
        return remainingDuration != -1 && remainingDuration < threshold;
    }

    public static boolean isValidConfigValue(Object value) {
        return parse(value).isPresent();
    }

    public String toConfigValue() {
        return id + "," + duration + "," + amplifier;
    }
}
