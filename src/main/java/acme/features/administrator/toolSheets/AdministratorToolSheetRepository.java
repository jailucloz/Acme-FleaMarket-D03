
package acme.features.administrator.toolSheets;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.repositories.AbstractRepository;

public interface AdministratorToolSheetRepository extends AbstractRepository {

	@Query("select t from ToolSheet t where t.id = ?1")
	ToolSheet findOneById(int id);

	@Query("select t from ToolSheet t")
	Collection<ToolSheet> findMany();

}
