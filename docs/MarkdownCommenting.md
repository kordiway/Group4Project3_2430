## Experiment 

Holds the Experiment array and all the hard coded Experiments contained within for this assignment and ability to be called in other classes to keep experiments and how they are done consistent between all classes.

## SubsetResult

Represents the results of a subset of selected experiments holding their total weight and total rating of all the experiments to be able to use in other classes to help them hold and return all values of the experiments in the set for clean results.

## BruteForce

Iterates through all 4096 possible subsets of the 12 hardcoded experiments using a bitmask approach to check which experiments are included in each subset. Tracks the top 3 highest rated subsets that fall within the maximum weight of 700 and returns them as an ArrayList of SubsetResults.

