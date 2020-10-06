
package acme.features.authenticated.suggestion;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.suggestions.Suggestion;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedSuggestionRepository extends AbstractRepository {

	@Query("select s from Suggestion s where s.id = ?1")
	Suggestion findOneById(int id);

	@Query("select s from Suggestion s")
	Collection<Suggestion> findManyAll();

}
