# Test Plan for Programming Project 3
Verification Lead: Kathleen Monahan

## What we're testing
We're using JUnit tests to test BruteForce and the three greedy strategies.

## BruteForce
We want to make sure all 3 results come back under 700kg, that they're in order best first, and that there are no duplicate experiments in any result.

## ThreeGreedy
Once the methods are built out we'll check that each strategy stays under 700kg and that each one is actually selected by the right criteria i.e. rating first, lightest first, and ratio first respectively.

## Verifying correctness
The greedy strategies get checked against the weight limit and their own selection logic. The brute force result is what we'll use in the report to show how the greedy strategies compare to optimal but that's more of a discussion point than a test. I can use the results to sanity check on 3 greedy strategies. 

## Status
BruteForce test stubs are written. May add more as I think of them. ThreeGreedy tests are planned for next week once there's something to test against.

