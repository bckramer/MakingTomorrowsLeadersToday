package GeneticAlgorithm;

import java.util.ArrayList;

public class GeneticAlgorithm {
	private int iteration;
	private double mutateRate;
	private int bestPopIndex;
	private ArrayList<Population> populationArr;
	public int maxPop;
	public int numTopPop;
	private int scaleFactor = 200;
	private int bestIndex;
	private int bestFitness;


	public GeneticAlgorithm(int maxUnits,int topPerformingUnits){
		maxPop = maxUnits;
		numTopPop = topPerformingUnits;

		if(maxPop < numTopPop){
			numTopPop = maxPop;
		}

	}
	public void clearGeneticAlgorithm(){
		iteration = 1;
		mutateRate = 1;

		bestPopIndex = -1;
		bestFitness = -1;
	}

	public int getIteration() {
		return iteration;
	}
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	public double getMutateRate() {
		return mutateRate;
	}
	public void setMutateRate(double mutateRate) {
		this.mutateRate = mutateRate;
	}
	public int getBestPopIndex() {
		return bestPopIndex;
	}
	public void setBestPopIndex(int bestPopIndex) {
		this.bestPopIndex = bestPopIndex;
	}
	public ArrayList<Population> getPopulationArr() {
		return populationArr;
	}
	public void setPopulationArr(ArrayList<Population> populationArr) {
		this.populationArr = populationArr;
	}
	public int getScaleFactor() {
		return scaleFactor;
	}
	public void setScaleFactor(int scaleFactor) {
		this.scaleFactor = scaleFactor;
	}
	public int getBestIndex() {
		return bestIndex;
	}
	public void setBestIndex(int bestIndex) {
		this.bestIndex = bestIndex;
	}
	public int getBestFitness() {
		return bestFitness;
	}
	public void setBestFitness(int bestFitness) {
		this.bestFitness = bestFitness;
	}
	public int getMaxPop() {
		return maxPop;
	}
	public void setMaxPop(int maxPop) {
		this.maxPop = maxPop;
	}
	public int getNumTopPop() {
		return numTopPop;
	}
	public void setNumTopPop(int numTopPop) {
		this.numTopPop = numTopPop;
	}


}
