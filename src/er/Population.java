package er;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

import er.Individual.IndividualPair;



public class Population {
	   
		ArrayList<Individual> individuals = new ArrayList<Individual>(Main1.individuals);

	   final int individualnumber=150;
	  int step=0;
	   ArrayList<Individual>  tmp=new ArrayList<> () ; 
	   Random rand=new Random();
	   int T=0;
	    //Initialize population
	   
	        		 public void initializePopulation(int f) {


	        			        for (int i = 0; i < f; i++) {
	        			            
	        			        	individuals.add(new Individual());
	        			        }
	        			       }
	        		
	    
	    //Get the fittest individual
	    public Individual getFittest() {
	    	
	    // We sort the fittest individual in Ascending order .
	    	
    	individuals.stream().sorted((a, b)-> (a.k> b.k)?0:(a.k == b.k)?0:-1).collect(Collectors.toList());
	        return  individuals.get(1);
	    }
	    
	  //Get the second most fittest individual
	    public Individual getSecondFittest() {
	        getFittest();
	        return individuals.get(2);
	    }   
	    
	    
	  //Get index of least fittest individual
	    public int getLeastFittestIndex() {
	        getFittest();
	        return individuals.size();
	    }

	    
	  //Calculate fitness of each individual
	    public void calculateFitness() {
	    	// Call the trade again for calculating the budget for each individual.
	    	
			for(; Main1.step < 2 ; ++Main1.step){

				ArrayList<IndividualPair> pairs = new ArrayList<>();
				tmp = new ArrayList<>(Main1.individuals);
				for(int i = 0; i < individualnumber/2; ++i) {

					pairs.add(new IndividualPair(tmp.remove(rand.nextInt(tmp.size())), tmp.remove(rand.nextInt(tmp.size()))));
					
					
					}}
			++T;
				
	        for (Individual i : individuals)
	        {
	        	
	        	i.calcFitness();
	        	
	        }
	        	
	        
	        getFittest();
	    }
	    }
	    
	    
  

	




