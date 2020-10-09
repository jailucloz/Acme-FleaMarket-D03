
package acme.features.administrator.toolSheets;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/tool-sheet/")
public class AdministratorToolSheetController extends AbstractController<Administrator, ToolSheet> {

	@Autowired
	private AdministratorToolSheetCreateService	createService;

	@Autowired
	private AdministratorToolSheetUpdateService	updateService;

	@Autowired
	private AdministratorToolSheetDeleteService	deleteService;

	@Autowired
	private AdministratorToolSheetListService	listService;

	@Autowired
	private AdministratorToolSheetShowService	showService;


	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}

}
