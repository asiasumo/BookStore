package pl.jwoj.config;


import pl.jwoj.facade.BookShelfFacadeImp;
import pl.jwoj.facade.BookshelfFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.jwoj.storage.BookshelfStorage;

@Configuration
public class BookShelfConfig {

	@Bean
	public BookshelfFacade bookshelfFacade(){
		return new BookShelfFacadeImp(new BookshelfStorage());
	}

}
