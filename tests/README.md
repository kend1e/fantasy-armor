# Server tests

Run with JDK 25:

```sh
./gradlew test                              # all targets, default config
./gradlew test -PtestProfile=configured     # config overrides
./gradlew :platforms:forge-1.19.4:test          # one target
```

Run the profiles sequentially. `build` includes tests; `assemble` skips them.
Reports: `platforms/<target>/build/reports/test/<profile>/results.xml`.
Test configs and worlds stay in `build/run/test`.
`test NO-SOURCE` is normal: Minecraft tests run in the native launcher task.

To add a test, create a class with `public static void run(GameTestHelper helper)`
and register it in `definitions/tests.kt`. Shared tests go in `tests/common/java`,
Minecraft adapters in `tests/minecraft`, loader adapters in `loaders/<loader>/src/test`.
Use the `minecraft` and `loaders` selectors for tests that apply only to specific targets.

Targets with a native GameTest runner join `test` automatically.
For a new Minecraft version, verify its profile in Fantasy Build first, then add
the mod’s source adapters to `definitions/tests.kt`.
