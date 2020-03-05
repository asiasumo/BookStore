package pl.jwoj.productCatalog.controller;

import pl.jwoj.controller.AddCoverCommand;
import pl.jwoj.controller.AddDescriptionCommand;
import pl.jwoj.controller.AddPriceCommand;
import pl.jwoj.controller.PutOnSaleCommand;
import pl.jwoj.facade.BookshelfFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

	BookshelfFacade api;

	@Autowired
	public BookController(BookshelfFacade api) {
		this.api = api;
	}

	//http://localhost:8080/api/books/

	@PatchMapping("/price")
	public void addPrice(@RequestBody AddPriceCommand command) {
		api.addPrice(command);
	}
	@PatchMapping("/description")
	public void addDescription(@RequestBody AddDescriptionCommand command) {
		api.addDescription(command);
	}
	@PatchMapping("/sale")
	public void putOnSale(@RequestBody PutOnSaleCommand command) {
		api.putOnSale(command);
	}
	@PatchMapping("/cover")
	public void addCover(@RequestBody AddCoverCommand command) {
		api.addCover(command);
	}

}
