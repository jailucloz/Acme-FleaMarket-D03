
package acme.features.anonymous.toolSheet;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousToolSheetRepository extends AbstractRepository {

	@Query("select ts from ToolSheet ts where ts.id = ?1")
	ToolSheet findOneById(int id);

	@Query("select ts from ToolSheet ts")
	Collection<ToolSheet> findManyAll();

}
