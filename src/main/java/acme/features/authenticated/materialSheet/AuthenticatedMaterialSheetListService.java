
package acme.features.authenticated.materialSheet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.materialSheets.MaterialSheet;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMaterialSheetListService implements AbstractListService<Authenticated, MaterialSheet> {

	@Autowired
	AuthenticatedMaterialSheetRepository repository;


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

		request.unbind(entity, model, "title", "providerName", "stars");
	}

	@Override
	public Collection<MaterialSheet> findMany(final Request<MaterialSheet> request) {
		assert request != null;

		Collection<MaterialSheet> result;

		result = this.repository.findManyAll();

		return result;
	}

}
