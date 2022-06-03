package acme.features.patron.chimpumDashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.forms.ChimpumDashboard;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronChimpumDashboardController extends AbstractController<Patron, ChimpumDashboard>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	PatronChimpumDashboardShowService showService;
	
	// Constructors -----------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
	}
}
