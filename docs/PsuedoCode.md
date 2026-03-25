// Team Name: Group 4  
// Team Members: Korbin Ordiway, Ian Shoell, Kathleen Monahan, Marcos Elgueta  
// Course and Section: CS 2430-002  
// Project Name: Programming Project 3: Optimal selection\_PLO-CS-4

// Each class will be in the optimalSelection package

CLASS Experiment  
    DECLARE name as String  
    DECLARE weight as int  
    DECLARE rating as int

    
    CONSTRUCTOR METHOD Experiment(name, weight, rating)  
     	SET this.name \= name  
     	SET this.weight \= weight  
     	SET this.rating \= rating  
    END METHOD

    METHOD getExperiments()  
        DECLARE experiments as Array of Experiment with size 12  
        	new Experiment("Cloud Patterns", 36, 5\)  
            new Experiment("Solar Flares", 264, 9\)  
            new Experiment("Solar Power", 188, 6\)  
            new Experiment("Binary Stars", 203, 8\)  
            new Experiment("Relativity", 104, 8\)  
            new Experiment("Seed Viability", 7, 4\)  
            new Experiment("Sun Spots", 90, 2\)  
            new Experiment("Mice Tumors", 65, 8\)  
            new Experiment("Microgravity Plant Growth", 75, 5\)  
            new Experiment("Micrometeorites", 170, 9\)  
            new Experiment("Cosmic Rays", 80, 7\)  
            new Experiment("Yeast Fermentation", 27, 4\)  
        RETURN experiments  
    END METHOD

END CLASS

CLASS SubsetResult  
	DECLARE selectedExperiments as an empty ArrayList of Experiment  
	DECLARE totalWeight as int  
	DECLARE totalRating as int

CONSTRUCTOR METHOD SubsetResult(selectedExperiments, totalWeight, totalRating)  
       		SET this.selectedExperiments \= selectedExperiments  
       		SET this.totalWeight \= totalWeight  
        		SET this.totalRating \= totalRating  
    	END METHOD  
END CLASS

	  
CLASS BruteForce

	DECLARE final MAX\_WEIGHT as int \= 700  
	  
	METHOD findOptimal  RETURN SubsetResult  
		DECLARE experiments as array of Experiment \= Experiment.getExperiments();  
		DECLARE topSubsets as an empty ArrayList of SubsetResult

		FOR subset 0 to 4095  
			DECLARE totalWeight as int \= 0  
			DECLARE totalRating as int \= 0  
			DECLARE selectedExperiments as empty ArrayList of Experiment

			FOR i \= 0 to 11  
				IF experiments\[i\] is in current subset  
					ADD experiments\[i\] to selectedExperiments  
					ADD experiments\[i\].weight to totalWeight  
					ADD experiments\[i\].rating to totalRating

		  
			IF totalWeight \<= MAX\_WEIGHT  
				IF topSubsets.size \< 3  
					CREATE newResult as SubsetResult									SET newResult.selectedExperiments \= selectedExperiments  
SET newResult.totalWeight \= totalWeight   
SET newResult.totalRating \= totalRating   
ADD newResult to topSubsets

ELSE IF totalRating \> topSubsets\[2\].totalRating  
SORT topSubsets by totalRating descending (lowest at index 2\)  
REMOVE topSubsets\[2\]  
CREATE newResult as SubsetResult  
					SET newResult.selectedExperiments \= selectedExperiments   
SET newResult.totalWeight \= totalWeight   
SET newResult.totalRating \= totalRating   
ADD newResult to topSubsets  
			  
		RETURN topSubsets  
	END METHOD  
END CLASS

CLASS ThreeGreedy  
	  
	DECLARE final MAX\_WEIGHT as int \= 700

	METHOD highestRating RETURN SubsetResult  
		DECLARE experiments as array of Experiment \= Experiment.getExperiments()  
		SORT experiments by rating descending  
		DECLARE totalWeight as int \= 0  
		DECLARE totalRating as int \= 0  
		DECLARE selectedExperiments as empty ArrayList of Experiment  
		CREATE newResult as SubsetResult  
		  
FOR each experiment in experiments  
			IF totalWeight \+ experiment.weight \<= MAX\_WEIGHT  
				ADD experiment to selectedExperiments   
ADD experiment.weight to totalWeight   
ADD experiment.rating to totalRating							

SET newResult.selectedExperiments \= selectedExperiments  
SET newResult.totalWeight \= totalWeight   
SET newResult.totalRating \= totalRating   
RETURN newResult	  
			  
	END METHOD  
	  
	METHOD lightestWeight RETURN SubsetResult  
	DECLARE experiments as array of Experiment \= Experiment.getExperiments()  
		SORT experiments by weight ascending  
		DECLARE totalWeight as int \= 0  
		DECLARE totalRating as int \= 0  
		DECLARE selectedExperiments as empty ArrayList of Experiment  
		CREATE newResult as SubsetResult  
		  
FOR each experiment in experiments  
			IF totalWeight \+ experiment.weight \<= MAX\_WEIGHT  
				ADD experiment to selectedExperiments   
ADD experiment.weight to totalWeight   
ADD experiment.rating to totalRating							

SET newResult.selectedExperiments \= selectedExperiments  
SET newResult.totalWeight \= totalWeight   
SET newResult.totalRating \= totalRating   
RETURN newResult	  
			  
	END METHOD

	METHOD weightToRatingRatio RETURN SubsetResult  
		DECLARE experiments as array of Experiment \= Experiment.getExperiments()  
		SORT experiments by rating/weight descending  
		DECLARE totalWeight as int \= 0  
		DECLARE totalRating as int \= 0  
		DECLARE selectedExperiments as empty ArrayList of Experiment  
		CREATE newResult as SubsetResult  
		  
FOR each experiment in experiments  
			IF totalWeight \+ experiment.weight \<= MAX\_WEIGHT  
				ADD experiment to selectedExperiments   
ADD experiment.weight to totalWeight   
ADD experiment.rating to totalRating							

SET newResult.selectedExperiments \= selectedExperiments  
SET newResult.totalWeight \= totalWeight   
SET newResult.totalRating \= totalRating   
RETURN newResult	

	END METHOD  
END CLASS