package er;

import java.util.ArrayList;

public class AgentType {
   // Take an arralist called individuals of type individual
	ArrayList<Individual> individuals;
	int id;
	
	public AgentType(int id) {
		this.id = id;
		individuals = new ArrayList<>();
	}
	// The method for setting the individuals
	public void setIndividuals(ArrayList<Individual> list) {
		individuals.addAll(list);
		
	}
	
}
