plugins {
    id("fantasy.platform")
    id("net.minecraftforge.gradle")
}

dependencies { implementation(libs.mclib) }

publishing {
    publications {
        register<MavenPublication>("mavenJava") { artifact(tasks.named("renameJar")) }
    }
    repositories { maven { url = uri(layout.projectDirectory.dir("mcmodsrepo")) } }
}
