
package acme.features.authenticated.toolSheet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/tool-sheet/")
public class AuthenticatedToolSheetController extends AbstractController<Authenticated, ToolSheet> {

	@Autowired
	private AuthenticatedToolSheetListService	listService;

	@Autowired
	private AuthenticatedToolSheetShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
