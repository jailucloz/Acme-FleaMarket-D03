
package acme.features.anonymous.lucasBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.LucasBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousLucasBulletinListService implements AbstractListService<Anonymous, LucasBulletin> {

	@Autowired
	AnonymousLucasBulletinRepository repository;


	@Override
	public boolean authorise(final Request<LucasBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<LucasBulletin> request, final LucasBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text", "moment");

	}

	@Override
	public Collection<LucasBulletin> findMany(final Request<LucasBulletin> request) {
		assert request != null;

		Collection<LucasBulletin> result;

		result = this.repository.findMany();

		return result;
	}

}
