package pl.jwoj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private List<Long> bookIds;
	private double price;
	private boolean isInvoice;
	private Client client;
}
