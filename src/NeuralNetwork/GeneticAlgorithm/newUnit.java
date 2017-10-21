package GeneticAlgorithm;

import java.util.ArrayList;
import java.util.Random;

import geom.Rectangle;

public class newUnit {
	private int index;
	private int fitness;
	private boolean isWinner = false;
	private ArrayList<newUnit> populationArr;
	public double mutateRate = .2;
	//private int bestPopIndex; use function
	//public int maxPop = 10;
	//public int numTopPop = 4;
	//private int scaleFactor = 200;
	//public int bestFitness; //usefunction
	
	public newUnit(int input,int hidden,int outer){
		//randomNeuralNetwork(input,hidden,outer);
		fitness = 0;
		isWinner = false;
	}
	public newUnit(Rectangle offspring){
		//NeuralNetwork(offspring);
		fitness = 0;
		isWinner = false;
	}
	
	public newUnit crossOver(newUnit mom, newUnit dad) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getFitness() {
		return fitness;
	}
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	public boolean isWinner() {
		return isWinner;
	}
	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}
	public ArrayList<newUnit> getPopulationArr() {
		return populationArr;
	}
	public void setPopulationArr(ArrayList<newUnit> populationArr) {
		this.populationArr = populationArr;
	}
	public double getMutateRate() {
		return mutateRate;
	}
	public void setMutateRate(double mutateRate) {
		this.mutateRate = mutateRate;
	}
	
	
}
