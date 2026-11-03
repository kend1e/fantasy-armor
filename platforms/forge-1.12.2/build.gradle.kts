plugins { id("fantasy.platform") }

val versionProperties = tasks.register<WriteProperties>("generateVersionProperties") {
    destinationFile = layout.buildDirectory.file("generated/version/version.properties")
    property("fantasy_armor.version", project.version.toString())
}

tasks.named<ProcessResources>("processResources") {
    from(versionProperties)
}
