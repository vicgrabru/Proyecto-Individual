package acme.features.inventor.toolkit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.ToolKit;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolKitController extends AbstractController<Inventor, ToolKit>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorToolKitListService listService;
	
	@Autowired
	protected InventorToolKitShowService showService;
	
	@Autowired
	protected InventorToolKitCreateService createService;
	
	@Autowired
	protected InventorToolKitDeleteService deleteService;
	
	@Autowired
	protected InventorToolKitUpdateService updateService;
	
	@Autowired
	protected InventorToolKitPublishService publishService;
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("delete", this.deleteService);
		super.addCommand("update", this.updateService);
		super.addCommand("publish", "update", this.publishService);
	}
	
}
