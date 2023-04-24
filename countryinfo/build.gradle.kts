import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.base.DokkaBaseConfiguration

plugins {
	id("org.springframework.boot") version "2.7.7"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("org.jetbrains.dokka") version "1.8.10"
}

group = "com.olaaref"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	implementation("org.springframework.boot:spring-boot-configuration-processor")
	implementation("jakarta.xml.bind:jakarta.xml.bind-api:2.3.2")
	implementation("org.glassfish.jaxb:jaxb-runtime:2.3.2")
	implementation("javax.jws:javax.jws-api:1.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

buildscript {
	dependencies {
		classpath("org.jetbrains.dokka:dokka-base:1.8.10")
	}
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
	pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
		footerMessage = "(c) 2023 Ola Aref"
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
