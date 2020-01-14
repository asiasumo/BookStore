package pl.jwoj.storage;

import pl.jwoj.domain.Book;

import java.util.concurrent.ConcurrentHashMap;

public class BookshelfStorage {
	private final ConcurrentHashMap<Long, Book> books;

	public BookshelfStorage() {
		this.books = new ConcurrentHashMap<>();
	}
	public void add(Book book) {
		this.books.put(book.getId(), book);
	}


	public void setPrice(Long id, float price) {
		Book book = books.get(id);
		book.setPrice(price);
		books.put(id,book);
	}


	public void setDescription(Long id, String description) {
		Book book = books.get(id);
		book.setDescription(description);
		books.put(id,book);

	}

	public void setOnSale(Long id, boolean onSale) {
		Book book = books.get(id);
		book.setOnSale(onSale);
		books.put(id,book);

	}

	public void setCover(Long id, String cover) {
		Book book = books.get(id);
		book.setCover(cover);
		books.put(id,book);
	}

}
