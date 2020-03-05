package pl.jwoj.facade;

import pl.jwoj.controller.AddCoverCommand;
import pl.jwoj.controller.AddDescriptionCommand;
import pl.jwoj.controller.AddPriceCommand;
import pl.jwoj.controller.PutOnSaleCommand;
import pl.jwoj.productCatalog.storage.BookshelfStorage;

public class BookShelfFacadeImp implements BookshelfFacade {


	private final BookshelfStorage storage;

	public BookShelfFacadeImp(BookshelfStorage bookShelfStorage) {
		this.storage = bookShelfStorage;
	}

	public void addPrice(AddPriceCommand command) {
		storage.setPrice(command.getId(),command.getPrice());

	}


	public void addDescription(AddDescriptionCommand command) {
		storage.setDescription(command.getId(),command.getDescription());

	}

	public void putOnSale(PutOnSaleCommand command) {
		storage.setOnSale(command.getId(),command.isOnSale());
	}

	public void addCover(AddCoverCommand command) {
		storage.setCover(command.getId(),command.getCover());
	}

}
