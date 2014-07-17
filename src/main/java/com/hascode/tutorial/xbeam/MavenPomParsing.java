package com.hascode.tutorial.xbeam;

import java.io.IOException;

import org.xmlbeam.XBProjector;

import com.hascode.tutorial.xbeam.projection.MavenPom;

public class MavenPomParsing {
	public static void main(final String[] args) throws IOException {
		MavenPom pom = new XBProjector().io().fromURLAnnotation(MavenPom.class);
		System.out.println("Project: " + pom.project().artifactId() + ":" + pom.project().groupId() + ":" + pom.project().version());
		pom.dependencies().forEach(dep -> {
			System.out.println("-dependency -> " + dep.artifactId() + ":" + dep.groupId() + ":" + dep.version());
		});
	}
}