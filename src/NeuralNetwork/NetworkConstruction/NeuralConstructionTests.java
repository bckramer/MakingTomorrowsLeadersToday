package NetworkConstruction;

import org.junit.Test;

public class NeuralConstructionTests {

    @Test
    public void RandomNetwork() {
        for (int i = 0; i < 100; i++) {
            RandomNeuralNetwork rand = new RandomNeuralNetwork();
            System.out.println(rand);
        }
    }
}
