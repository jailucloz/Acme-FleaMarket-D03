
package acme.features.anonymous.toolSheet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.toolSheets.ToolSheet;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/tool-sheet/")
public class AnonymousToolSheetController extends AbstractController<Anonymous, ToolSheet> {

	@Autowired
	private AnonymousToolSheetListService	listService;

	@Autowired
	private AnonymousToolSheetShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
