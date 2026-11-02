package net.kenddie.fantasyarmor.test;

import com.google.gson.Gson;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import java.util.List;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static net.kenddie.fantasyarmor.test.TestSupport.*;

public final class ConfigLoadTests {
    static final class Expected {
        private String id;
        private boolean modifiers;
        private boolean durability;
        private boolean effects;
        private double helmetArmor;
        private List<EffectEntry> setEffects;
        String id() { return id; }
        boolean modifiers() { return modifiers; }
        boolean durability() { return durability; }
        boolean effects() { return effects; }
        double helmetArmor() { return helmetArmor; }
        List<EffectEntry> setEffects() { return setEffects; }
    }

    public static void run(GameTestHelper h) {
        var stream = ConfigLoadTests.class.getResourceAsStream("/armor_test_profile.json");
        if (stream == null) throw new IllegalStateException("Missing test profile");
        Expected expected;
        try (var reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            expected = new Gson().fromJson(reader, Expected.class);
        } catch (java.io.IOException e) { throw new IllegalStateException(e); }
        check(h, ConfigAccess.loaded(), "Configs must be loaded from disk");
        check(h, ConfigAccess.modifiers() == expected.modifiers(), "Loaded modifier toggle: " + expected.id());
        check(h, ConfigAccess.durability() == expected.durability(), "Loaded durability toggle: " + expected.id());
        check(h, ConfigAccess.effects() == expected.effects(), "Loaded effect toggle: " + expected.id());
        close(h, ConfigAccess.helmetArmor(), expected.helmetArmor(), "Loaded helmet protection");
        var helmet = stack("eclipse_soldier_helmet");
        check(h, ((FAArmorItem) helmet.getItem()).getFullSetEffects().equals(expected.setEffects()),
                "Effect entries must be loaded from disk: " + expected.id());
        check(h, helmet.isDamageableItem() == expected.durability(), "Loaded durability must affect new stacks");
        var player = player(h);
        player.setItemSlot(EquipmentSlot.HEAD, helmet);
        player.tick();
        close(h, player.getAttributeValue(Attributes.ARMOR), expected.helmetArmor(), "Protection loaded before equip");
        h.succeed();
    }
    private ConfigLoadTests() {}
}
