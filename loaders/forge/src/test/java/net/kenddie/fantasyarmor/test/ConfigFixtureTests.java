package net.kenddie.fantasyarmor.test;

import net.kenddie.fantasyarmor.config.FAConfig;
import net.kenddie.fantasyarmor.config.FAArmorConfig;
import net.minecraft.gametest.framework.GameTestHelper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static net.kenddie.fantasyarmor.test.TestSupport.*;

public final class ConfigFixtureTests {
    public static void run(GameTestHelper helper) {
        boolean durability = ConfigAccess.durability();
        double armor = ConfigAccess.helmetArmor();
        var files = ConfigRegistry.serverConfigs().stream()
                .filter(config -> config.getSpec() == FAConfig.SPEC || config.getSpec() == FAArmorConfig.SPEC)
                .map(config -> new Snapshot(config.getFullPath(), read(config.getFullPath())))
                .toList();
        var expectedFailure = new IllegalStateException("Expected fixture failure");
        try {
            ConfigAccess.withSettings(() -> {
                ConfigAccess.durability(!durability);
                ConfigAccess.helmetArmor(armor + 7.0);
                FAConfig.SPEC.afterReload();
                FAArmorConfig.SPEC.afterReload();
                check(helper, ConfigAccess.durability() == !durability, "Reload must retain the fixture durability");
                close(helper, ConfigAccess.helmetArmor(), armor + 7.0, "Reload must retain the fixture protection");
                for (var file : files) check(helper, Arrays.equals(file.contents(), read(file.path())),
                        "Fixture must not write " + file.path().getFileName());
                throw expectedFailure;
            });
            throw new AssertionError("Fixture must propagate the scenario failure");
        } catch (IllegalStateException failure) {
            check(helper, failure == expectedFailure, "Fixture must preserve the original failure");
        }
        check(helper, ConfigAccess.durability() == durability, "Fixture must restore loaded durability after failure");
        close(helper, ConfigAccess.helmetArmor(), armor, "Fixture must restore loaded protection after failure");
        for (var file : files) check(helper, Arrays.equals(file.contents(), read(file.path())),
                "Fixture cleanup must not write " + file.path().getFileName());
        helper.succeed();
    }

    private static byte[] read(Path path) {
        try { return Files.readAllBytes(path); }
        catch (java.io.IOException failure) { throw new IllegalStateException("Cannot read " + path, failure); }
    }

    private record Snapshot(Path path, byte[] contents) {}
    private ConfigFixtureTests() {}
}
