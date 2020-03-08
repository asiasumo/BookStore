package pl.jwoj.books;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import pl.jwoj.domain.Book;
import pl.jwoj.domain.Transaction;
import pl.jwoj.services.BookService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksControllerTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public BookService employeeService() {
			return new BookService();
		}

	}

	@Autowired
	private BookService bookService;

	@Test
	public void isBookCreated() {
		List<Transaction> transactions = new ArrayList();

		Book book = new Book("2","9788328073357","A road to the happy life",
				"Happy life","Mike Prets",32.99f,
				"https://s.lubimyczytac.pl/upload/books/4459000/4459056/761451-352x500.jpg",true, transactions);

		Book createdBook = bookService.createBook(book);

		Assert.assertEquals(book, createdBook);

	}

}