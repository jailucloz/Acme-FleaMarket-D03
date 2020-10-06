
package acme.features.anonymous.advertisement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/advertisement/")
public class AnonymousAdvertisementController extends AbstractController<Anonymous, Advertisement> {

	@Autowired
	private AnonymousAdvertisementListService	listService;

	@Autowired
	private AnonymousAdvertisementShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
