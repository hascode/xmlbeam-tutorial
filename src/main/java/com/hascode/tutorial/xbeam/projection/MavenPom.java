package com.hascode.tutorial.xbeam.projection;

import java.util.List;

import org.xmlbeam.annotation.XBDocURL;
import org.xmlbeam.annotation.XBRead;
import org.xmlbeam.annotation.XBWrite;

@XBDocURL("resource:///pom.xml")
public interface MavenPom {
	public interface Artifact {
		@XBRead("./xbdefaultns:artifactId")
		String artifactId();

		@XBRead("./xbdefaultns:groupId")
		String groupId();

		@XBRead("./xbdefaultns:version")
		String version();

		@XBWrite("./version")
		void version(String version);
	}

	@XBRead("/xbdefaultns:project")
	Artifact project();

	@XBRead("//xbdefaultns:dependency")
	List<Artifact> dependencies();
}
