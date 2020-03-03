package pl.jwoj.storage;

import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;

public interface BookshelfStorage {


	Book createBook(Book book);

	Book getBookByISBN(String isbn) throws BookNotFoundException;
}
