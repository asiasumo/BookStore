package pl.jwoj.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jwoj.domain.Book;
import pl.jwoj.storage.BookshelfStorage;

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
}
