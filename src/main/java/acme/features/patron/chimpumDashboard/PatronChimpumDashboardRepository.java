package acme.features.patron.chimpumDashboard;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronChimpumDashboardRepository extends AbstractRepository{
	
	@Query("select count(ch) from Chimpum ch")
	Double countChimpumps();
	
	@Query("select count(it) from Item it")
	Double countItems();
	
	@Query("select ch.budget.currency, avg(ch.budget.amount) from Chimpum ch group by ch.budget.currency")
	List<Object[]> averageBudgetsOfChimpumpByCurrency();
	
	@Query("select ch.budget.currency, stddev(ch.budget.amount) from Chimpum ch group by ch.budget.currency")
	List<Object[]> deviationBudgetsOfChimpumpByCurrency();
	
	@Query("select ch.budget.currency, max(ch.budget.amount) from Chimpum ch group by ch.budget.currency")
	List<Object[]> maximumBudgetsOfChimpumpByCurrency();
	
	@Query("select ch.budget.currency, min(ch.budget.amount) from Chimpum ch group by ch.budget.currency")
	List<Object[]> minimumBudgetsOfChimpumpByCurrency();
	
	
	
}
