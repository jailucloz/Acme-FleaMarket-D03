
package acme.features.administrator.materialSheets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.materialSheets.MaterialSheet;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorMaterialSheetCreateService implements AbstractCreateService<Administrator, MaterialSheet> {

	// Internal state ---------------------------------------------------------------------------------

	@Autowired
	AdministratorMaterialSheetRepository repository;


	@Override
	public boolean authorise(final Request<MaterialSheet> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<MaterialSheet> request, final MaterialSheet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<MaterialSheet> request, final MaterialSheet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "providerName", "description", "homePage", "stars");
	}

	@Override
	public MaterialSheet instantiate(final Request<MaterialSheet> request) {
		MaterialSheet result;
		result = new MaterialSheet();
		return result;
	}

	@Override
	public void validate(final Request<MaterialSheet> request, final MaterialSheet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<MaterialSheet> request, final MaterialSheet entity) {
		this.repository.save(entity);
	}

}
