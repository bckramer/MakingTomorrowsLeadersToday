package NetworkConstruction;

import java.util.List;
/**
 * Calculates the weighted sums of the input neurons' outputs.
 */
public class WeightedSumFunction {
    /**
    * {@inheritDoc}
    */
    public double collectOutput(List<NeuronsConnection> inputConnections) {
        double weightedSum = 0d;
        for (NeuronsConnection connection : inputConnections) {
            weightedSum += connection.getWeightedInput();
        }
        return weightedSum;
    }
}