package er;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

public class ConsumeCl {

	Map<SimpleEntry<Individual, Integer>, Float> mapcons = new HashMap<>();
// The class ConsumeC1 it takes an agenttype ,one good,a boolean answer and a float value.

	public ConsumeCl(int agentType, int good, boolean consume, float strength) {
		this.agentType = agentType;
		this.good = good;
		this.consume = consume;
		this.strength = strength;
		mapcons = new HashMap<>();
		mapcons.put(null, strength);
	}




		int agentType;
		int good;
		boolean consume;
		float strength;
		int lastBudget;
}

