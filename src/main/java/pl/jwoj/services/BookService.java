package pl.jwoj.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jwoj.domain.Book;
import pl.jwoj.storage.BookshelfStorage;

import java.util.List;

public class BookService {

	@Autowired
	private BookshelfStorage bookshelfStorage;

	public Book createBook(Book book) {
		return bookshelfStorage.createBook(book);
	}

	public List<Book> getBooksByISBN(String isbn) {
		return bookshelfStorage.getBooksByISBN(isbn);
	}

	public List<Book> getAllBooks() {
		return bookshelfStorage.getAllBooks();
	}

	public List<Book> createBooks(List<Book> books) {
		return bookshelfStorage.createBooks(books);
	}
}
