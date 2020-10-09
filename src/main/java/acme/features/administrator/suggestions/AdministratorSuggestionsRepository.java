
package acme.features.administrator.suggestions;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.suggestions.Suggestion;
import acme.framework.repositories.AbstractRepository;

public interface AdministratorSuggestionsRepository extends AbstractRepository {

	@Query("select s from Suggestion s where s.id = ?1")
	Suggestion findOneById(int id);

	@Query("select s from Suggestion s")
	Collection<Suggestion> findMany();

}
