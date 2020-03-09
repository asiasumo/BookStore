package pl.jwoj.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jwoj.domain.Transaction;
import pl.jwoj.storage.TransactionStorage;

public class TransactionService {

	@Autowired
	TransactionStorage transactionStorage;
	@Autowired
	ClientService clientService;

	public Transaction addTransaction(Transaction transaction) {
		transaction.setClient(clientService.addClient(transaction.getClient()));
		return transactionStorage.addTransaction(transaction);
	}
}
