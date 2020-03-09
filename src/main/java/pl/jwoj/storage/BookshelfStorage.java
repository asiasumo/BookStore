package pl.jwoj.storage;

import org.springframework.stereotype.Service;
import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;

import java.util.List;

@Service
public interface BookshelfStorage {

	Book createBook(Book book);

	List<Book> getBooksByISBN(String isbn) throws BookNotFoundException;

	List<Book> getAllBooks();

	List<Book> createBooks(List<Book> books);

	void removeBook(String id);

	void removeBooks(List<String> ids);
}
