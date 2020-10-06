
package acme.features.anonymous.lucasBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.LucasBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousLucasBulletinCreateService implements AbstractCreateService<Anonymous, LucasBulletin> {

	@Autowired
	AnonymousLucasBulletinRepository repository;


	@Override
	public boolean authorise(final Request<LucasBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<LucasBulletin> request, final LucasBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<LucasBulletin> request, final LucasBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "text");

	}

	@Override
	public LucasBulletin instantiate(final Request<LucasBulletin> request) {
		assert request != null;

		LucasBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new LucasBulletin();
		result.setAuthor("Jaime Lucas");
		result.setText("Lorem ipsum!");
		result.setMoment(moment);

		return result;
	}

	@Override
	public void validate(final Request<LucasBulletin> request, final LucasBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<LucasBulletin> request, final LucasBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
