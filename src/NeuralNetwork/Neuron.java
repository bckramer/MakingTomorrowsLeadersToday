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

    //Default neuron
    public Neuron() {
        this.inputConnections = new ArrayList<>();
        this.outputConnections = new ArrayList<>();
    }

    public Neuron(ArrayList<NeuronsConnection> inputConnections, ArrayList<NeuronsConnection> outputConnections) {
        this.inputConnections = inputConnections;
        this.outputConnections = outputConnections;
        this.output = calculateOutput();
    }

    public Double getOutput() {
        return output;
    }

    public double calculateOutput() {
        double totalInput = inputSummingFunction.collectOutput(inputConnections);

        output = activationFunction.calculateOutput(totalInput);

        return output;
    }

}
