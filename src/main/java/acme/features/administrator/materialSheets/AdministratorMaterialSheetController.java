
package acme.features.administrator.materialSheets;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.materialSheets.MaterialSheet;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/material-sheet/")
public class AdministratorMaterialSheetController extends AbstractController<Administrator, MaterialSheet> {

	@Autowired
	private AdministratorMaterialSheetCreateService	createService;

	@Autowired
	private AdministratorMaterialSheetUpdateService	updateService;

	@Autowired
	private AdministratorMaterialSheetDeleteService	deleteService;

	@Autowired
	private AdministratorMaterialSheetListService	listService;

	@Autowired
	private AdministratorMaterialSheetShowService	showService;


	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}

}
