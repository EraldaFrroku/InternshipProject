package er;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import er.Individual.IndividualPair;

 

public class Main1 {
	static ArrayList<Integer> goodsStorageCost = new ArrayList<>();
    static ArrayList<Integer> goods = new ArrayList<>();
   static  Accounting acc=new Accounting();
   static   ArrayList<Individual>individuals = new ArrayList<>();
	static ArrayList<Integer> goodsCostproducing = new ArrayList<>();
	static ArrayList<Integer> goodsUtility = new ArrayList<>();
	   static   ArrayList<Individual>ge = new ArrayList<>();

    static int step=0;
    static Population population = new Population();
   static  Individual d;
    static int generationCount = 0;
   

    public static void main(String[] args) {
		// set the number of trades and the nr of individuals in this process
    	final int nbTrades=2;
		final int individualnumber=150;
        Random rand = new Random();
        int indId = 0;

    		//arraylist  good keep the good 1,2,3
        // The goodsStorageCost arraylist  keep the cost of storing the good
        //  The goodCostproducing  arraylist  keep the cost of producing  the good
        // The goodUtility arraylist  keep the utility value after consuming the good.
      
        goods.add(1); goodsStorageCost.add(10); goodsCostproducing.add(300); goodsUtility.add(15);
        goods.add(2); goodsStorageCost.add(20); goodsCostproducing.add(200); goodsUtility.add(25);
        goods.add(3); goodsStorageCost.add(30); goodsCostproducing.add(100); goodsUtility.add(35);

   ArrayList<Individual>  tmp=new ArrayList<> () ;    
        ArrayList<Integer> goodstmp = new ArrayList<>(goods);// goodstmp take the array of goods
        goodstmp.remove(0);//remove its goods type
        AgentType agent1 = new AgentType(1);//agent of type 1
        for(int i = 0; i < 50; ++i) {//set the segment of 50 individual and good for the agent1
        	tmp.add(new Individual(indId++, agent1, goodstmp.get(rand.nextInt(goodstmp.size())), 100));
        
        }
        agent1.setIndividuals(tmp);
        
        tmp.clear();
        
        goodstmp = new ArrayList<>(goods);
        goodstmp.remove(1);
        AgentType agent2 = new AgentType(2);
        for(int i = 0; i < 50; ++i) {

        	tmp.add(new Individual(indId++, agent2, goodstmp.get(rand.nextInt(goodstmp.size())), 100));
        }
        agent2.setIndividuals(tmp);
       tmp.clear();
        
       goodstmp = new ArrayList<>(goods);
       goodstmp.remove(2);
        AgentType agent3 = new AgentType(3);
        for(int i = 0; i < 50; ++i) {
        	tmp.add(new Individual(indId++, agent3, goodstmp.get(rand.nextInt(goodstmp.size())), 100));
        }
        agent3.setIndividuals(tmp);
        tmp.clear();
       // we have all the segments of Agents with their individuals 
        individuals.addAll(agent1.individuals);
        individuals.addAll(agent2.individuals);
        individuals.addAll(agent3.individuals);
    
       
  	    

   // call the rules of the classifiers 
       
        
	    acc.exlist.add(new ExchangeCl(agent1.id,goods.get(1),goods.get(2),true,0.88f));
	    acc.exlist.add(new ExchangeCl(agent1.id,goods.get(1),goods.get(2),false,0.44f));
	    acc.exlist.add(new ExchangeCl(agent1.id,goods.get(2),goods.get(1),false,0.45f));
		acc.exlist.add(new ExchangeCl(agent1.id,goods.get(2),goods.get(1),true,0.33f));
	    acc.exlist.add(new ExchangeCl(agent1.id,goods.get(1),goods.get(1),false,0.29f));
		acc.exlist.add(new ExchangeCl(agent1.id,goods.get(2),goods.get(0),true,0.77f));
		acc.exlist.add(new ExchangeCl(agent1.id,goods.get(2),goods.get(2),false,0.15f));
		acc.exlist.add(new ExchangeCl(agent1.id,goods.get(1),goods.get(0),true,0.15f));

		
	    acc.exlist.add(new ExchangeCl(agent2.id,goods.get(0),goods.get(2),false,0.48f));
	    acc.exlist.add(new ExchangeCl(agent2.id,goods.get(0),goods.get(2),true,0.18f));
	    acc.exlist.add(new ExchangeCl(agent2.id,goods.get(2),goods.get(0),false,0.98f));
	    acc.exlist.add(new ExchangeCl(agent2.id,goods.get(2),goods.get(0),true,0.78f));
	    acc.exlist.add(new ExchangeCl(agent2.id,goods.get(0),goods.get(0),false,0.28f));
		acc.exlist.add(new ExchangeCl(agent2.id,goods.get(2),goods.get(1),true,0.94f));
		acc.exlist.add(new ExchangeCl(agent2.id,goods.get(2),goods.get(2),false,0.24f));
		acc.exlist.add(new ExchangeCl(agent2.id,goods.get(0),goods.get(1),true,0.14f));
  
		
		
		acc.exlist.add(new ExchangeCl(agent3.id,goods.get(0),goods.get(1),false,0.84f));
		acc.exlist.add(new ExchangeCl(agent3.id,goods.get(0),goods.get(1),true,0.64f));
		acc.exlist.add(new ExchangeCl(agent3.id,goods.get(1),goods.get(0),false,0.24f));
		acc.exlist.add(new ExchangeCl(agent3.id,goods.get(1),goods.get(0),true,0.14f));
		acc.exlist.add(new ExchangeCl(agent3.id,goods.get(1),goods.get(1),false,0.74f));
		acc.exlist.add(new ExchangeCl(agent3.id,goods.get(1),goods.get(2),true,0.74f));
		acc.exlist.add(new ExchangeCl(agent3.id,goods.get(0),goods.get(2),true,0.34f));
		acc.exlist.add(new ExchangeCl(agent3.id,goods.get(0),goods.get(0),false,0.74f));
        
    
		
		acc.conslist.add(new ConsumeCl(agent1.id, goods.get(0), true, 0.55f));
		acc.conslist.add(new ConsumeCl(agent1.id, goods.get(1), false, 0.15f));
		acc.conslist.add(new ConsumeCl(agent1.id, goods.get(2), false, 0.25f));
		acc.conslist.add(new ConsumeCl(agent2.id, goods.get(2), false , 0.4f));
		acc.conslist.add(new ConsumeCl(agent2.id, goods.get(1), true, 0.14f));
		acc.conslist.add(new ConsumeCl(agent2.id, goods.get(0), false, 0.14f));

		acc.conslist.add(new ConsumeCl(agent3.id, goods.get(2), true, 0.045f));
		acc.conslist.add(new ConsumeCl(agent3.id, goods.get(1), false, 0.05f));
		acc.conslist.add(new ConsumeCl(agent3.id, goods.get(0), false, 0.65f));

		
		 

		
   
		int sum1=0;
		int sum2=0;
		int sum3=0;
    // For the numbers of the trades start creating the 75 pairs 
		for(; step < nbTrades ; ++step){

			ArrayList<IndividualPair> pairs = new ArrayList<>();
			tmp = new ArrayList<>(individuals);
			System.out.println("This is the number of Individuals : "+ tmp.size());
			System.out.println("These  are the pairs :");

			for(int i = 0; i < individualnumber/2; ++i) {

				pairs.add(new IndividualPair(tmp.remove(rand.nextInt(tmp.size())), tmp.remove(rand.nextInt(tmp.size()))));
        
			}
			
			
			
			// display the pairs 
			
			for(IndividualPair p : pairs) {	

				System.out.println("("+p.one+", "+p.two+")");
			
			}
			// Calling the classifer to have the answer for exchange  decision 	 
			for(IndividualPair p : pairs) {

				boolean tansw1 = acc.getExchangeCl(p.one, p.two);
				boolean tansw2 = acc.getExchangeCl(p.two, p.one);
				
				
				if(tansw1 && tansw2) {
                  
                  
           
               System.out.println("INIT PAIR THAT TRADE (["+p.one+"], ["+p.two+"]");
				
               	System.out.println( "The answer is :"+"("+ tansw1 +";" + tansw2 +")");

				
                if(p.one.type.id == 1 && p.two.good!=1){// if agent of type 1 is the owner and the partner does not contain good 1.
               	  sum1++;
         				System.out.println("COUNT1(["+p.one+"], ["+p.two+"]");}//we count the true trade decison
                
         				
                 
                
                else {
                	
               	  System.out.println("NO COUNT(["+p.one+"], ["+p.two+"]");
               	
                
                 }
            	
                System.out.println("The number of COUNT1  :"+sum1); 
              

				    Individual.swap(p.one, p.two);// swap the goods 
					System.out.println("SWAPED (["+p.one+"], ["+p.two+"]");
					
					if(acc.getConsumeCl(p.one)) {// if the owner return true for consumption decision.
						p.one.consume();//we call the method 
						System.out.println("CONSUME1 (["+p.one+"])");
						
					}
					else {
						p.one.keep();// we call the method of keeping the good
						System.out.println("KEEP1 (["+p.one+"])");
						System.out.println("The cost of storage of  this good is :" + p.one.storageCosts);

					}

					if(acc.getConsumeCl(p.two)) {//if the owner return true for consumption decision.
						p.two.consume();//We call the method 
						System.out.println("CONSUME2 (["+p.two+"])");

					} else {
						p.two.keep();//we call the method of keeping the good
						System.out.println("KEEP2 (["+p.two+"])");
						System.out.println("The cost of storage of  this good is :" + p.two.storageCosts);

					}

				}
				else {
					System.out.println("NO TRADE(["+p.one+"], ["+p.two+"]");
					
				}

			}
				
			
		}
		
		for(Individual i : individuals) {
			System.out.println("Budget history of Individuals ["+i.type.id+","+i.id+","+i.good+"] :"+i.budgetHistory );
			
		}
		for(ExchangeCl i : acc.exlist) {
			System.out.println("Strength history ["+"The good :"+ i.good1+","+"The agent type:"+ i.agentType+","+"] :"+"The map history:"+ i.strengthhistoryExch +"the boolean answer:"+ i.trade );
			
		}
		for(ConsumeCl i : acc.conslist) {
			System.out.println("Strength history for consume ["+"The good :"+ i.good+","+"The agent type:"+ i.agentType+","+"] :"+"The map history:"+ i.mapcons +"the boolean answer:"+ i.consume );
			
		}
		 
	       
	       
	        
	    
	    
		
		Random rn = new Random();


        //Initialize population
        population.initializePopulation(150);

        
        //Calculate fitness of each individual
        population.calculateFitness();

        System.out.println("Generation: " + generationCount + " Fittest budget: " + population.getFittest().k + "  The individual "+ population.getFittest().T+ " Time: " + population.T);

        //While number of generation is less then 10
        while (generationCount<10) {
            ++generationCount;

            //Do crossover
            crossover();

            //Do mutation under a random probability
            if (rn.nextInt()%7 < 5) {
                mutation();
            }


            //Calculate new fitness value
            population.calculateFitness();

            System.out.println("Generation: " + generationCount + " Fittest budget : " + population.getFittest().k  + " The individual "+ population.getFittest().T +  " Time: " + population.T);
        }

      System.out.println("\nSolution found in generation " + generationCount);
        System.out.println("Fitness: "+ population.getFittest().k);
       System.out.println("Time: "+ population.T);
        System.out.print("Strengths: ");
        for (int i = 0; i < 5; i++) {
            System.out.print( " gene : "+ population.getFittest().genes[i]);
        }

        System.out.println("");

    }

    //Crossover
    static void crossover() {
        Random rn = new Random();

        //Select a random crossover point
        int crossOverPoint = rn.nextInt(population.getFittest().geneLength);

       
        
        System.out.println("Cross Over Point "+crossOverPoint);
        
        //Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            
        	float temp = population.getFittest().genes[i];
        	population.getFittest().genes[i] = population.getSecondFittest().genes[i];
        	population.getSecondFittest().genes[i] = temp;
        }
       
    }

    //Mutation
    static void mutation() {
        Random rn = new Random();

        //Select a random mutation point
        int mutationPoint = rn.nextInt(population.getFittest().geneLength);

        Individual fittest = population.getFittest();
        Individual secondFittest = population.getSecondFittest();
        
        //Flip values at the mutation point
        for (int i = 0; i < mutationPoint; i++) {
        	fittest.genes[mutationPoint] = rn.nextFloat();
        	secondFittest.genes[mutationPoint] = rn.nextFloat();
        }
    }
}
