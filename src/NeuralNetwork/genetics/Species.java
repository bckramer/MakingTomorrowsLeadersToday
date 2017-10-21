package genetics;

import java.util.ArrayList;

public class Species {
	private ArrayList<Species> speciesArr;
	private ArrayList<Genome> genomeArr;
	private int averageFitness;
	private int topFitness;
	

	public Species(){
		topFitness = -1;
		averageFitness = -1;
		
	}
}
