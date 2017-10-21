package NetworkConstruction;

public class ActivationFunction {


    public ActivationFunction() {

    }

    public double calculateOutput(double summedInput, double bias) {
        Double sigmoid = 1/(1 + Math.exp(-(summedInput - bias)));
        return sigmoid;
    }
}