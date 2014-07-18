package com.hascode.tutorial.xbeam;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.xmlbeam.XBProjector;

import com.hascode.tutorial.xbeam.projection.MavenPom;

public class MavenPomParsing {
	public static void main(final String[] args) throws IOException {
		MavenPom pom = new XBProjector().io().fromURLAnnotation(MavenPom.class);
		System.out.println("Project: " + pom.project().artifactId() + ":" + pom.project().groupId() + ":" + pom.project().version());
		pom.dependencies().forEach(dep -> {
			System.out.println("-dependency -> " + dep.artifactId() + ":" + dep.groupId() + ":" + dep.version());
		});
		System.out.println("updating project version to 1.2.3..");
		pom.project().version("1.2.3");

		Path path = FileSystems.getDefault().getPath("/tmp", "changed.xml");
		System.out.println("writing pom to file: " + path);
		new XBProjector().io().file(path.toFile()).write(pom);
		Files.readAllLines(path).forEach(System.out::println);
	}
}