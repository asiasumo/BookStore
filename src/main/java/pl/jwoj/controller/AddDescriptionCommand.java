package pl.jwoj.controller;

import lombok.Data;

@Data
public class AddDescriptionCommand {
	private String description;
	private long id;
}
