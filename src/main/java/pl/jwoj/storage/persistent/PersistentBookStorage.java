package pl.jwoj.storage.persistent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;
import pl.jwoj.storage.BookRepository;
import pl.jwoj.storage.BookshelfStorage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PersistentBookStorage implements BookshelfStorage {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		book.setId(UUID.randomUUID().toString());
		bookRepository.save(book);
		return bookRepository.findById(book.getId()).orElseThrow();
	}

	@Override
	public List<Book> getBooksByISBN(String isbn) throws BookNotFoundException {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(book ->{
			if (book.getIsbn().equals(isbn)) {
				books.add(book);
			}
		});
		return books;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}

	@Override
	public List<Book> createBooks(List<Book> books) {
		books.forEach(this::createBook);
		return getBooksById(books.stream().map(Book::getId).collect(Collectors.toList()));
	}

	private List<Book> getBooksById(List<String> ids) {
		List<Book> books = new ArrayList<>();
		bookRepository.findAllById(ids).forEach(books::add);
		return books;
	}

	private void prepopulateStorage() {
		ObjectMapper om = new ObjectMapper();
		URL url = PersistentBookStorage.class.getResource("/static/tempBooks.json");
		List<Book> values = null;
		try {
			values = om.readValue(url, new TypeReference<List<Book>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		values.forEach(this::createBook);
	}
}
