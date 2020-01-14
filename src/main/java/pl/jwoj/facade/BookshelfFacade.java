package pl.jwoj.facade;

import pl.jwoj.controller.AddCoverCommand;
import pl.jwoj.controller.AddDescriptionCommand;
import pl.jwoj.controller.AddPriceCommand;
import pl.jwoj.controller.PutOnSaleCommand;

public interface BookshelfFacade {
	void addPrice(AddPriceCommand command);
	void addDescription(AddDescriptionCommand command);
	void putOnSale(PutOnSaleCommand command);
	void addCover(AddCoverCommand command);
}
