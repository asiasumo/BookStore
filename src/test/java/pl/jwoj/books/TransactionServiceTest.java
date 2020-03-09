package pl.jwoj.books;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.jwoj.domain.Book;
import pl.jwoj.domain.Client;
import pl.jwoj.domain.Transaction;
import pl.jwoj.services.TransactionService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {

	@Autowired
	private TransactionService transactionService;

	@Test
	public void transactionIsCreated() {
		List<Book> books = new ArrayList<>();
		books.add(new Book("222","9788328073357","A road to the happy life",
						"Happy life","Mike Prets",32.99f,
						"https://s.lubimyczytac.pl/upload/books/4459000/4459056/761451-352x500.jpg",true, null));
		Transaction transaction = new Transaction("asdasd", books, 33.3, true, new Client());
		Transaction createdTransaction = transactionService.addTransaction(transaction);

		Assert.assertEquals(transaction, createdTransaction);
	}
}
