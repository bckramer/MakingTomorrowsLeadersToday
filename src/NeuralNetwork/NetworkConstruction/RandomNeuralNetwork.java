package NetworkConstruction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class RandomNeuralNetwork {

    private NeuralNetLayer inputLayer;

    private NeuralNetLayer hiddenLayer;

    private NeuralNetLayer outputLayer;

    public RandomNeuralNetwork () {
        //Input Layer
        Random rand = new Random();
        double output = rand.nextDouble() * 2 - 1;
        double bias = rand.nextDouble() * 2 - 1;
        Neuron neuronIA = new Neuron(output, bias);
        Random rand2 = new Random();
        double output1 = rand2.nextDouble() * 2 - 1;
        double bias1 = rand2.nextDouble() * 2 - 1;
        Neuron neuronIB = new Neuron(output1, bias1);
        ArrayList<Neuron> inputLayerNeurons = new ArrayList<>();
        inputLayerNeurons.add(neuronIA);
        inputLayerNeurons.add(neuronIB);
        NeuralNetLayer inputLayer = new NeuralNetLayer("inputLayerRandom", inputLayerNeurons);

        //Hidden Layer
        ArrayList<Neuron> hiddenLayerNeurons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Neuron neuron = new Neuron();
            hiddenLayerNeurons.add(neuron);
        }
        NeuralNetLayer hiddenLayer = new NeuralNetLayer("hiddenLayerRandom", hiddenLayerNeurons);

        //Output Layer
        ArrayList<Neuron> outputLayerNeurons = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Neuron neuron = new Neuron();
            outputLayerNeurons.add(neuron);
        }
        NeuralNetLayer outputLayer = new NeuralNetLayer("outputLayerRandom", outputLayerNeurons);

        //Connections from Input Layer to Hidden Layer
        for (int i = 0; i < inputLayerNeurons.size(); i++) {
            ArrayList<NeuronsConnection> inputToHidden = new ArrayList<>();
            for (int j = 0; j < hiddenLayerNeurons.size(); j++) {
                NeuronsConnection neuronsConnection = new NeuronsConnection(inputLayerNeurons.get(i), hiddenLayerNeurons.get(j));
                inputToHidden.add(neuronsConnection);
            }
            inputLayerNeurons.get(i).setOutputConnections(inputToHidden);
        }

        for (int i = 0; i < hiddenLayerNeurons.size(); i++) {
            ArrayList<NeuronsConnection> connections = new ArrayList<>();
            for (int j = 0; j < inputLayerNeurons.size(); j++) {
                connections.add(inputLayerNeurons.get(j).getOutputConnections().get(i));
            }
            hiddenLayerNeurons.get(i).setInputConnections(connections);
        }

        for (int i = 0; i < hiddenLayerNeurons.size(); i++) {
            ArrayList<NeuronsConnection> hiddenToOutput = new ArrayList<>();
            for (int j = 0; j < outputLayerNeurons.size(); j++) {
                NeuronsConnection neuronsConnection = new NeuronsConnection(hiddenLayerNeurons.get(i), outputLayerNeurons.get(j));
                hiddenToOutput.add(neuronsConnection);
            }
            hiddenLayerNeurons.get(i).setOutputConnections(hiddenToOutput);
        }

        for (int i = 0; i < outputLayerNeurons.size(); i++) {
            ArrayList<NeuronsConnection> connections = new ArrayList<>();
            for (int j = 0; j < hiddenLayerNeurons.size(); j++) {
                connections.add(hiddenLayerNeurons.get(j).getOutputConnections().get(i));
            }
            outputLayerNeurons.get(i).setInputConnections(connections);
        }

        //Setting the nodes in each layer with their new connections


        this.inputLayer = inputLayer;
        this.hiddenLayer = hiddenLayer;
        this.outputLayer = outputLayer;
    }

    public NeuralNetLayer getInputLayer() {
        return inputLayer;
    }

    public void setInputLayer(NeuralNetLayer inputLayer) {
        this.inputLayer = inputLayer;
    }

    public NeuralNetLayer getHiddenLayer() {
        return hiddenLayer;
    }

    public void setHiddenLayer(NeuralNetLayer hiddenLayer) {
        this.hiddenLayer = hiddenLayer;
    }

    public NeuralNetLayer getOutputLayer() {
        return outputLayer;
    }

    public void setOutputLayer(NeuralNetLayer outputLayer) {
        this.outputLayer = outputLayer;
    }

    @Override
    public String toString() {
        return "RandomNeuralNetwork{" +
                "inputLayer=" + inputLayer +
                ", hiddenLayer=" + hiddenLayer +
                ", outputLayer=" + outputLayer +
                '}';
    }
}
