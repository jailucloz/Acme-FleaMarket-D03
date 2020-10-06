
package acme.features.anonymous.news;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.news.News;
import acme.framework.repositories.AbstractRepository;

public interface AnonymousNewsRepository extends AbstractRepository {

	@Query("select n from News n where n.id = ?1")
	News findOneById(int id);

	@Query("select n from News n where n.deadline > CURRENT_TIMESTAMP")
	Collection<News> findManyActive();

}
