package NetworkConstruction;

import java.util.ArrayList;
import java.util.Random;

public class RandomNeuralNetwork {

<<<<<<< HEAD
    private NeuralNetLayer inputNetLayer;
    private NeuralNetLayer hiddenNetLayer;
    private NeuralNetLayer outputNetLayer;

=======
    private NeuralNetLayer inputLayer;

    private NeuralNetLayer hiddenLayer;

    private NeuralNetLayer outputLayer;
>>>>>>> d652c404cbd00ad707319ee32699fc894781dbfa

    public RandomNeuralNetwork () {
        //Input Layer
        Random rand = new Random();
        double output = rand.nextDouble() * 10.0;
        double bias = rand.nextDouble() * 10.0;
        Neuron neuronIA = new Neuron(output, bias);
        output = rand.nextDouble() * 10.0;
        bias = rand.nextDouble() * 10.0;
        Neuron neuronIB = new Neuron(output, bias);
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
        ArrayList<NeuronsConnection> inputToHidden = new ArrayList<>();
        for (int i = 0; i < inputLayerNeurons.size(); i++) {
            for (int j = 0; j < hiddenLayerNeurons.size(); j++) {
                NeuronsConnection neuronsConnection = new NeuronsConnection(inputLayerNeurons.get(i), hiddenLayerNeurons.get(j));
                inputToHidden.add(neuronsConnection);
            }
        }

        //Connections from Hidden Layer to Output Layer
        ArrayList<NeuronsConnection> hiddenToOutput = new ArrayList<>();
        for (int i = 0; i < hiddenLayerNeurons.size(); i++) {
            for (int j = 0; j < outputLayerNeurons.size(); j++) {
                NeuronsConnection neuronsConnection = new NeuronsConnection(hiddenLayerNeurons.get(i), outputLayerNeurons.get(j));
                inputToHidden.add(neuronsConnection);
            }
        }

        //Setting the nodes in each layer with their new connections
        for (Neuron neuron : inputLayerNeurons) {
            neuron.setOutputConnections(inputToHidden);
        }
        for (Neuron neuron : hiddenLayerNeurons) {
            neuron.setInputConnections(inputToHidden);
            neuron.setOutputConnections(hiddenToOutput);
        }
        for (Neuron neuron : outputLayerNeurons) {
            neuron.setInputConnections(hiddenToOutput);
        }

<<<<<<< HEAD
        this.inputNetLayer = inputLayer;
        this.hiddenNetLayer = hiddenLayer;
        this.outputNetLayer = outputLayer;
    }

    public NeuralNetLayer getInputNetLayer() {
        return inputNetLayer;
    }

    public void setInputNetLayer(NeuralNetLayer inputNetLayer) {
        this.inputNetLayer = inputNetLayer;
=======
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
>>>>>>> d652c404cbd00ad707319ee32699fc894781dbfa
    }

    @Override
    public String toString() {
        return "RandomNeuralNetwork{" +
<<<<<<< HEAD
                "inputNetLayer=" + inputNetLayer +
                ", hiddenNetLayer=" + hiddenNetLayer +
                ", outputNetLayer=" + outputNetLayer +
=======
                "inputLayer=" + inputLayer +
                ", hiddenLayer=" + hiddenLayer +
                ", outputLayer=" + outputLayer +
>>>>>>> d652c404cbd00ad707319ee32699fc894781dbfa
                '}';
    }
}
