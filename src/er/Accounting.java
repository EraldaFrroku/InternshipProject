package er;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Accounting {
	//Creating  arraylist exlist of type ExchangeC1 and constlist arraylist of type ConsumeC1 
	public Accounting() {
		exlist = new ArrayList<>();
		conslist = new ArrayList<>();
	
		
	}
	
	
	//This method return the boolean answer of exchange  process
	public boolean getExchangeCl(Individual i1, Individual i2) {
		ArrayList<ExchangeCl> res = new ArrayList<>();
         
		for(int i=0;i<exlist.size();i++) {
			
			exlist.get(i).strength=i1.genes[i];// We replace the strength of the rules of
			// exchange classifiers by the float values of genes[]
	     // For using the first  exchange classifier without genetic algorithm  delete these for loop 
		}
for(int i=0;i<conslist.size();i++) {
			
			conslist.get(i).strength=i1.genes[i];//We replace the strength of the rules of
			//consume classifiers by the float values of genes[]
	
		}//For using the first  consume classifier without genetic algorithm  delete these for loop 
		
		for(ExchangeCl e : exlist) {
	
		
          
			if(e.agentType == i1.type.id  && i1.good == e.good1 && i2.good == e.good2 ) {
				
				res.add(e);	
				
			}}
		
		
		
		if(res.isEmpty()) {
			return false;
		}
		
		
		ExchangeCl max=res.get(0);

		for(ExchangeCl e:res) 
			
		
			if(e.strength>max.strength)
			 {max=e;
			
			 }
			
			
		
		// if the budget is increase then increase the strength by 0.1
		if(i1.budget>max.lastBudget) {
			max.strength +=0.1;
			max.lastBudget = i1.budget;
			max.strengthhistoryExch.put(new SimpleEntry<>(i1,i1.budget), max.strength);
// The opposite is decrease the strength by 0.1
		}else if(i1.budget < max.lastBudget) {
			max.strength -= 0.1;
			max.lastBudget = i1.budget;
			max.strengthhistoryExch.put(new SimpleEntry<>(i1,i1.budget), max.strength);

		}
		
		return  max.trade;
		  
		
	}
		
	
	//This method returns the boolean answer of consumption stage . 

	public boolean getConsumeCl(Individual i1) {
		ArrayList<ConsumeCl> rescons = new ArrayList<>();

		    for(ConsumeCl e :conslist) {
		    	if(e.agentType==i1.type.id && i1.good == e.good)
		    		rescons.add(e);
				
			}		
		  
		    if(rescons.isEmpty())
		    	
		    	return false;
		    
		    
			ConsumeCl maxi = rescons.get(0);
			for(ConsumeCl e : rescons) {
				if(e.strength > maxi.strength)
					
					maxi = e;
				
			       
									
			}
			
			if(i1.budget > maxi.lastBudget) {
				maxi.strength += 0.1;
				maxi.lastBudget = i1.budget;
				maxi.mapcons.put(new SimpleEntry<>(i1,i1.budget), maxi.strength);
			}
			else if(i1.budget < maxi.lastBudget) {
				maxi.strength -= 0.1;
				maxi.lastBudget = i1.budget;
				maxi.mapcons.put(new SimpleEntry<>(i1,i1.budget), maxi.strength);
			}
			
			
			return maxi.consume;
		}
		
	
	 ArrayList<ExchangeCl>exlist;
	 ArrayList<ConsumeCl>conslist;
	
     
	    }
		
	
	

