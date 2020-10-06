
package acme.features.anonymous.toolSheet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousToolSheetListService implements AbstractListService<Anonymous, ToolSheet> {

	@Autowired
	AnonymousToolSheetRepository repository;


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
