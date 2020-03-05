package pl.jwoj.books;

import org.junit.Assert;
import org.junit.Test;
import pl.jwoj.productCatalog.domain.Book;

public class bookTest {


	@Test
	public void itAllowsAssigningData() {

		Book book = new Book();

		book.setPrice(134);
		float finalPrice = book.getPrice();
		Assert.assertTrue(finalPrice == 134);

	}
}
