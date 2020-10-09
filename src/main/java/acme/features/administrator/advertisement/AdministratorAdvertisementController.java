
package acme.features.administrator.advertisement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/advertisement/")
public class AdministratorAdvertisementController extends AbstractController<Administrator, Advertisement> {

	@Autowired
	private AdministratorAdvertisementListService	listService;

	@Autowired
	private AdministratorAdvertisementShowService	showService;

	@Autowired
	private AdministratorAdvertisementCreateService	createService;

	@Autowired
	private AdministratorAdvertisementUpdateService	updateService;

	@Autowired
	private AdministratorAdvertisementDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
