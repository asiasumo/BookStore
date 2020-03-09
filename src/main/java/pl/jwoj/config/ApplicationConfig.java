package pl.jwoj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.jwoj.services.BookService;
import pl.jwoj.services.ClientService;
import pl.jwoj.services.TransactionService;
import pl.jwoj.storage.BookshelfStorage;
import pl.jwoj.storage.TransactionStorage;
import pl.jwoj.storage.persistent.PersistentBookStorage;
import pl.jwoj.storage.persistent.PersistentTransactionStorage;

@Configuration
public class ApplicationConfig {

	@Bean
	public BookshelfStorage bookshelfStorage() {
		return new PersistentBookStorage();
	}

	@Bean
	public TransactionStorage transactionStorage() {
		return new PersistentTransactionStorage();
	}

	@Bean
	public BookService bookService() {
		return new BookService();
	}

	@Bean
	public ClientService clientService() {
		return new ClientService();
	}

	@Bean
	public TransactionService transactionService() {
		return new TransactionService();
	}

}
