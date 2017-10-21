import java.util.List;
/**
 * Calculates the weighted sums of the input neurons' outputs.
 */
public final class WeightedSumFunction implements InputSummingFunction {
/**
 * {@inheritDoc}
 */
    @Override
    public double collectOutput(List<NeuronsConnection> inputConnections) {
        double weightedSum = 0d;
        for (NeuronsConnection connection : inputConnections) {
            weightedSum += connection.getWeightedInput();
        }
        return weightedSum;
    }
}