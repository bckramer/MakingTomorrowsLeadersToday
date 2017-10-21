package NetworkConstruction;

import org.junit.Test;

public class NeuralConstructionTests {

    @Test
    public void RandomNetwork() {
        RandomNeuralNetwork randomNeuralNetwork = new RandomNeuralNetwork();
        for (Neuron neuron : randomNeuralNetwork.getOutputLayer().neurons) {
            System.out.println(neuron.calculateOutput());
        }
    }
}
