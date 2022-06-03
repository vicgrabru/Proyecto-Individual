package acme.features.patron.chimpumDashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.ChimpumDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronChimpumDashboardShowService implements AbstractShowService<Patron, ChimpumDashboard>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired	
	PatronChimpumDashboardRepository repository;
	
	// AbstractShowService<Patron, PatronDashboard> interface --------------
	
	@Override
	public boolean authorise(final Request<ChimpumDashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public ChimpumDashboard findOne(final Request<ChimpumDashboard> request) {
		assert request != null;
		
		ChimpumDashboard result;
		result = new ChimpumDashboard();
		Double ratio, amount;
		Map<String, Money> budgetMap;
		
		budgetMap = new HashMap<>();
		ratio = 100.0 * this.repository.countChimpumps()/this.repository.countItems();
		result.setChimpumRatio(ratio);
		
		List<Object[]> chimpumCollection;
		Money budget;
		String currency;
		
		chimpumCollection = this.repository.averageBudgetsOfChimpumpByCurrency();
		for(int i = 0; i < chimpumCollection.size(); i++) {
			budget = new Money();
			currency = (String) chimpumCollection.get(i)[0];
			amount = (Double) chimpumCollection.get(i)[1];
			budget.setAmount(amount);
			budget.setCurrency(currency);
			budgetMap.put(currency, budget);
		}
		result.setAverageBudgetOfChimpumpsByCurrency(budgetMap);
		budgetMap.clear();
		
		chimpumCollection = this.repository.deviationBudgetsOfChimpumpByCurrency();
		for(int i = 0; i < chimpumCollection.size(); i++) {
			budget = new Money();
			currency = (String) chimpumCollection.get(i)[0];
			amount = (Double) chimpumCollection.get(i)[1];
			budget.setAmount(amount);
			budget.setCurrency(currency);
			budgetMap.put(currency, budget);
		}
		result.setDeviationBudgetOfChimpumpsByCurrency(budgetMap);
		budgetMap.clear();
		
		chimpumCollection = this.repository.maximumBudgetsOfChimpumpByCurrency();
		for(int i = 0; i < chimpumCollection.size(); i++) {
			budget = new Money();
			currency = (String) chimpumCollection.get(i)[0];
			amount = (Double) chimpumCollection.get(i)[1];
			budget.setAmount(amount);
			budget.setCurrency(currency);
			budgetMap.put(currency, budget);
		}
		result.setMaximumBudgetOfChimpumpsByCurrency(budgetMap);
		budgetMap.clear();
		
		chimpumCollection = this.repository.minimumBudgetsOfChimpumpByCurrency();
		for(int i = 0; i < chimpumCollection.size(); i++) {
			budget = new Money();
			currency = (String) chimpumCollection.get(i)[0];
			amount = (Double) chimpumCollection.get(i)[1];
			budget.setAmount(amount);
			budget.setCurrency(currency);
			budgetMap.put(currency, budget);
		}
		result.setMinimumBudgetOfChimpumpsByCurrency(budgetMap);
		budgetMap.clear();
		
		return result;
	}

	@Override
	public void unbind(final Request<ChimpumDashboard> request, final ChimpumDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "chimpumRatio", "averageBudgetOfChimpumpsByCurrency", "deviationBudgetOfChimpumpsByCurrency", "minimumBudgetOfChimpumpsByCurrency", "maximumBudgetOfChimpumpsByCurrency");
	}
}
