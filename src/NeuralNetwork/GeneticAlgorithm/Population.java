package GeneticAlgorithm;

public class Population {

	public Population(){
		GeneticAlgorithm Gen = new GeneticAlgorithm(10, 4);
		Gen.clearGeneticAlgorithm();
		for(int i = 0; i < Gen.getMaxPop(); i++){
			newUnit temp = new newUnit(2,8,2);
			temp.setIndex(i);
			Gen.add(temp);
		}
	}
}
