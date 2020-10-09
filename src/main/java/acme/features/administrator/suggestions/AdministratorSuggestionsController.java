
package acme.features.administrator.suggestions;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/suggestion/")
public class AdministratorSuggestionsController extends AbstractController<Administrator, Suggestion> {

	@Autowired
	private AdministratorSuggestionsCreateService	createService;

	@Autowired
	private AdministratorSuggestionsUpdateService	updateService;

	@Autowired
	private AdministratorSuggestionsDeleteService	deleteService;

	@Autowired
	private AdministratorSuggestionsListService		listService;

	@Autowired
	private AdministratorSuggestionsShowService		showService;


	@PostConstruct
	private void initialise() {

		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}

}
