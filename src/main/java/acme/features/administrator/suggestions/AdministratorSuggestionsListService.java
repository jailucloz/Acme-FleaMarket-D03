
package acme.features.administrator.suggestions;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorSuggestionsListService implements AbstractListService<Administrator, Suggestion> {

	@Autowired
	AdministratorSuggestionsRepository repository;


	@Override
	public boolean authorise(final Request<Suggestion> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Suggestion> request, final Suggestion entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment");
	}

	@Override
	public Collection<Suggestion> findMany(final Request<Suggestion> request) {
		assert request != null;

		Collection<Suggestion> result;

		result = this.repository.findMany();

		return result;
	}

}
