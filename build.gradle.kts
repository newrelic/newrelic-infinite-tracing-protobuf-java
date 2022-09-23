import com.google.protobuf.gradle.*

repositories {
    mavenCentral()
}

plugins {
    id("java-library")
    id("maven-publish")
    id("signing")
    id("com.google.protobuf") version "0.8.12"
}

group = "com.newrelic.agent.java"

// -Prelease=true will render a non-snapshot version
// All other values (including unset) will render a snapshot version.
val release: String? by project
version = "3.3" + if ("true" == release) "" else "-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
    withSourcesJar()
    withJavadocJar()
}

val protobufVersion = "3.21.6"
val grpcVersion = "1.43.0"

dependencies {
    api("com.google.protobuf:protobuf-java:$protobufVersion")
    api("io.grpc:grpc-stub:$grpcVersion")
    api("io.grpc:grpc-protobuf:$grpcVersion")
    api("io.grpc:grpc-okhttp:$grpcVersion")
    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
}

// This makes it difficult to use modern Java and produce usable output.
tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

tasks.jar {
    from("LICENSE")
    manifest {
        attributes(mapOf(
                "Implementation-Vendor" to "New Relic, Inc",
                "Implementation-Version" to project.version
        ))
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
        }
        // customize all publications here
        withType(MavenPublication::class) {
            pom {
                name.set(project.name)
                description.set("Protobuf code for Infinite Tracing on New Relic Edge.")
                url.set("https://github.com/newrelic/newrelic-infinite-tracing-protobuf-java")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("newrelic")
                        name.set("New Relic")
                        email.set("opensource@newrelic.com")
                    }
                }
                scm {
                    url.set("git@github.com:newrelic/newrelic-infinite-tracing-protobuf-java.git")
                    connection.set("scm:git:git@github.com:newrelic/newrelic-infinite-tracing-protobuf-java.git")
                }
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = System.getenv("SONATYPE_USERNAME")
                password = System.getenv("SONATYPE_PASSWORD")
            }
            configure<SigningExtension> {
                val signingKeyId: String? by project
                val signingKey: String? by project
                val signingPassword: String? by project
                useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)

                setRequired({ gradle.taskGraph.hasTask("uploadArchives") })
                sign(publishing.publications["mavenJava"])
            }
        }
    }
}
