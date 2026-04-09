package optimalSelection;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Group 4 Ian Shoell, Korbin Ordiway, Kathleen Monahan, Marcos Elgueta
 * CS2430-002 Project 3: Optimal Selection
 * 
 * Sorts experiments array to match 3 different "greedy" approaches to the knapsack problem
 * and returns a subset that follows that approach without going over specified max weight
 * 
 * @author Marcos Elgueta + Korbin Ordiway(Edited to eliminate code duplication)
 */
public class ThreeGreedy {

	final int MAX_WEIGHT = 700;//Initialization of max weight

	/**
	 * sorts experiments based on highest rating to prepare to be ran through result method
	 * to return the results subset based on highest rating only
	 * 
	 * @return result(experiments)
	 */
	public SubsetResult highestRating() {
		Experiment[] experiments = Experiment.getExperiments();//Initializing hard coded Experiment array
		Arrays.sort(experiments, (a, b) -> b.rating - a.rating);//Sorts the Array by rating highest rating in 0 index spot
		return result(experiments);//returns the Subset Result that follows picking experiments with the highest ratings
	}

	/**
	 * sorts experiments based on lightestWeight to prepare to be ran through result method
	 * to return the results subset based on lightestWeight only
	 * 
	 * @return result(experiments)
	 */
	public SubsetResult lightestWeight() {
		Experiment[] experiments = Experiment.getExperiments();//Initializing hard coded Experiment array
		Arrays.sort(experiments, (a, b) -> a.weight - b.weight);//Sorts the array by weight having the lightest in index 0 spot
		return result(experiments);
	}

	/**
	 * sorts experiments based on rating to weight ratio to prepare to be ran through result method
	 * to return the results subset based on rating to weight ratio only
	 * 
	 * @return result(experiments)
	 */
	public SubsetResult ratingToWeightRatio() {
		Experiment[] experiments = Experiment.getExperiments();//Initializing hard coded Experiment array
		Arrays.sort(experiments, (a, b) -> {
		double ratioB = (double) b.rating/b.weight;
		double ratioA = (double) a.rating/a.weight;
		return Double.compare(ratioB, ratioA);
		});
		return result(experiments);
	}
	
	/**
	 * goes through given Experiment array and takes each item in order(why its sorted before being called) and
	 * adds it to the result SubsetResult to build out the return for it
	 * 
	 * @param experiments
	 * @return result subset 
	 */
	public SubsetResult result(Experiment[] experiments){
		SubsetResult result = new SubsetResult(new ArrayList<Experiment>(), 0, 0);
		
		for(Experiment e: experiments) {
			if(result.totalWeight + e.weight <= MAX_WEIGHT) {
				result.selectedExperiments.add(e);
				result.totalRating += e.rating;
				result.totalWeight += e.weight;
			}
				
		}
		
		return result;
		
	}

}
