
package acme.features.administrator.customisations;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisations.Customisation;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorCustomisationListMainService implements AbstractListService<Administrator, Customisation> {

	@Autowired
	private AdministratorCustomisationRepository repository;


	@Override
	public boolean authorise(final Request<Customisation> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Customisation> request, final Customisation entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "spam");
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		StringBuilder thresholdPercent = new StringBuilder();
		thresholdPercent.append(numberFormat.format(entity.getThreshold()));
		thresholdPercent.append("%");
		model.setAttribute("spamThresholdPercent", thresholdPercent.toString());

	}

	@Override
	public Collection<Customisation> findMany(final Request<Customisation> request) {
		assert request != null;
		Collection<Customisation> customisations;
		customisations = this.repository.findManyAll();
		Collection<Customisation> result = new HashSet<Customisation>();
		result.add(customisations.iterator().next());
		return result;
	}

}
