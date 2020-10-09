
package acme.features.administrator.materialSheets;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.materialSheets.MaterialSheet;
import acme.framework.repositories.AbstractRepository;

public interface AdministratorMaterialSheetRepository extends AbstractRepository {

	@Query("select m from MaterialSheet m where m.id = ?1")
	MaterialSheet findOneById(int id);

	@Query("select m from MaterialSheet m")
	Collection<MaterialSheet> findMany();

}
