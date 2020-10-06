
package acme.features.authenticated.advertisement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/advertisement/")
public class AuthenticatedAdvertisementController extends AbstractController<Authenticated, Advertisement> {

	@Autowired
	private AuthenticatedAdvertisementListService	listService;

	@Autowired
	private AuthenticatedAdvertisementShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
