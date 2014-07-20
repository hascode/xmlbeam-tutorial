package com.hascode.tutorial.xbeam;

import java.io.IOException;

import org.xmlbeam.XBProjector;

import com.hascode.tutorial.xbeam.projection.Rss;

public class RssFeedParsing {
	public static void main(final String[] args) throws IOException {
		System.out.println("loading rss feed..");
		Rss rss = new XBProjector().io().url("http://www.hascode.com/feed/").read(Rss.class);

		System.out.println("rss feed received - channel: " + rss.channel().title());
		rss.channel().items().forEach(i -> {
			System.out.println("title: " + i.title() + ", link: " + i.link());
		});
	}
}
