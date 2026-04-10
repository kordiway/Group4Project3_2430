package optimalSelection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Junit tests for BruteForce
 * 
 * @author KatM
 */

public class BruteForceTest {

	@Test
	void returnsThreeResults() {
		ArrayList<SubsetResult> results = new BruteForce().findOptimal();
		assertEquals(3, results.size());
	}

	@Test
	void allResultsAreUnderWeightCapacity() {
		ArrayList<SubsetResult> results = new BruteForce().findOptimal();
		for (SubsetResult result : results) {
			assertTrue(result.totalWeight <= BruteForce.MAX_WEIGHT);
		}
	}

	@Test
	void topResultsInOrder() {
		ArrayList<SubsetResult> results = new BruteForce().findOptimal();
		for (int i = 0; i < results.size() - 1; i++) {
			assertTrue(results.get(i).totalRating >= results.get(i + 1).totalRating);
		}
	}
	
	@Test
	void resultsAreNotEmpty() {
	    ArrayList<SubsetResult> results = new BruteForce().findOptimal();
	    assertFalse(results.isEmpty(), "BruteForce should return at least one result");
	}

	@Test
	void noDuplicatesInAnyResult() {
		ArrayList<SubsetResult> results = new BruteForce().findOptimal();
		for (SubsetResult result : results) {
			ArrayList<Experiment> experiments = result.selectedExperiments;
			for (int i = 0; i < experiments.size(); i++) {
				for (int j = i + 1; j < experiments.size(); j++) {
					assertNotEquals(experiments.get(i), experiments.get(j));
				}
			}
		}
	}
}
