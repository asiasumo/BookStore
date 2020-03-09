package pl.jwoj.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Book {
	@Id
	private String id;
	private String isbn;
	@Column(length=2000)
	private String description;
	private String title;
	private String author;
	private float price;
	private String cover;
	@JsonIgnore
	private boolean isOnSale;
	@ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Transaction> transactions;
}
