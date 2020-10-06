
package acme.features.authenticated.toolSheet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedToolSheetListService implements AbstractListService<Authenticated, ToolSheet> {

	@Autowired
	AuthenticatedToolSheetRepository repository;


	@Override
	public boolean authorise(final Request<ToolSheet> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ToolSheet> request, final ToolSheet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "providerName", "stars");
	}

	@Override
	public Collection<ToolSheet> findMany(final Request<ToolSheet> request) {
		assert request != null;

		Collection<ToolSheet> result;

		result = this.repository.findManyAll();

		return result;
	}

}
