
package acme.features.administrator.customisations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisations.Customisation;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorCustomisationUpdateService implements AbstractUpdateService<Administrator, Customisation> {

	@Autowired
	AdministratorCustomisationRepository repository;


	@Override
	public boolean authorise(final Request<Customisation> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Customisation> request, final Customisation entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Customisation> request, final Customisation entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "spam", "threshold", "activitySectors");
	}

	@Override
	public Customisation findOne(final Request<Customisation> request) {
		assert request != null;
		Customisation res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.repository.findCustomisationById(id);
		return res;

	}

	@Override
	public void validate(final Request<Customisation> request, final Customisation entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<Customisation> request, final Customisation entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
