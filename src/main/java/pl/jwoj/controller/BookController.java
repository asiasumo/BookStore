package pl.jwoj.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jwoj.config.exceptions.BookNotFoundException;
import pl.jwoj.domain.Book;
import pl.jwoj.services.BookService;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
@NoArgsConstructor
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/create")
	public Book createBook(Book book) {
		return bookService.createBook(book);
	}

	@GetMapping("/{isbn}")
	public Book getBookByISBN(@PathVariable("isbn") String isbn) throws BookNotFoundException {
		return bookService.getBookByISBN(isbn);
	}

}
