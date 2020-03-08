package pl.jwoj.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.jwoj.domain.Client;

public interface ClientRepository extends CrudRepository<Client, String> {
}
