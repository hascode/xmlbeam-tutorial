package com.hascode.tutorial.xbeam;

import java.io.IOException;
import java.util.stream.Collectors;

import org.xmlbeam.XBProjector;

import com.hascode.tutorial.xbeam.projection.Books;

public class SimpleXmlFileParsingExample {
	public static void main(final String[] args) throws IOException {
		Books bookProjection = new XBProjector().io().fromURLAnnotation(Books.class);
		bookProjection.getBooks().forEach(book -> {
			System.out.println("book -> title: " + book.getTitle() + " and authors: ");
			System.out.println(book.getAuthors().stream().map(a -> {
				return a.getFirstname() + " " + a.getLastname();
			}).collect(Collectors.joining(", ")));
		});
	}
}