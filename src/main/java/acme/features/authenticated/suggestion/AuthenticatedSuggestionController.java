
package acme.features.authenticated.suggestion;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/suggestion/")
public class AuthenticatedSuggestionController extends AbstractController<Authenticated, Suggestion> {

	@Autowired
	private AuthenticatedSuggestionListService	listService;

	@Autowired
	private AuthenticatedSuggestionShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
