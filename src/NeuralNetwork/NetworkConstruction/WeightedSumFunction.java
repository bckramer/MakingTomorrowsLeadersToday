package NetworkConstruction;

import java.util.List;

public class WeightedSumFunction {

    public double collectOutput(List<NeuronsConnection> inputConnections) {
        double weightedSum = 0d;
        for (NeuronsConnection connection : inputConnections) {
            weightedSum += connection.getWeightedInput() * connection.getFromNeuron().calculateOutput();
        }
        return weightedSum;
    }
}