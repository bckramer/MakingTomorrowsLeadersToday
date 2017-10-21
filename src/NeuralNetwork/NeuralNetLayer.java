import java.util.ArrayList;
import java.util.List;
/**
 * Neural networks can be composed of several linked layers, forming the
 * so-called multilayer networks. A layer can be defined as a set of neurons
 * comprising a single neural net's layer.
 */
public class NeuralNetLayer {
    /**
     * Layer's identifier
     */
    private String id;
    /**
     * Collection of neurons in this layer
     */
    protected List<Neuron> neurons;

    /**
     * Creates an empty layer with an id.
     *
     * @param id layer's identifier
     */
    public NeuralNetLayer(String id) {
        this.id = id;
        neurons = new ArrayList<>();
    }

    /**
    * Creates a layer with a list of neurons and an id.
    *
    * @param id
    *            layer's identifier
    * @param neurons
    *            list of neurons to be added to the layer
    */
    public NeuralNetLayer(String id, List<Neuron> neurons) {
        this.id = id;
        this.neurons = neurons;
    }
}
