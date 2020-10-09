
package acme.features.administrator.suggestions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorSuggestionsCreateService implements AbstractCreateService<Administrator, Suggestion> {

	// Internal state ---------------------------------------------------------------------------------

	@Autowired
	AdministratorSuggestionsRepository repository;


	@Override
	public boolean authorise(final Request<Suggestion> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Suggestion> request, final Suggestion entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Suggestion> request, final Suggestion entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "email");
	}

	@Override
	public Suggestion instantiate(final Request<Suggestion> request) {
		Suggestion result;
		result = new Suggestion();
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		result.setCreationMoment(moment);
		return result;

	}

	@Override
	public void validate(final Request<Suggestion> request, final Suggestion entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Suggestion> request, final Suggestion entity) {
		this.repository.save(entity);
	}

}
