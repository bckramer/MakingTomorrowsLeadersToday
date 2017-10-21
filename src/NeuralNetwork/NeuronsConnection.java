/**
 * Represents a connection between two neurons an the associated weight.
 */
public class NeuronsConnection {

    protected Neuron fromNeuron; // From neuron for this connection (source neuron). This connection is output connection for from neuron.

    protected Neuron toNeuron;//To neuron for this connection (target, destination neuron) This connection is input connection for to neuron.

    protected double weight;// connection weight
    /**
    * Creates a new connection between specified neurons with random weight.
    *
    * @param fromNeuron
    *            neuron to connect from
    * @param toNeuron
    *            neuron to connect to
    */
    public NeuronsConnection(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = Math.random();
    }
    /**
    * Creates a new connection to specified neuron with specified weight object
    *
    * @param fromNeuron
    *            neuron to connect from
    * @param toNeuron
    *            neuron to connect to
    * @param weight
    *            weight for this connection
    */
    public NeuronsConnection(Neuron fromNeuron, Neuron toNeuron, double weight) {
        this(fromNeuron, toNeuron);
        this.weight = weight;
    }
    /**
    * Returns weight for this connection
    *
    * @return weight for this connection
    */
    public double getWeight() {
return weight;
}
    /**
    * Set the weight of the connection.
    *
    * @param weight
    *            The new weight of the connection to be set
    */
    public void setWeight(double weight) {
this.weight = weight;
}
    /**
    * Returns input of this connection - the activation function result
    * calculated in the input neuron of this connection.
    *
    * @return input received through this connection
    */
    public double getInput() {
return fromNeuron.calculateOutput();
}
    /**
    * Returns the weighted input of this connection
    *
    * @return weighted input of the connection
    */
    public double getWeightedInput() {
return fromNeuron.calculateOutput() * weight;
}
    /**
    * Gets from neuron for this connection
    *
    * @return from neuron for this connection
    */
    public Neuron getFromNeuron() {
return fromNeuron;
}
    /**
    * Gets to neuron for this connection
    *
    * @return neuron to set as to neuron
    */
    public Neuron getToNeuron() {
return toNeuron;
}

}