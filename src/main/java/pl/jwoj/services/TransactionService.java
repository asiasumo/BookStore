package pl.jwoj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jwoj.domain.Transaction;
import pl.jwoj.storage.inmemory.InMemoryTransactionStorage;

@Service
public class TransactionService {

	@Autowired
	private InMemoryTransactionStorage inMemoryTransactionStorage;

	public Transaction addTransaction(Transaction transaction) {
		return inMemoryTransactionStorage.addTransaction(transaction);
	}
}
