package pl.jwoj.storage.inmemory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import pl.jwoj.domain.Book;
import pl.jwoj.storage.BookshelfStorage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@AllArgsConstructor
public class InMemoryBookshelfStorage implements BookshelfStorage {
	private final ConcurrentHashMap<String, Book> books;

	public InMemoryBookshelfStorage() {
		this.books = new ConcurrentHashMap<>();
		prepopulateStorage();
	}
	private void prepopulateStorage() {
		ObjectMapper om = new ObjectMapper();
		URL url = InMemoryBookshelfStorage.class.getResource("/static/tempBooks.json");
		List<Book> values = null;
		try {
			 values = om.readValue(url, new TypeReference<List<Book>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		values.forEach(this::createBook);
	}

	@Override
	public Book createBook(Book book) {
		books.put(UUID.randomUUID().toString(), book);
		return book;
	}

	@Override
	public List<Book> getBooksByISBN(String isbn) {
		return books.values()
				.stream()
				.map(book -> book.getIsbn().equals(isbn) ? book : null)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
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

	@Override
	public void removeBook(String id) {
		books.remove(id);
	}

	@Override
	public void removeBooks(List<String> ids) {
		ids.forEach(this::removeBook);
	}
}
