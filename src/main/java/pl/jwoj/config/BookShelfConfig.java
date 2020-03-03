package pl.jwoj.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.jwoj.services.BookService;
import pl.jwoj.storage.BookshelfStorage;
import pl.jwoj.storage.InMemoryBookshelfStorage;

@Configuration
public class BookShelfConfig {

	@Bean
	public BookService bookService() {
		return new BookService();
	}

	@Bean
	public BookshelfStorage bookshelfStorage() {
		return new InMemoryBookshelfStorage();
	}

}
