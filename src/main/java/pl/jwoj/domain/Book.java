package pl.jwoj.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private String isbn;
	@JsonIgnore private long id;
	private String description;
	private String title;
	private String author;
	private float price;
	private String cover;
	@JsonIgnore private boolean isOnSale;

}

