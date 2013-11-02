package RGI;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;

public class RGI {

	public static void main(String[] args) {
		try {
			Instances positive = DataSource.read("./dictionary/positive.csv");
			Instances negative = DataSource.read("./dictionary/negative.csv");
		} catch (Exception e) {
			System.out.println("Can't load dictionary");
			e.printStackTrace();
		}
		
	}

}
