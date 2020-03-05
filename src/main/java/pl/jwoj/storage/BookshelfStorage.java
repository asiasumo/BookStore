package pl.jwoj.storage;

import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;

import java.util.List;

public interface BookshelfStorage {


	Book createBook(Book book);

	Book getBookByISBN(String isbn) throws BookNotFoundException;

	List<Book> getAllBooks();

	List<Book> createBooks(List<Book> books);
}
