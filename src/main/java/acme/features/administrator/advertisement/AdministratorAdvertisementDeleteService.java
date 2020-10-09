
package acme.features.administrator.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorAdvertisementDeleteService implements AbstractDeleteService<Administrator, Advertisement> {

	// Internal state -----------------------------------------------------------------------

	@Autowired
	AdministratorAdvertisementRepository repository;


	// AbstractDeleteService<Administrator, Advertisement> interface -------------------------

	@Override
	public boolean authorise(final Request<Advertisement> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Advertisement> request, final Advertisement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Advertisement> request, final Advertisement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "deadline", "smallDiscount", "averageDiscount", "largeDiscount", "initialTime", "deadline");
	}

	@Override
	public Advertisement findOne(final Request<Advertisement> request) {
		assert request != null;

		Advertisement result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Advertisement> request, final Advertisement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Advertisement> request, final Advertisement entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}
