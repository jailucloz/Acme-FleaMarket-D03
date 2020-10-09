
package acme.features.administrator.figments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.figments.Figment;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorFigmentsShowService implements AbstractShowService<Administrator, Figment> {

	@Autowired
	private AdministratorFigmentsRepository repository;


	@Override
	public boolean authorise(final Request<Figment> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Figment> request, final Figment entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "inventorName", "minMoney", "maxMoney", "creationMoment");

	}

	@Override
	public Figment findOne(final Request<Figment> request) {
		assert request != null;

		Figment result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
