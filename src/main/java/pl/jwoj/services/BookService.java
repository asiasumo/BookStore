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

	public void removeBook(String id) {
		bookshelfStorage.removeBook(id);
	}

	public void removeBooks(List<String> ids) {
		bookshelfStorage.removeBooks(ids);
	}
}
