package NetworkConstruction;

import java.util.ArrayList;
import java.util.List;

public class Neuron {

    //Identifier
    private String id;
    //Connections giving info to the neuron
    private List<NeuronsConnection> inputConnections;
    //Connections stemming out from the neuron
    private List<NeuronsConnection> outputConnections;
    //Allows us to sum al the input connections
    private WeightedSumFunction inputSummingFunction;
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
    }

    public Neuron(ArrayList<NeuronsConnection> inputConnections, ArrayList<NeuronsConnection> outputConnections, double bias) {
        this.inputConnections = inputConnections;
        this.outputConnections = outputConnections;
        this.output = calculateOutput();
        this.bias = bias;
    }

    //Constructor for an input layer
    public Neuron(double output, double bias) {
        this.output = output;
        this.bias = bias;
    }

    public Double getOutput() {
        return output;
    }

    public double calculateOutput() {
        double totalInput = inputSummingFunction.collectOutput(inputConnections);

        output = activationFunction.calculateOutput(totalInput, bias);

        return output;
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
        return inputSummingFunction;
    }

    public void setInputSummingFunction(WeightedSumFunction inputSummingFunction) {
        this.inputSummingFunction = inputSummingFunction;
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
}
