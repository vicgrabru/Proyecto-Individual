
package acme.forms;

import java.io.Serializable;
import java.util.Map;

import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChimpumDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	private static final long			serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	Double chimpumRatio;
	
	Map<String, Money> averageBudgetOfChimpumpsByCurrency;
	Map<String, Money> deviationBudgetOfChimpumpsByCurrency;
	Map<String, Money> minimumBudgetOfChimpumpsByCurrency;
	Map<String, Money> maximumBudgetOfChimpumpsByCurrency;

}
