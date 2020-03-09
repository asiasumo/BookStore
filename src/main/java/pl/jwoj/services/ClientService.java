package pl.jwoj.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jwoj.domain.Client;
import pl.jwoj.storage.repositories.ClientRepository;

import java.util.UUID;

public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client addClient(Client client) {
		client.setId(UUID.randomUUID().toString());
		return clientRepository.save(client);
	}
}
