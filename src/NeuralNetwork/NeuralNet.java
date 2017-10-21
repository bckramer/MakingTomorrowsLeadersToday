import java.util.List;

public class NeuralNet {

    private String id;

    private NeuralNetLayer inputLayer;

    private NeuralNetLayer hiddenLayer;

    private NeuralNetLayer outputLayer;

    public NeuralNet(String id, NeuralNetLayer inputLayer, NeuralNetLayer hiddenLayer, NeuralNetLayer outputLayer) {
        this.id = id;
        this.inputLayer = inputLayer;
        this.hiddenLayer = hiddenLayer;
        this.outputLayer = outputLayer;
    }

    /**
     * Constructs a neural net with one hidden layer.
     * @param id
     * @param inputLayer
     * @param outputLayer
     */
    public NeuralNet(String id, NeuralNetLayer inputLayer, NeuralNetLayer outputLayer) {
        this.id = id;
        this.inputLayer = inputLayer;
        this.outputLayer = outputLayer;
    }

    /**
     * Returns one of the layers in the network
     * layer 0 = inputLayer
     * layer 1 = hiddenLayer
     * layer not(0 or 1) = outputLayer
     * @param layer
     * @return
     */
    public NeuralNetLayer getInputLayer(int layer) {
        if (layer == 0) {
            return inputLayer;
        } else if (layer == 1) {
            return hiddenLayer;
        } else {
            return outputLayer;
        }
    }
}
