
package acme.features.administrator.customisations;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.customisations.Customisation;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/customisation/")
public class AdministratorCustomisationController extends AbstractController<Administrator, Customisation> {

	@Autowired
	private AdministratorCustomisationListService		listService;
	@Autowired
	private AdministratorCustomisationShowService		showService;
	@Autowired
	private AdministratorCustomisationListMainService	listMainService;
	@Autowired
	private AdministratorCustomisationDisplayService	displayService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_MAIN, BasicCommand.LIST, this.listMainService);
		super.addCustomCommand(CustomCommand.DISPLAY, BasicCommand.SHOW, this.displayService);
	}
}
