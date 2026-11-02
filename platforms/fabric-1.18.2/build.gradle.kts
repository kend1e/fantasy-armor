plugins {
    id("fantasy.platform")
    id("fabric-loom")
}

dependencies { implementation(libs.mclib) }

// GeckoLib 3's helper collides with EntityRenderer in Mojang's development names.
configurations.named("mappings") { dependencies.clear() }
val loom = extensions.getByType<net.fabricmc.loom.api.LoomGradleExtensionAPI>()
dependencies {
    add("mappings", loom.layered {
        officialMojangMappings { setNameSyntheticMembers(false) }
        mappings(layout.projectDirectory.file("geckolib.tiny").asFile) { mergeNamespace("official") }
    })
}
