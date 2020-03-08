package pl.jwoj.storage;

import org.springframework.data.repository.CrudRepository;
import pl.jwoj.domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
