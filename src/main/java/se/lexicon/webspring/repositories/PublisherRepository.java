package se.lexicon.webspring.repositories;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.webspring.domain.Publisher;

import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {



}
