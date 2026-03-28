package optimalSelection;

import java.util.ArrayList;

/**
 * Group 4 Ian Shoell, Korbin Ordiway, Kathleen Monahan, Marcos Elgueta
 * CS2430-002 Project 3: Optimal Selection
 * 
 * Creates the SubsetResult object to be used in other classes to hold the
 * total weight and total rating of the subset of experiments
 * 
 * @author Korbin Ordiway
 */

public class SubsetResult {

	ArrayList<Experiment> selectedExperiments; //Array list to hold the experiments in the subset
	int totalWeight; //Total weight of all experiments in subset
	int totalRating; //Total Rating of all experiments in subset
	
	public SubsetResult(ArrayList<Experiment> selectedExperiments, int totalWeight, int totalRating) {
		this.selectedExperiments = selectedExperiments;
		this.totalWeight = totalWeight;
		this.totalRating = totalRating;
	} 
	
}
