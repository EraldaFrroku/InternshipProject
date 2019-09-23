package er;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExchangeCl {
	// This map keep the history of budget and the strength for each individual.
	Map<SimpleEntry<Individual, Integer>, Float> strengthhistoryExch = new HashMap<>();
	
	public ExchangeCl(int agentType,
						int good1,
						int good2,    
						boolean trade,
						float strength)
					 {
	 
		this.agentType = agentType;
		this.good1 = good1;
		this.good2 = good2;
		this.trade = trade;
		this.strength=strength;
		strengthhistoryExch = new HashMap<>();
     strengthhistoryExch.put(null,strength);
	}
	
	

	



	int agentType;
	int good1;
	int good2;
	boolean trade;
	float strength;
	int lastBudget;
	
}