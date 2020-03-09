package pl.jwoj.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jwoj.domain.Transaction;
import pl.jwoj.services.TransactionService;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping(value = "addTransaction")
	public Transaction fulfillTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}
}
