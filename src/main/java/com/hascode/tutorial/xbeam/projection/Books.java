package com.hascode.tutorial.xbeam.projection;

import java.util.List;

import org.xmlbeam.annotation.XBDocURL;
import org.xmlbeam.annotation.XBRead;

@XBDocURL("resource:///books.xml")
public interface Books {

	interface Book {
		interface Author {
			@XBRead("./@firstname")
			String getFirstname();

			@XBRead("./@lastname")
			String getLastname();
		}

		@XBRead("./title")
		String getTitle();

		@XBRead(".//author")
		List<Author> getAuthors();
	}

	@XBRead("//book")
	List<Book> getBooks();
}
