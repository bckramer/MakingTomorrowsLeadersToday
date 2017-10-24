package NetworkConstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Neuron {

    //Identifier
    private String id;
    //Connections giving info to the neuron
    private List<NeuronsConnection> inputConnections;
    //Connections stemming out from the neuron
    private List<NeuronsConnection> outputConnections;
    //Allows us to sum al the input connections
    private WeightedSumFunction weightedSumFunction;
    //Allows us to get an output for the neuron
    private ActivationFunction activationFunction;
    //Calculated output for the neuron
    private double output;
    //Bias for the neuron
    private double bias;

    //Default neuron
    public Neuron() {
        this.inputConnections = new ArrayList<>();
        this.outputConnections = new ArrayList<>();
        this.weightedSumFunction = new WeightedSumFunction();
        this.activationFunction = new ActivationFunction();
        Random rand = new Random();
        this.bias = rand.nextDouble() * 2 - 1;
    }

    public Neuron(ArrayList<NeuronsConnection> inputConnections, ArrayList<NeuronsConnection> outputConnections, double bias) {
        this.inputConnections = inputConnections;
        this.outputConnections = outputConnections;
        this.activationFunction = new ActivationFunction();
        this.output = calculateOutput();
        this.bias = bias;
    }

    //Constructor for an input layer
    public Neuron(double output, double bias) {
        this.activationFunction = new ActivationFunction();
        this.output = output;
        this.bias = bias;
    }

    public double calculateOutput() {
        if (getInputConnections() == null) {
            return activationFunction.calculateOutput(output, bias);
        }
        double totalInput = weightedSumFunction.collectOutput(inputConnections);

        return activationFunction.calculateOutput(totalInput, bias);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<NeuronsConnection> getInputConnections() {
        return inputConnections;
    }

    public void setInputConnections(List<NeuronsConnection> inputConnections) {
        this.inputConnections = inputConnections;
    }

    public List<NeuronsConnection> getOutputConnections() {
        return outputConnections;
    }

    public void setOutputConnections(List<NeuronsConnection> outputConnections) {
        this.outputConnections = outputConnections;
    }

    public WeightedSumFunction getInputSummingFunction() {
        return weightedSumFunction;
    }

    public void setInputSummingFunction(WeightedSumFunction inputSummingFunction) {
        this.weightedSumFunction = inputSummingFunction;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "id='" + id + '\'' +
                "outputConnection" + outputConnections +
                ", output=" + output +
                ", bias=" + bias +
                '}';
    }
}
