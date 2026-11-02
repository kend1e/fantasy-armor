package net.kenddie.fantasyarmor.shared.config;

/** Accepted config ranges, shared by native specs and Cloth. */
public final class ArmorAttributeLimits {
    private ArmorAttributeLimits() {}

    public static final class Range {
        private final double min, max;
        public Range(double min, double max) { this.min = min; this.max = max; }
        public double min() { return min; }
        public double max() { return max; }
        public double orDefault(Double value, double fallback) {
            return value != null && Double.isFinite(value) && value >= min && value <= max ? value : fallback;
        }
    }

    public static final Range ARMOR = new Range(0, 100);
    public static final Range ARMOR_TOUGHNESS = new Range(0, 100);
    public static final Range KNOCKBACK_RESISTANCE = new Range(0, 1);
    public static final Range MOVEMENT_SPEED = new Range(-1, 1);
    public static final Range MAX_HEALTH = new Range(0, 100);
    public static final Range ATTACK_DAMAGE = new Range(0, 100);
    public static final Range ATTACK_SPEED = new Range(-1, 1);
    public static final Range LUCK = new Range(-100, 100);
    public static final Range DURABILITY = new Range(0, 10000);
}
