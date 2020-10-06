
package acme.features.authenticated.suggestion;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedSuggestionListService implements AbstractListService<Authenticated, Suggestion> {

	@Autowired
	AuthenticatedSuggestionRepository repository;


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

		result = this.repository.findManyAll();

		return result;
	}

}
