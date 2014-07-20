package com.hascode.tutorial.xbeam.projection;

import java.util.List;

import org.xmlbeam.annotation.XBRead;

public interface Rss {
	public interface Item {
		@XBRead("title")
		String title();

		@XBRead("link")
		String link();
	}

	public interface Channel {
		@XBRead("title")
		String title();

		@XBRead("//item")
		List<Item> items();
	}

	@XBRead("/rss/channel")
	Channel channel();
}
