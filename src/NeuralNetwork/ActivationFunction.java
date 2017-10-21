public class ActivationFunction {


    public ActivationFunction() {

    }

    public double calculateOutput(double summedInput) {
        Double sigmoid = 1/(1 + Math.exp(-summedInput));
        return sigmoid;
    }
}