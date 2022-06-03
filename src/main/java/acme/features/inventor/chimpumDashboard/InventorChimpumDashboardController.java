package acme.features.inventor.chimpumDashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.forms.ChimpumDashboard;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorChimpumDashboardController extends AbstractController<Inventor, ChimpumDashboard>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	InventorChimpumDashboardShowService showService;
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
	}
}
