package pl.jwoj.storage;

import org.springframework.data.repository.CrudRepository;
import pl.jwoj.domain.Book;

public interface BookRepository extends CrudRepository<Book, String> {
}
