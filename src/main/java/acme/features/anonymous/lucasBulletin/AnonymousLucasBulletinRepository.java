
package acme.features.anonymous.lucasBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.LucasBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousLucasBulletinRepository extends AbstractRepository {

	@Query("select bb from LucasBulletin bb")
	Collection<LucasBulletin> findMany();

}
