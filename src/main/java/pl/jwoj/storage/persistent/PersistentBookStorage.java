package pl.jwoj.storage.persistent;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;
import pl.jwoj.storage.repositories.BookRepository;
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
		return bookRepository.save(book);
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

	@Override
	public void removeBook(String id) {
		bookRepository.delete(bookRepository.findById(id).orElse(new Book()));
	}

	@Override
	public void removeBooks(List<String> ids) {
		ids.forEach(this::removeBook);
	}

	private List<Book> getBooksById(List<String> ids) {
		List<Book> books = new ArrayList<>();
		bookRepository.findAllById(ids).forEach(books::add);
		return books;
	}
}
