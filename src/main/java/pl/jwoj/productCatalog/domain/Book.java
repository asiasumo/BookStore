package pl.jwoj.productCatalog.domain;

import lombok.Data;

@Data
public class Book {
	private long id;
	private String description;
	private String title;
	private String author;
	private float price;
	private String cover;
	private boolean isOnSale;

}

