import java.util.ArrayList;
import java.util.List;

public class NeuralNetLayer {

    private String id;

    protected List<Neuron> neurons;

    public NeuralNetLayer(String id) {
        this.id = id;
        neurons = new ArrayList<>();
    }

    public NeuralNetLayer(String id, List<Neuron> neurons) {
        this.id = id;
        this.neurons = neurons;
    }

    /**
     * Retrieves a neuron in the layer by position
     * @param neuronPos
     * @return
     */
    public Neuron getNeuron(int neuronPos) {
        if (neuronPos > neurons.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return neurons.get(neuronPos);
    }
}
