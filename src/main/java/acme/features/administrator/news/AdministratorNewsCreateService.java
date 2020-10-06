
package acme.features.administrator.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.news.News;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorNewsCreateService implements AbstractCreateService<Administrator, News> {

	@Autowired
	AdministratorNewsRepository repository;


	@Override
	public boolean authorise(final Request<News> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<News> request, final News entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<News> request, final News entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "headerPicture", "title", "deadline", "body", "relatedNews", "category");

	}

	@Override
	public News instantiate(final Request<News> request) {
		News result;
		result = new News();
		return result;
	}

	@Override
	public void validate(final Request<News> request, final News entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<News> request, final News entity) {

		this.repository.save(entity);

	}

}
