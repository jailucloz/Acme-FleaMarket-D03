
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
			Boolean isEuroSmall, isEuroAverage, isEuroLarge, isFuture, isFuture2, isDeadlineAfterInitialTime, isPositiveSmall, isPositiveAverage, isPositiveLarge;

			Date fechaActual;
			fechaActual = new Date();
			isFuture = entity.getDeadline().after(fechaActual);
			errors.state(request, isFuture, "deadline", "errors.advertisement.deadline.future", "Deadline must be in future");

			isFuture2 = entity.getInitialTime().after(fechaActual);
			errors.state(request, isFuture2, "initialTime", "errors.advertisement.initialTime.future", "Initial time must be in future");

			isDeadlineAfterInitialTime = entity.getDeadline().after(entity.getInitialTime());
			errors.state(request, isDeadlineAfterInitialTime, "deadline", "errors.advertisement.deadlineAfterInitial.future", "Deadline must be after the initial time");

			isEuroSmall = entity.getSmallDiscount().getCurrency().equals("€") || entity.getSmallDiscount().getCurrency().equals("EUR");
			errors.state(request, isEuroSmall, "smallDiscount", "errors.advertisement.smallDiscount.euro", "The money must be in euro '€' / 'EUR'");

			isEuroAverage = entity.getAverageDiscount().getCurrency().equals("€") || entity.getAverageDiscount().getCurrency().equals("EUR");
			errors.state(request, isEuroAverage, "averageDiscount", "errors.advertisement.averageDiscount.money.euro", "The money must be in euro '€' / 'EUR'");

			isEuroLarge = entity.getLargeDiscount().getCurrency().equals("€") || entity.getLargeDiscount().getCurrency().equals("EUR");
			errors.state(request, isEuroLarge, "largeDiscount", "errors.advertisement.largeDiscount.money.euro", "The money must be in euro '€' / 'EUR'");

			isPositiveSmall = entity.getSmallDiscount().getAmount() > 0;
			errors.state(request, isPositiveSmall, "smallDiscount", "errors.advertisement.smallDiscount.positive", "The amount must be positive");

			isPositiveAverage = entity.getAverageDiscount().getAmount() > 0;
			errors.state(request, isPositiveAverage, "averageDiscount", "errors.advertisement.averageDiscount.positive", "The amount must be positive");

			isPositiveLarge = entity.getLargeDiscount().getAmount() > 0;
			errors.state(request, isPositiveLarge, "largeDiscount", "errors.advertisement.largeDiscount.positive", "The amount must be positive");

		}
	}

	@Override
	public void create(final Request<Advertisement> request, final Advertisement entity) {
		this.repository.save(entity);
	}

}
