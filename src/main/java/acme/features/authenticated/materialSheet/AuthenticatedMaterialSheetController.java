
package acme.features.authenticated.materialSheet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.materialSheets.MaterialSheet;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/material-sheet/")
public class AuthenticatedMaterialSheetController extends AbstractController<Authenticated, MaterialSheet> {

	@Autowired
	private AuthenticatedMaterialSheetListService	listService;

	@Autowired
	private AuthenticatedMaterialSheetShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
