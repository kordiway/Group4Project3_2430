package optimalSelection;

/**
 * Group 4 Ian Shoell, Korbin Ordiway, Kathleen Monahan, Marcos Elgueta
 * CS2430-002 Project 3: Optimal Selection
 * 
 * Creates the Experiment object to be used in other classes
 * as well as being able to initialize a hard coded set of experiments
 * with their weight and ratings
 * 
 * @author Korbin Ordiway
 */

public class Experiment {

	


	String name; // name of the experiment
	int weight; // weight of the experiment
	int rating; // rating of the experiment
	
	public Experiment(String name, int weight, int rating) {
		this.name = name;
		this.weight = weight;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
	    return name + " (" + weight + " kg, rating " + rating + ")";
	}
	
	/**
	 * Stores hard coded experiment information to be called for other classes
	 * 
	 * @return hard coded array of Experiments
	 */
	public static Experiment[] getExperiments() {
		return new Experiment[] {
				new Experiment ("Cloud Patterns", 36, 5),
				new Experiment ("Solar Flares", 264, 9),
				new Experiment ("Solar Power", 188, 6),
				new Experiment ("Binary Stars", 203, 8),
				new Experiment ("Relativity", 104, 8),
				new Experiment ("Seed Viability", 7, 4),
				new Experiment ("Sun Spots", 90, 2),
				new Experiment ("Mice Tumors", 65, 8),
				new Experiment ("Microgravity Plant Growth", 75, 5),
				new Experiment ("Micrometeorites", 170, 9),
				new Experiment ("Cosmic Rays", 80, 7),
				new Experiment ("Yeast Fermentation", 27, 4)
		};
	}
	
}
