package RGI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;

public class RGILearner {

	/**
     * Main method. It is an example of the usage of this class.
     * @param args Command-line arguments: fileData and fileModel.
     */
	 /**
     * Object that stores training data.
     */
    Instances trainData;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RGILearner learner;
        if (args.length < 2)
                System.out.println("Usage: java RGILearner <fileData> <fileModel>");
        else {
                learner = new RGILearner();
                learner.loadDataset(args[0]);
                // Evaluation mus be done before training
                // More info in: http://weka.wikispaces.com/Use+WEKA+in+your+Java+code
                learner.evaluate();
                learner.learn();
                learner.saveModel(args[1]);
        }

	}
	
	
	/**
     * This method loads a dataset in ARFF format. If the file does not exist, or
     * it has a wrong format, the attribute trainData is null.
     * @param fileName The name of the file that stores the dataset.
     */
    public void loadDataset(String fileName) {
            try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    ArffReader arff = new ArffReader(reader);
                    trainData = arff.getData();
                    System.out.println("===== Loaded dataset: " + fileName + " =====");
                    reader.close();
            }
            catch (IOException e) {
                    System.out.println("Problem found when reading: " + fileName);
            }
    }

}
