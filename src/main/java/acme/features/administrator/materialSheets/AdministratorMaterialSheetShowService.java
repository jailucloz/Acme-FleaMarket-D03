
package acme.features.administrator.materialSheets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.materialSheets.MaterialSheet;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorMaterialSheetShowService implements AbstractShowService<Administrator, MaterialSheet> {

	@Autowired
	private AdministratorMaterialSheetRepository repository;


	@Override
	public boolean authorise(final Request<MaterialSheet> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<MaterialSheet> request, final MaterialSheet entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "providerName", "description", "homePage", "stars");

	}

	@Override
	public MaterialSheet findOne(final Request<MaterialSheet> request) {
		assert request != null;

		MaterialSheet result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
