package fantasy.definitions

import fantasy.gradle.buildTargets

private const val PATCH_RELEASE = "1.3.1"

val targets = buildTargets(releaseVersion = "1.3") {
    forge("1.12.2") { geckolib() }
    forge("1.15.2") { geckolib() }
    forge("1.16.5") { geckolib() }
    fabric("1.16.5") { fabricApi(); clothConfig(); geckolib() }
    forge("1.18.2") { releaseVersion = PATCH_RELEASE; geckolib() }
    fabric("1.18.2") { releaseVersion = PATCH_RELEASE; fabricApi(); clothConfig(); geckolib() }
    forge("1.19.2") { releaseVersion = PATCH_RELEASE; geckolib() }
    fabric("1.19.2") { releaseVersion = PATCH_RELEASE; fabricApi(); clothConfig(); geckolib() }
    forge("1.19.3") { releaseVersion = PATCH_RELEASE; geckolib() }
    fabric("1.19.3") {
        releaseVersion = PATCH_RELEASE
        fabricApi()
        clothConfig()
        geckolib()
    }
    forge("1.19.4") {
        releaseVersion = PATCH_RELEASE
        dataGeneration = true
        geckolib()
    }
    fabric("1.19.4") {
        releaseVersion = PATCH_RELEASE
        fabricApi()
        geckolib()
        clothConfig()
    }
    forge("1.20.1") {
        releaseVersion = PATCH_RELEASE
        geckolib()
    }
    fabric("1.20.1") {
        releaseVersion = PATCH_RELEASE
        dataGeneration = true
        fabricApi("0.92.2+1.20.1")
        geckolib()
        clothConfig()
    }
    forge("1.21.1") {
        releaseVersion = PATCH_RELEASE
        dataGeneration = true
        geckolib()
    }
    neoforge("1.21.1") {
        releaseVersion = PATCH_RELEASE
        dataGeneration = true
        geckolib()
    }
    fabric("1.21.1") {
        releaseVersion = PATCH_RELEASE
        fabricApi()
        geckolib()
        clothConfig()
    }
    forge("1.21.10") {
        releaseVersion = PATCH_RELEASE
        geckolib()
    }
    neoforge("1.21.10") {
        releaseVersion = PATCH_RELEASE
        geckolib()
    }
    fabric("1.21.10") {
        releaseVersion = PATCH_RELEASE
        fabricApi()
        geckolib()
        clothConfig()
    }
    forge("1.21.11") {
        releaseVersion = PATCH_RELEASE
        dataGeneration = true
        geckolib()
    }
    neoforge("1.21.11") {
        releaseVersion = PATCH_RELEASE
        geckolib()
    }
    fabric("1.21.11") {
        releaseVersion = PATCH_RELEASE
        fabricApi()
        geckolib()
        clothConfig()
    }
    forge("26.1.2") { geckolib() }
    neoforge("26.1.2") { geckolib() }
    fabric("26.1.2") {
        fabricApi()
        geckolib()
        clothConfig()
    }
    forge("26.2") { geckolib() }
    neoforge("26.2") { geckolib() }
    fabric("26.2") {
        fabricApi()
        geckolib()
        clothConfig()
    }
    forge("26.3") { geckolib() }
    neoforge("26.3") { geckolib() }
    fabric("26.3") {
        fabricApi()
        geckolib()
        clothConfig()
    }
}
