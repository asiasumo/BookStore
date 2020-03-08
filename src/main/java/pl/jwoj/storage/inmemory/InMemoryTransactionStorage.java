package pl.jwoj.storage.inmemory;

import org.springframework.stereotype.Repository;
import pl.jwoj.domain.Transaction;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryTransactionStorage {

	private final ConcurrentHashMap<String, Transaction> transactions;

	public InMemoryTransactionStorage() {
		this.transactions = new ConcurrentHashMap<>();
	}

	public Transaction addTransaction(Transaction transaction) {
		String id = UUID.randomUUID().toString();
		transactions.put(id, transaction);
		return transactions.get(id);
	}

}
