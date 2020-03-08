package pl.jwoj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
	@Id
	private String id;
	private String email;
	private String name;
	private String surname;
	private String nip;
	private String companyName;
	@OneToOne(mappedBy = "client")
	private Transaction transaction;
}
