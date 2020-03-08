package pl.jwoj.storage;

import org.springframework.data.repository.CrudRepository;
import pl.jwoj.domain.Client;

public interface ClientRepository extends CrudRepository<Client, String> {
}
