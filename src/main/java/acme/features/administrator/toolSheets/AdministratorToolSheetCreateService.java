
package acme.features.administrator.toolSheets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorToolSheetCreateService implements AbstractCreateService<Administrator, ToolSheet> {

	// Internal state ---------------------------------------------------------------------------------

	@Autowired
	AdministratorToolSheetRepository repository;


	@Override
	public boolean authorise(final Request<ToolSheet> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<ToolSheet> request, final ToolSheet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<ToolSheet> request, final ToolSheet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "providerName", "description", "homePage", "stars");
	}

	@Override
	public ToolSheet instantiate(final Request<ToolSheet> request) {
		ToolSheet result;
		result = new ToolSheet();
		return result;
	}

	@Override
	public void validate(final Request<ToolSheet> request, final ToolSheet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<ToolSheet> request, final ToolSheet entity) {
		this.repository.save(entity);
	}

}
