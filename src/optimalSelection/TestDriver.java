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
		results = greedy.weightToRatingRatio();
		System.out.println(results.toString());
	

		System.out.println(" ============ Test Brute Force ============ ");

		ArrayList<SubsetResult> result = new BruteForce().findOptimal();
		int x =1; 
		for (SubsetResult s: result) {
			System.out.println("Result " + x + "\n" + s.toString());
			x++; 
			
		}

		System.out.println(" ============ Summary ============ ");

		// from assignment: Add output summarizing:Results of all 3 greedy strategies
		// (Part 1)
		// Result of the brute-force optimal (Part 2)
		// A brief printed summary identifying which strategies matched the optimal and
		// which did not
		// Make the output easy to read and copy into your report.

	}

}
