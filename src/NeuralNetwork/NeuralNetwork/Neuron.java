package NeuralNetwork;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Neuron {

    //Identifier
    private String id;
    //Connections giving info to the neuron
    protected List<Connection> inputConnections;
    //Connections stemming out from the neuron
    protected List<Connection> outputConnections;
    //
    protected InputSummingFunction inputSummingFunction;
    //
    protected ActivationFunction activationFunction;

    public Neuron() {
        this.inputConnections = new ArrayList<>();
        this.outputConnections = new ArrayList<>();
    }

    public double calculateOutput() {
        double totalInput = inputSummingFunction.getOutput(inputConnections);

        return activationFunction.getOutput(totalInput);
    }
}
