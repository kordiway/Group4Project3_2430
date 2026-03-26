package optimalSelection;

/**
 * Test client for BruteForce and ThreeGreedy classes Output results and
 * summarizes with analysis to accompany final report
 * 
 * @author KatM
 */
public class TestDriver {

	public static void main(String[] args) {

		Experiment[] experiments = Experiment.getExperiments();

		System.out.println(" ============ Test Greedy Strategies ============ ");

		System.out.println("Test Highest Rating First");
		// SubsetResult result1 = ThreeGreedy.HighestRating(experiments);
		// need to either add a toString for subset or use result1.totalWeight &&
		// result1.totalRating

		System.out.println("Test Lightest First");
		// SubsetResult result2 = ThreeGreedy.Lightest(experiments);
		// need to either add a toString for subset or use result2.totalWeight &&
		// result2.totalRating

		System.out.println("Test Rating To Weight Ratio First");
		// SubsetResult result3 = ThreeGreedy.RatingToWeight(experiments);
		// need to either add a toString for subset or use result3.totalWeight &&
		// result3.totalRating

		System.out.println(" ============ Test Brute Force ============ ");

		// BruteForce(experiments);
		// will return top 3, either put into an array or print print totalWeight &&
		// totalRating per result

		System.out.println(" ============ Summary ============ ");

		// from assignment: Add output summarizing:Results of all 3 greedy strategies
		// (Part 1)
		// Result of the brute-force optimal (Part 2)
		// A brief printed summary identifying which strategies matched the optimal and
		// which did not
		// Make the output easy to read and copy into your report.

	}

}
