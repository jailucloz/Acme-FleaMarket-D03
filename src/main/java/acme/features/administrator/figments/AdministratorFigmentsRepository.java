
package acme.features.administrator.figments;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.figments.Figment;
import acme.framework.repositories.AbstractRepository;

public interface AdministratorFigmentsRepository extends AbstractRepository {

	@Query("select f from Figment f where f.id = ?1")
	Figment findOneById(int id);

	@Query("select f from Figment f")
	Collection<Figment> findMany();

}
