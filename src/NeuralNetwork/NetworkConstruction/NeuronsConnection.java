package NetworkConstruction;

import java.util.Random;

public class NeuronsConnection {

    private Neuron fromNeuron;

    private Neuron toNeuron;

    private double weight;

    public NeuronsConnection(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        Random rand = new Random();
        double randNum = rand.nextDouble() * 10.0;
        this.weight = Math.random();
    }

    public NeuronsConnection(Neuron fromNeuron, Neuron toNeuron, double weight) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = weight;
    }

    public double getWeight() {
return weight;
}

    public void setWeight(double weight) {
this.weight = weight;
}

    public double getInput() {
        return fromNeuron.getOutput();
    }

    public double getWeightedInput() {
        return fromNeuron.getOutput() * weight;
    }

    public Neuron getFromNeuron() {
return fromNeuron;
}

    public Neuron getToNeuron() {
return toNeuron;
}

    @Override
    public String toString() {
        return "NeuronsConnection{" +
                "fromNeuron=" + fromNeuron +
                ", toNeuron=" + toNeuron +
                ", weight=" + weight +
                '}';
    }
}