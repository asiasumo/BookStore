package pl.jwoj.storage;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;

import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class InMemoryBookshelfStorage implements BookshelfStorage {
	private final ConcurrentHashMap<String, Book> books;

	public InMemoryBookshelfStorage() {
		this.books = new ConcurrentHashMap<>();
	}

	@Override
	public Book createBook(Book book) {
		books.put(book.getIsbn(), book);
		return book;
	}

	@Override
	public Book getBookByISBN(String isbn) throws BookNotFoundException {
		Book result = books.get(isbn);
		if(result == null) {
			throw new BookNotFoundException();
		}
		return result;
	}
}
