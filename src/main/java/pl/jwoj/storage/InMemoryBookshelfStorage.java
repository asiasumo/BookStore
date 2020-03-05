package pl.jwoj.storage;

import lombok.AllArgsConstructor;
import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<>(books.values());
	}

	@Override
	public List<Book> createBooks(List<Book> books) {
		books.forEach(this::createBook);
		return books;
	}
}
