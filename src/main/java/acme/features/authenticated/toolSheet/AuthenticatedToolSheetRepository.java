
package acme.features.authenticated.toolSheet;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedToolSheetRepository extends AbstractRepository {

	@Query("select ts from ToolSheet ts where ts.id = ?1")
	ToolSheet findOneById(int id);

	@Query("select ts from ToolSheet ts")
	Collection<ToolSheet> findManyAll();

}
