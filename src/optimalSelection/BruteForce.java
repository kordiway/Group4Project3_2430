package optimalSelection;

import java.util.ArrayList;

/**
 * Group 4 Ian Shoell, Korbin Ordiway, Kathleen Monahan, Marcos Elgueta
 * CS2430-002 Project 3: Optimal Selection
 * 
 * Iterates through every possible SubSet to find the top 3 rated subsets
 * that fall within the required weight range
 * 
 * @author Korbin Ordiway
 */

public class BruteForce {

	final static int MAX_WEIGHT = 700;// max weight allowed for a qualifying subset
	
	/**
	 * Iterates through all subsets and checks whether the qualify to be
	 * in the top 3
	 * 
	 * @return topSubsets an ArrayList of the top subsets
	 */
	public ArrayList<SubsetResult> findOptimal() {
		Experiment[] experiments = Experiment.getExperiments();//Initializes experiments with hard code from another class
		ArrayList<SubsetResult> topSubsets = new ArrayList<>();//Initializes SubSet ArrayList to store top subsets
		
		//Iterates through all 4096 possible subsets (could be changed to work with varying data pool sizes with Math.pow(2, experiments.length)
		for(int i = 0; i < 4096; i++) {
			int totalWeight = 0; //initializes total weight of experiments for each subset
			int totalRating = 0; //initializes total rating of experiment for each subset
			ArrayList<Experiment> selectedExperiments = new ArrayList<>(); //initializes ArrayList for experiments contained in current subset
			
			//Loops through to check all experiments to check if they are in the current subset
			for(int j = 0; j < 12; j++) {
				//checks the if experiment j is included in the current subset using a bitmask
				if((i & (1 << j)) != 0){ // checks if bit j of i is on meaning experiment j is included
					selectedExperiments.add(experiments[j]);
					totalWeight += experiments[j].weight;
					totalRating += experiments[j].rating;
					
				}
			}
			
			//Checks if totalWeight of current subset is within required weight range
			if(totalWeight <= MAX_WEIGHT) {
				topSubsets.add(new SubsetResult(selectedExperiments, totalWeight, totalRating));
				//Subtracts a from b, if positive b goes up, sorting highest rating at index 0 and lowest at index 3
				topSubsets.sort((a, b) -> b.totalRating - a.totalRating); 
				
				//checks if 4th item is contained after sorting to delete smallest rating
				if(topSubsets.size() > 3) {
					topSubsets.remove(3);
				}
			}
			
		}
		return topSubsets; //returns ArrayList only containing 3 subsets with Highest ratings that meet weight requirements
	}
}
