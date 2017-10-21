package NeuralNetwork;

import java.sql.Connection;
import java.util.List;

public class Neuron {

    //Identifier
    private String id;
    //Connections giving info to the neuron
    protected List<Connection> inputConnection;
    //Connections stemming out from the neuron
    protected List<Connection> outputConnection;
    //
    protected InputSummingFunction inputSummingFunction;
    //
    protected ActivationFunction activationFunction;


}
