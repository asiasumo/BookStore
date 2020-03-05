package pl.jwoj.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jwoj.domain.Book;
import pl.jwoj.storage.BookshelfStorage;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class BookService {

	@Autowired
	BookshelfStorage bookshelfStorage;

	public Book createBook(Book book) {
		return bookshelfStorage.createBook(book);
	}

	public Book getBookByISBN(String isbn) {
		return bookshelfStorage.getBookByISBN(isbn);
	}

	public List<Book> getAllBooks() {
		return bookshelfStorage.getAllBooks();
	}

	public List<Book> createBooks(List<Book> books) {
		return bookshelfStorage.createBooks(books);
	}
}
