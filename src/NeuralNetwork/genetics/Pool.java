package genetics;

import java.util.ArrayList;

public class Pool{
	private ArrayList<Pool> poolArr;
	private ArrayList<Species> speciesArr;
	private int generation;
	private Innovation inno;
	private int currentSpeciesIndex;
	private int currentFrame;
	private int maxFitness;
	private int currentGenomeIndex;
	
	
	public Pool(){
		generation = 0;
		//inno = 
		currentSpeciesIndex = 1;
		currentFrame = 0;
		maxFitness = 0;
		currentGenomeIndex = 1;
		generation = 0;
		
	}
}
