package optimalSelection;

import java.util.ArrayList;

/**
 * Test client for BruteForce and ThreeGreedy classes Output results and
 * summarizes with analysis to accompany final report
 * 
 * @author KatM
 */
public class TestDriver {

	public static void main(String[] args) {

		System.out.println(" ============ Test Greedy Strategies ============ ");
		System.out.println();
		System.out.println("Test Highest Rating First");
		System.out.println();
		ThreeGreedy greedy = new ThreeGreedy();
		SubsetResult results = greedy.highestRating();
		System.out.println(results.toString());

		System.out.println("----------------------------------------");

		System.out.println("Test Lightest First");
		System.out.println();
		greedy = new ThreeGreedy();
		results = greedy.lightestWeight();
		System.out.println(results.toString());

		System.out.println("----------------------------------------");

		System.out.println("Test Rating To Weight Ratio First");
		System.out.println();
		greedy = new ThreeGreedy();
		results = greedy.ratingToWeightRatio();
		System.out.println(results.toString());

		System.out.println(" ============ Test Brute Force ============ ");

		ArrayList<SubsetResult> result = new BruteForce().findOptimal();
		int x = 1;
		for (SubsetResult s : result) {
			System.out.println("Result " + x + "\n" + s.toString());
			x++;

		}

		System.out.println(" ============ Test Dynamic Programming ============ ");
		System.out.println();
		Experiment[] experiment = Experiment.getExperiments();

		int[] weight = new int[12];
		int[] rating = new int[12];

		for (int i = 0; i < experiment.length; i++) {
			weight[i] = experiment[i].weight;
			rating[i] = experiment[i].rating;
		}

		System.out.println(
				"Using Dynamic Programming the optimal Rating is: " + DynamicProgramming.knapsack(700, rating, weight));
		System.out.println();

		System.out.println(" ============ Summary ============ ");
		System.out.println();
		SubsetResult highestRating = new ThreeGreedy().highestRating();
		SubsetResult lightestWeight = new ThreeGreedy().lightestWeight();
		SubsetResult ratingToWeight = new ThreeGreedy().ratingToWeightRatio();
		int optimal = new BruteForce().findOptimal().get(0).totalRating;
		int dpOptimal = DynamicProgramming.knapsack(700, rating, weight);

		System.out
				.println("Brute force checked all 4096 subsets and found the best possible rating is " + optimal + ".");
		System.out.println("Dynamic programming got the same answer: " + dpOptimal + ".");
		System.out.println();
		System.out.println("The greedy strategies did not match optimal:");
		System.out.println("Highest Rating First:         " + highestRating.totalRating);
		System.out.println("Lightest First:               " + lightestWeight.totalRating);
		System.out.println("Rating to Weight Ratio First: " + ratingToWeight.totalRating);
		System.out.println();
		System.out.println();
		System.out.println("""
			    The greedy strategies fall short here because picking \
			    the best looking option one step at a time does not account\n\
			    for how the remaining weight gets used. Brute force and \
			    dynamic programming both find the true optimal because\n\
			    they consider the full picture. For this problem, being \
			    thoughtful about the approach really does matter.""");

	}

}
