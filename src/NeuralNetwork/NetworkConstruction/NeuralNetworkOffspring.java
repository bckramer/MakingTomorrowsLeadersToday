package NetworkConstruction;

public class NeuralNetworkOffspring {

    private NeuralNetLayer inputLayer;

    private NeuralNetLayer hiddenLayer;

    private NeuralNetLayer outputLayer;

    NeuralNetworkOffspring(NeuralNetLayer inputLayer, NeuralNetLayer hiddenLayer, NeuralNetLayer outputLayer) {
        this.inputLayer = inputLayer;
        this.hiddenLayer = hiddenLayer;
        this.outputLayer = outputLayer;
    }

    private void changeAllBiases(NeuralNetLayer inputLayer, NeuralNetLayer hiddenLayer, NeuralNetLayer outputLayer) {
        for (Neuron neuron : inputLayer.getNeurons()) {

        }
    }

}
