package optimalSelection;

/**
 * Returns the maximum possible rating without exceeding the weight capacity. 
 * DP implementation adapted from GeeksforGeeks
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */

public class DynamicProgramming {
	
	/**
	 * Finds the best possible rating within the weight limit.
	 * Uses an array where dp[w] = best rating at capacity w.
	 * Goes right to left so each item is only counted once.
	 *
	 * @param W   max weight
	 * @param val ratings
	 * @param wt  weights
	 * @return best rating under capacity W
	 */
	static int knapsack(int W, int[] val, int[] wt) {

		// Initializing dp array
		int[] dp = new int[W + 1];

		// Taking first i elements
		for (int i = 1; i <= wt.length; i++) {

			// Starting from back, so that we also have data of
			// previous computation of i-1 items
			for (int j = W; j >= wt[i - 1]; j--) {
				dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
			}
		}
		return dp[W];
	}
}
