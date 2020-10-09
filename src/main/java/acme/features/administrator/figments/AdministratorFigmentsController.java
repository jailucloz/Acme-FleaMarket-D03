
package acme.features.administrator.figments;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.figments.Figment;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/figment/")
public class AdministratorFigmentsController extends AbstractController<Administrator, Figment> {

	@Autowired
	private AdministratorFigmentsCreateService	createService;

	@Autowired
	private AdministratorFigmentsUpdateService	updateService;

	@Autowired
	private AdministratorFigmentsDeleteService	deleteService;

	@Autowired
	private AdministratorFigmentsListService	listService;

	@Autowired
	private AdministratorFigmentsShowService	showService;


	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}

}
