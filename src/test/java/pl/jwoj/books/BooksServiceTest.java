package pl.jwoj.books;
import io.swagger.models.auth.In;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import pl.jwoj.App;
import pl.jwoj.domain.Book;
import pl.jwoj.domain.Transaction;
import pl.jwoj.services.BookService;
import org.springframework.test.context.junit4.SpringRunner;
import pl.jwoj.storage.BookshelfStorage;
import pl.jwoj.storage.inmemory.InMemoryBookshelfStorage;
import pl.jwoj.storage.persistent.PersistentBookStorage;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { App.class })
public class BooksServiceTest {

	@Profile("test")
	@TestConfiguration
	static class BooksServiceTestContextConfiguration {


		@Bean
		@Primary
		public BookService bookServiceConf() {
			return new BookService(new InMemoryBookshelfStorage());
		}

//		@Bean
//		BookService bookServiceConf = new BookService(new InMemoryBookshelfStorage());

	}

	@Autowired
	private BookService bookService;


	@Test
	public void bookIsCreated() {
		List<Transaction> transactions = new ArrayList();

		Book book = new Book("222","9788328073357","A road to the happy life",
				"Happy life","Mike Prets",32.99f,
				"https://s.lubimyczytac.pl/upload/books/4459000/4459056/761451-352x500.jpg",true, transactions);

		Book createdBook = bookService.createBook(book);

		Assert.assertEquals(book, createdBook);

	}

	@Test
	public void multipleBooksAreCreated(){
		List<Transaction> transactions = new ArrayList();
		List<Book> books = new ArrayList<>();

				Book book1 = new Book("222","9788328073357","A road to the happy life",
				"Happy life","Mike Prets",32.99f,
				"https://s.lubimyczytac.pl/upload/books/4459000/4459056/761451-352x500.jpg",true, transactions);
		Book book2 = new Book("223","9788328073857","A road to the happy death",
				"Happy death","Mike Prets",32.99f,
				"https://s.lubimyczytac.pl/upload/books/4459000/4459056/761451-352x500.jpg",true, transactions);
		books.add(book1);
		books.add(book2);
		List<Book> createdBooks = bookService.createBooks(books);


		Assert.assertEquals(books, createdBooks);

	}

}
