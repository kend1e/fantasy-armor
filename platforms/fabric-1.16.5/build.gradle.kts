plugins { id("fantasy.platform") }

// GeckoLib 3's helper collides with EntityRenderer in Mojang's development names.
configurations.named("mappings") { dependencies.clear() }
val loom = extensions.getByType<net.fabricmc.loom.api.LoomGradleExtensionAPI>()
loom.runs.configureEach {
    vmArg("-Dgeckolib.disable_examples=true")
}
dependencies {
    add("mappings", loom.layered {
        officialMojangMappings { setNameSyntheticMembers(false) }
        mappings(layout.projectDirectory.file("geckolib.tiny").asFile) { mergeNamespace("official") }
    })
}
