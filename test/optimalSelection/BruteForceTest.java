package optimalSelection;

import org.junit.jupiter.api.Test;

/**
 * Junit tests for BruteForce 
 * @author KatM
 */

public class BruteForceTest {

	@Test
	void allResultsAreUnderWeightCapacity() {}
	//check that the top 3 results are all equal or less than 700kgs

	@Test
	void topResultsInOrder() {}
	// check that result[0].totalRating >= result[1].totalRating >= result[2].totalRating
	//assuming we are putting the results in an array perhaps of type subsetresult

	@Test
	void noDuplicatesInAnyResult() {}
	//duplicates may indicate a bug of some sort
}
