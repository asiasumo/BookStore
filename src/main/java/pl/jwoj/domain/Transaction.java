package pl.jwoj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
	@Id
	private String id;
	@ManyToMany
	@JoinColumn
	private List<Book> books;
	private double price;
	private boolean isInvoice;
	@OneToOne
	@JoinColumn
	private Client client;
}
