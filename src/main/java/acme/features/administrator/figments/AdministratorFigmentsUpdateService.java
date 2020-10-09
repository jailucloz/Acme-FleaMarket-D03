
package acme.features.administrator.figments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.figments.Figment;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorFigmentsUpdateService implements AbstractUpdateService<Administrator, Figment> {

	// Internal state ---------------------------------------------------------------------------------

	@Autowired
	AdministratorFigmentsRepository repository;


	// AbstractCreateService<Authenticated, Figment> interface --------------------------------------

	@Override
	public boolean authorise(final Request<Figment> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Figment> request, final Figment entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Figment> request, final Figment entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "inventorName", "minMoney", "maxMoney");
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

	@Override
	public void validate(final Request<Figment> request, final Figment entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors()) {
			Boolean isEuroMin, isEuroMax, isPositiveMin, isPositiveMax;

			isEuroMin = entity.getMinMoney().getCurrency().equals("€") || entity.getMinMoney().getCurrency().equals("EUR");
			errors.state(request, isEuroMin, "minMoney", "errors.inquire.minMoney.euro", "The money must be in euro '€' / 'EUR'");

			isEuroMax = entity.getMaxMoney().getCurrency().equals("€") || entity.getMaxMoney().getCurrency().equals("EUR");
			errors.state(request, isEuroMax, "maxMoney", "errors.inquire.maxMoney.money.euro", "The money must be in euro '€' / 'EUR'");

			isPositiveMin = entity.getMinMoney().getAmount() > 0;
			errors.state(request, isPositiveMin, "minMoney", "errors.inquire.minMoney.positive", "The amount must be positive");

			isPositiveMax = entity.getMaxMoney().getAmount() > 0;
			errors.state(request, isPositiveMax, "minMoney", "errors.inquire.maxMoney.positive", "The amount must be positive");

		}

	}

	@Override
	public void update(final Request<Figment> request, final Figment entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
