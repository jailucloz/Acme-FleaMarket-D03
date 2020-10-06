
package acme.features.anonymous.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousAdvertisementShowService implements AbstractShowService<Anonymous, Advertisement> {

	@Autowired
	private AnonymousAdvertisementRepository repository;


	@Override
	public boolean authorise(final Request<Advertisement> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Advertisement> request, final Advertisement entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creationMoment", "deadline", "initialTime", "title", "smallDiscount", "averageDiscount", "largeDiscount", "description", "picture");

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

}
