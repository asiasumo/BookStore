package pl.jwoj.storage.persistent;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jwoj.domain.Transaction;
import pl.jwoj.storage.TransactionStorage;
import pl.jwoj.storage.repositories.TransactionRepository;

import java.util.UUID;

public class PersistentTransactionStorage implements TransactionStorage {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction addTransaction(Transaction transaction) {
		transaction.setId(UUID.randomUUID().toString());
		return transactionRepository.save(transaction);
	}
}
