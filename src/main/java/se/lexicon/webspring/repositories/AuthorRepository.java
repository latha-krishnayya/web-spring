package se.lexicon.webspring.repositories;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.webspring.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
