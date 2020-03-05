package pl.jwoj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	private String email;
	private String name;
	private String surname;
	private String nip;
	private String companyName;
}
