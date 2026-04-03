package optimalSelection;

import java.util.ArrayList;
import java.util.Arrays;

// Team Name: Group 4
// Team Members: Korbin Ordiway, Ian Shoell, Kathleen Monahan, Marcos Elgueta
// Course and Section: CS 2430-002
// Project Name: Programming Project 3: Optimal selection_PLO-CS-4

// ThreeGreedy uses three different greedy strategies to select experiments
// that maximize the total rating without exceeding the max weight of 700
public class ThreeGreedy {

	// Maximum allowed total weight for selected experiments
	final int MAX_WEIGHT = 700;

	// Greedy strategy 1: prioritize experiments with the highest rating first
	public SubsetResult highestRating() {
		Experiment[] experiments = Experiment.getExperiments();
		// Sort experiments by rating in descending order
		Arrays.sort(experiments, (a, b) -> b.rating - a.rating);

		int totalWeight = 0;
		int totalRating = 0;
		ArrayList<Experiment> selectedExperiments = new ArrayList<>();

		// Add each experiment if it fits within the weight limit
		for (Experiment experiment : experiments) {
			if (totalWeight + experiment.weight <= MAX_WEIGHT) {
				selectedExperiments.add(experiment);
				totalWeight += experiment.weight;
				totalRating += experiment.rating;
			}
		}

		return new SubsetResult(selectedExperiments, totalWeight, totalRating);
	}

	// Greedy strategy 2: prioritize experiments with the lightest weight first
	public SubsetResult lightestWeight() {
		Experiment[] experiments = Experiment.getExperiments();
		// Sort experiments by weight in ascending order
		Arrays.sort(experiments, (a, b) -> a.weight - b.weight);

		int totalWeight = 0;
		int totalRating = 0;
		ArrayList<Experiment> selectedExperiments = new ArrayList<>();

		// Add each experiment if it fits within the weight limit
		for (Experiment experiment : experiments) {
			if (totalWeight + experiment.weight <= MAX_WEIGHT) {
				selectedExperiments.add(experiment);
				totalWeight += experiment.weight;
				totalRating += experiment.rating;
			}
		}

		return new SubsetResult(selectedExperiments, totalWeight, totalRating);
	}

	// Greedy strategy 3: prioritize experiments with the best rating-to-weight ratio first
	public SubsetResult weightToRatingRatio() {
		Experiment[] experiments = Experiment.getExperiments();
		// Sort experiments by rating/weight ratio in descending order
		Arrays.sort(experiments, (a, b) -> Double.compare((double) b.rating / b.weight, (double) a.rating / a.weight));

		int totalWeight = 0;
		int totalRating = 0;
		ArrayList<Experiment> selectedExperiments = new ArrayList<>();

		// Add each experiment if it fits within the weight limit
		for (Experiment experiment : experiments) {
			if (totalWeight + experiment.weight <= MAX_WEIGHT) {
				selectedExperiments.add(experiment);
				totalWeight += experiment.weight;
				totalRating += experiment.rating;
			}
		}

		return new SubsetResult(selectedExperiments, totalWeight, totalRating);
	}

}
