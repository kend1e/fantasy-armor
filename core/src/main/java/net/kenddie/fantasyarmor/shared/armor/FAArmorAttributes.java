package net.kenddie.fantasyarmor.shared.armor;

public final class FAArmorAttributes {
    private final double armor;
    private final double armorToughness;
    private final double knockbackResistance;
    private final double movementSpeed;
    private final double maxHealth;
    private final double attackDamage;
    private final double attackSpeed;
    private final double luck;
    private final double durability;

    public FAArmorAttributes(double armor, double armorToughness, double knockbackResistance, double movementSpeed, double maxHealth, double attackDamage, double attackSpeed, double luck, double durability) {
        this.armor = armor;
        this.armorToughness = armorToughness;
        this.knockbackResistance = knockbackResistance;
        this.movementSpeed = movementSpeed;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.luck = luck;
        this.durability = durability;
    }

    public double armor() { return armor; }
    public double armorToughness() { return armorToughness; }
    public double knockbackResistance() { return knockbackResistance; }
    public double movementSpeed() { return movementSpeed; }
    public double maxHealth() { return maxHealth; }
    public double attackDamage() { return attackDamage; }
    public double attackSpeed() { return attackSpeed; }
    public double luck() { return luck; }
    public double durability() { return durability; }

    @Override public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof FAArmorAttributes)) return false;
        FAArmorAttributes that = (FAArmorAttributes) other;
        return Double.compare(armor, that.armor) == 0
                && Double.compare(armorToughness, that.armorToughness) == 0
                && Double.compare(knockbackResistance, that.knockbackResistance) == 0
                && Double.compare(movementSpeed, that.movementSpeed) == 0
                && Double.compare(maxHealth, that.maxHealth) == 0
                && Double.compare(attackDamage, that.attackDamage) == 0
                && Double.compare(attackSpeed, that.attackSpeed) == 0
                && Double.compare(luck, that.luck) == 0
                && Double.compare(durability, that.durability) == 0;
    }

    @Override public int hashCode() {
        return java.util.Objects.hash(armor, armorToughness, knockbackResistance, movementSpeed, maxHealth, attackDamage, attackSpeed, luck, durability);
    }

    /** Keeps the configured protection and durability when optional bonuses are disabled. */
    public FAArmorAttributes withBonuses(boolean enabled) {
        return enabled ? this : new FAArmorAttributes(
                armor, armorToughness, knockbackResistance,
                0, 0, 0, 0, 0, durability);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double armor = 0;
        private double armorToughness = 0;
        private double knockbackResistance = 0;
        private double movementSpeed = 0;
        private double maxHealth = 0;
        private double attackDamage = 0;
        private double attackSpeed = 0;
        private double luck = 0;
        private double durability = 0;

        public Builder armor(double armor) {
            this.armor = armor;
            return this;
        }

        public Builder armorToughness(double armorToughness) {
            this.armorToughness = armorToughness;
            return this;
        }

        public Builder knockbackResistance(double knockbackResistance) {
            this.knockbackResistance = knockbackResistance;
            return this;
        }

        public Builder movementSpeed(double movementSpeed) {
            this.movementSpeed = movementSpeed;
            return this;
        }

        public Builder maxHealth(double maxHealth) {
            this.maxHealth = maxHealth;
            return this;
        }

        public Builder attackDamage(double attackDamage) {
            this.attackDamage = attackDamage;
            return this;
        }

        public Builder attackSpeed(double attackSpeed) {
            this.attackSpeed = attackSpeed;
            return this;
        }

        public Builder luck(double luck) {
            this.luck = luck;
            return this;
        }

        public Builder durability(double durability) {
            this.durability = durability;
            return this;
        }

        public FAArmorAttributes build() {
            return new FAArmorAttributes(
                    armor,
                    armorToughness,
                    knockbackResistance,
                    movementSpeed,
                    maxHealth,
                    attackDamage,
                    attackSpeed,
                    luck,
                    durability
            );
        }
    }
}
