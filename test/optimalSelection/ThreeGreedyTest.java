package optimalSelection;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Junit tests for ThreeGreedy
 * 
 * @author KatM
 */

public class ThreeGreedyTest {

	@Test
	void testHighestRatingDoesNotExceedMaxWeight() {
		ThreeGreedy greedy = new ThreeGreedy();
		SubsetResult results = greedy.highestRating();
		assertTrue(results.totalWeight <= 700, "Total weight should not exceed 700");
	}

	@Test
	void testLightestWeightDoesNotExceedMaxWeight() {
		ThreeGreedy greedy = new ThreeGreedy();
		SubsetResult results = greedy.lightestWeight();
		assertTrue(results.totalWeight <= 700, "Total weight should not exceed 700");
	}

	@Test
	void testweightToRatingRatioDoesNotExceedMaxWeight() {
		ThreeGreedy greedy = new ThreeGreedy();
		SubsetResult results = greedy.weightToRatingRatio();
		assertTrue(results.totalWeight <= 700, "Total weight should not exceed 700");
	}

	@Test
	void testHighestRatingReturnsSomething() {
		ThreeGreedy greedy = new ThreeGreedy();
		SubsetResult result = greedy.highestRating();
		assertTrue(result.selectedExperiments.size() > 0, "Should select at least one experiment");
	}

	@Test
	void testLightestWeightReturnsSomething() {
		ThreeGreedy greedy = new ThreeGreedy();
		SubsetResult result = greedy.lightestWeight();
		assertTrue(result.selectedExperiments.size() > 0, "Should select at least one experiment");
	}

	@Test
	void testWeightToRatingRatioReturnsSomething() {
		ThreeGreedy greedy = new ThreeGreedy();
		SubsetResult result = greedy.weightToRatingRatio();
		assertTrue(result.selectedExperiments.size() > 0, "Should select at least one experiment");
	}

	@Test
	void bruteForceBeatsOrMatchesAllGreedyStrategies() {
		int optimalRating = new BruteForce().findOptimal().get(0).totalRating;
		assertTrue(optimalRating >= new ThreeGreedy().highestRating().totalRating);
		assertTrue(optimalRating >= new ThreeGreedy().lightestWeight().totalRating);
		assertTrue(optimalRating >= new ThreeGreedy().weightToRatingRatio().totalRating);
	}
}
