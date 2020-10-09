
package acme.features.administrator.advertisement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAdvertisementCreateService implements AbstractCreateService<Administrator, Advertisement> {

	// Internal state ---------------------------------------------------------------------------------

	@Autowired
	AdministratorAdvertisementRepository repository;


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

		request.unbind(entity, model, "title", "picture", "initialTime", "deadline", "description", "smallDiscount", "averageDiscount", "largeDiscount");
	}

	@Override
	public Advertisement instantiate(final Request<Advertisement> request) {
		Advertisement result;
		result = new Advertisement();
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		result.setCreationMoment(moment);
		return result;

	}

	@Override
	public void validate(final Request<Advertisement> request, final Advertisement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors()) {
			Boolean isEuroSmall, isEuroAverage, isEuroLarge, isFuture, isPositiveSmall, isPositiveAverage, isPositiveLarge;

			Date fechaActual;
			fechaActual = new Date();
			isFuture = entity.getDeadline().after(fechaActual);
			errors.state(request, isFuture, "deadline", "errors.inquire.deadline.future", "Deadline must be in future");

			isEuroSmall = entity.getSmallDiscount().getCurrency().equals("€") || entity.getSmallDiscount().getCurrency().equals("EUR");
			errors.state(request, isEuroSmall, "smallDiscount", "errors.inquire.smallDiscount.euro", "The money must be in euro '€' / 'EUR'");

			isEuroAverage = entity.getAverageDiscount().getCurrency().equals("€") || entity.getAverageDiscount().getCurrency().equals("EUR");
			errors.state(request, isEuroAverage, "averageDiscount", "errors.inquire.averageDiscount.money.euro", "The money must be in euro '€' / 'EUR'");

			isEuroLarge = entity.getLargeDiscount().getCurrency().equals("€") || entity.getLargeDiscount().getCurrency().equals("EUR");
			errors.state(request, isEuroLarge, "largeDiscount", "errors.inquire.largeDiscount.money.euro", "The money must be in euro '€' / 'EUR'");

			isPositiveSmall = entity.getSmallDiscount().getAmount() > 0;
			errors.state(request, isPositiveSmall, "smallDiscount", "errors.inquire.smallDiscount.positive", "The amount must be positive");

			isPositiveAverage = entity.getAverageDiscount().getAmount() > 0;
			errors.state(request, isPositiveAverage, "averageDiscount", "errors.inquire.averageDiscount.positive", "The amount must be positive");

			isPositiveLarge = entity.getLargeDiscount().getAmount() > 0;
			errors.state(request, isPositiveLarge, "largeDiscount", "errors.inquire.largeDiscount.positive", "The amount must be positive");

		}
	}

	@Override
	public void create(final Request<Advertisement> request, final Advertisement entity) {
		this.repository.save(entity);
	}

}
