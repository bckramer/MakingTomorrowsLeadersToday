package NetworkConstruction;

import org.junit.Test;

public class NeuralConstructionTests {

    @Test
    public void RandomNetwork() {
        for (int i = 0; i < 100; i++) {
            NeuralNet rand = new NeuralNet();
            System.out.println(rand);
        }
    }
}
