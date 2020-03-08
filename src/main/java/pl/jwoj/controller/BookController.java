package pl.jwoj.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;
import pl.jwoj.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
@NoArgsConstructor
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/create")
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@PostMapping(value = "/createBatch", consumes = "application/json", produces = "application/json")
	public List<Book> createBooks(@RequestBody List<Book> books) {
		return bookService.createBooks(books);
	}

	@GetMapping("/{isbn}")
	public List<Book> getBooksByISBN(@PathVariable("isbn") String isbn) throws BookNotFoundException {
		return bookService.getBooksByISBN(isbn);
	}

	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}


}
