package pl.jwoj.controller;

import lombok.Data;

@Data
public class PutOnSaleCommand {
	private boolean isOnSale;
	private long id;
}
