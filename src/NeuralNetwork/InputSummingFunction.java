import java.util.List;
import edu.neuralnet.core.Connection;
/**
 * Represents the inputs summing part of a neuron also called signal collector.
 */
public interface InputSummingFunction {
/**
 * Performs calculations based on the output values of the input neurons.
 * 
 * @param inputConnections
 *            neuron's input connections
 * @return total input for the neuron having the input connections
 */
double collectOutput(List<Connection> inputConnections);
}