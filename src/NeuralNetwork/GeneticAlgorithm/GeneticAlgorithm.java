package GeneticAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class GeneticAlgorithm {
	private int iteration;
	public double mutateRate;
	private int bestPopIndex;
	private ArrayList<newUnit> populationArr;
	public int maxPop;
	public int numTopPop;
	private int scaleFactor = 200;
	private int bestIndex;
	public int bestFitness;
	public double gene;
	ArrayList<newUnit> winnerArr;


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
	public void createNewPopulation(){
		for(int i = 0; i < maxPop; i++){
			newUnit temp = new newUnit(2,8,2);
			temp.setIndex(i);
			add(temp);
		}
	}
	public void createNewPopulation(newUnit offspring, int amount){
		for(int i = 0; i < amount; i++){
			newUnit temp = new newUnit(offspring);
			temp.setIndex(i);
			add(temp);
		}
	}
	public void EvolvePop(ArrayList<newUnit> winners){
		ArrayList<newUnit> winnerArr = winners;
		
		if(mutateRate == 1 && winnerArr.get(0).getFitness() < 0){
			createNewPopulation();// If the best unit from the initial population has a negative fitness 
								  // no  bird reached the first barrier
		}
		else{
			setMutateRate(.2);
		}
		
		for(int i = getNumTopPop(); i < getMaxPop(); i++){
			newUnit mom; newUnit dad; newUnit offspring;
			Random rand = new Random();
			if(i == getNumTopPop()){
				 mom = winnerArr.get(0);
				 dad = winnerArr.get(1);
				 offspring = crossOver(mom,dad);
			}
			else if(i < getMaxPop() - 2){
				 mom = winnerArr.get(rand.nextInt(winnerArr.size()- 1));
				 dad = winnerArr.get(rand.nextInt(winnerArr.size()- 1));
				 offspring = crossOver(mom,dad);
			}
			else{
				 offspring = winnerArr.get(rand.nextInt());
			}
			
			//offspring = Gen.mutation(offspring); //TODO
			
			newUnit nnOffSpring =new newUnit(offspring);
			nnOffSpring.setIndex(i);
			add(nnOffSpring);
		}
		if(winnerArr.get(0).getFitness() > getBestFitness()){
		setBestPopIndex(getIteration());
		setBestFitness(winnerArr.get(0).getFitness());
		}
		//sortpop
		}
	public ArrayList<newUnit> sort(ArrayList<newUnit> preSort){
		ArrayList<newUnit> postSort = preSort;
		
		for(int i = 0; i < postSort.size() - 1; i++){
			int min = i;
			for(int x = i + 1; x < postSort.size(); x++){
				if(postSort.get(x).getFitness() < postSort.get(min).getFitness()){
					min = x;
				}
			}
			newUnit temp = postSort.get(min);
			postSort.set(min, postSort.get(i));
			postSort.set(i,temp);
			
		}
		return postSort;
	}
	
	public newUnit crossOver(newUnit mom, newUnit dad) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void selection(){ //sorts by highest fitness marks top as winners and adds winners to winnersArr
		winnerArr = sort(winnerArr);
		for(int i = 1; i < numTopPop; i++){ //marks top units as winner
		populationArr.get(i).setWinner(true);
		}
		for(int i = 0; i < numTopPop; i++){
			winnerArr.set(i,populationArr.get(i));
		}
	}
	public void mutation(newUnit offspring){
		//for()
	}
	public double geneMutation(){
		Random rand = new Random();
		if(rand.nextDouble() < mutateRate){
			double mutateFactor = 1 +((rand.nextDouble() - .5) * 3 + (rand.nextDouble() - .5));
			 gene = gene * mutateFactor;
		}
		return gene;
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
	public ArrayList<newUnit> getPopulationArr() {
		return populationArr;
	}
	public void setPopulationArr(ArrayList<newUnit> populationArr) {
		this.populationArr = populationArr;
	}
	public void add(newUnit unit){
		populationArr.add(unit);
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
