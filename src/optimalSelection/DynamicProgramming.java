package optimalSelection;


import java.util.ArrayList;

/**
 * Group 4 Ian Shoell, Korbin Ordiway, Kathleen Monahan, Marcos Elgueta
 * CS2430-002 Project 3: Optimal Selection
 * 
 * 
 * Finds the optimal subset of experiments that maximizes total rating
 * without exceeding the weight capacity W.
 *
 * 
 * @author Korbin Ordiway
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

	 /**
	 * Builds up solutions to smaller subproblems by holding the best subset so far that fits within the current
	 * j weight going through each experiment, updating dp from right to left to avoid counting the same 
	 * experiment twice
	 *
	 * @param W the maximum weight capacity
	 * @param experiments array of experiments to choose from
	 * @return SubsetResult containing the optimal experiments, total weight, and total rating
	 */
	  static SubsetResult knapsack(int W, Experiment[] experiments) {
	        
	        // Initializing dp array with default values
	        SubsetResult[] dp = new SubsetResult[W + 1];
	        for(int i = 0; i <= W; i++) {
	        	dp[i] = new SubsetResult(new ArrayList<>(), 0, 0);
	        }
	        
	        //loops through each experiment
	        for (int i = 1; i <= experiments.length; i++) {
	        	//traverses backwards from W to get to current experiments weight Throughout each cycle pushes previous best result up to W
	            for (int j = W; j >= experiments[i - 1].weight; j--) {
	                //adds the experiments rating to total rating if added
	            	int newRating = dp[j - experiments[i - 1].weight].totalRating + experiments[i - 1].rating;
	            	//only adds to the result if its better than the rating at index j
	                if (newRating > dp[j].totalRating) {
	                    // Copy the previous experiment list and add the new one
	                    ArrayList<Experiment> newList = new ArrayList<>(dp[j - experiments[i - 1].weight].selectedExperiments);
	                    newList.add(experiments[i - 1]);
	                    //new best put at index j
	                    dp[j] = new SubsetResult(newList, dp[j - experiments[i - 1].weight].totalWeight + experiments[i - 1].weight, newRating);
	                }
	            }
	            
	    }
	        return dp[W];
	  }

}

