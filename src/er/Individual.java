package er;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.AbstractMap.SimpleEntry;

import er.AgentType;



public class Individual {

	
	// Create the class Individual Pair for creating the pairs 
	public static class IndividualPair {
		public IndividualPair(Individual one, Individual two) {
			this.one = one;
			this.two = two;
		}
	    Individual one;
	    Individual two;
	}



	// The swap method for swaping the goods  after the exchange decision.
	
	public static void swap(Individual i1, Individual i2) {
		int tmp = i1.good;
		i1.good = i2.good;
		i2.good = tmp;
	}
	
	 AgentType type;
	int  id;
	 int budget=0;
	int utility;
	int good;
	
    final int geneLength = 34;
    float[] genes = new float[geneLength];
    
   int k;
    
 int T;
	ArrayList<Integer> storageCosts;

	Map<Integer, Integer> budgetHistory;
	Random rn = new Random();
	public Individual(int id, AgentType type, int good, int budget) {
		this.id = id;

		this.type = type;
		this.good = good;
		this.budget = budget;
		budgetHistory = new HashMap<>();
		budgetHistory.put(0, budget);
		storageCosts = new ArrayList<>();
	
				  }


	

	  

	    public Individual() {
	        

	        //Set genes randomly for each individual
	        for (int i = 0; i < genes.length; i++) {
	   
	    
	    	genes[i]=rn.nextFloat();
	    	
	    	
	        }
	    	
			 		
	    	
	        calcFitness() ;
			
}
	    
	  
	       
	        
	    	public void calcFitness() {
	    		
	 
	    		T=0;
	    	
	    	for(int i=0;i<Main1.individuals.size();i++) {
	    		
	    		k=Main1.individuals.get(rn.nextInt(Main1.individuals.size())).budget;
	    		
	    	if(k> 0) {
	    	++T;
	    		
	    		}
	    	
	    	}}
	    			
	    	 
	    	
	    
	  
	

	public void consume() {
		
		budget += Main1.goodsUtility.get(good-1);
		System.out.println(this+"The first budget : "+  budget);
	    good  = (good % Main1.goods.size())+1;
        System.out.println(this+"The good: "+ good);
		budget -= Main1.goodsCostproducing.get(good-1);
     
		budget-=Main1.goodsStorageCost.get(good-1);
		
		budgetHistory.put(Main1.step, budget);

	}
	
	public void keep() {
		storageCosts.add(Main1.goodsStorageCost.get(good-1));
		budget=budget-(Main1.goodsStorageCost.get(good-1));
	}
	
	
    
	
	
	
	public String toString() {
		return "["+type.id+", "+id+", "+good+"]";
	}
	


}    		
	
    

    
	
    









	
  
  
		
	



