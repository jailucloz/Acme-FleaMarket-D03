
package acme.features.administrator.materialSheets;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.materialSheets.MaterialSheet;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorMaterialSheetListService implements AbstractListService<Administrator, MaterialSheet> {

	@Autowired
	AdministratorMaterialSheetRepository repository;


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

		request.unbind(entity, model, "title", "providerName");
	}

	@Override
	public Collection<MaterialSheet> findMany(final Request<MaterialSheet> request) {
		assert request != null;

		Collection<MaterialSheet> result;

		result = this.repository.findMany();

		return result;
	}

}
