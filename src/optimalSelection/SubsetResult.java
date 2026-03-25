package optimalSelection;

import java.util.ArrayList;

public class SubsetResult {

	ArrayList<Experiment> selectedExperiments;
	int totalWeight;
	int totalRating;
	
	public SubsetResult(ArrayList<Experiment> selectedExperiments, int totalWeight, int totalRating) {
		this.selectedExperiments = selectedExperiments;
		this.totalWeight = totalWeight;
		this.totalRating = totalRating;
	} 
	
}
