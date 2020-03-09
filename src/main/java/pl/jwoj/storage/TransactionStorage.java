package pl.jwoj.storage;

import pl.jwoj.domain.Transaction;

public interface TransactionStorage {
	Transaction addTransaction(Transaction transaction);
}
