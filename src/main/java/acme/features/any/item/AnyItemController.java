package acme.features.any.item;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyItemController extends AbstractController<Any, Item>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected AnyItemListComponentService listComponentService;
	
	@Autowired
	protected AnyItemListToolService listToolService;
	
	@Autowired
	protected AnyItemShowService showService;
	
	// Constructors -----------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addCommand("list-component", "list", this.listComponentService);
		super.addCommand("list-tool", "list", this.listToolService);
		super.addCommand("show", this.showService);
	}
		
}
