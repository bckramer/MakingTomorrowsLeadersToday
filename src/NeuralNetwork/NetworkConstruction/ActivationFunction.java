package NetworkConstruction;

public class ActivationFunction {


    public ActivationFunction() {

    }

    public double calculateOutput(double summedInput, double bias) {
        double euler = Math.exp(-(summedInput - bias));
        double sigmoid = 1/(1 + euler);
        //System.out.println(sigmoid);
        return sigmoid;
    }
}