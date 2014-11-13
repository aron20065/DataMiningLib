package edu.unal.data.mining.measure.dissimilarity;

import java.util.List;

public class EuclideanSquare {
	public static Double calculate(List<Double> data1,List<Double> data2 ){
		double result=0;
		for (int i = 0; i < data1.size(); i++) {
			result += Math.pow((data1.get(i)-data2.get(i)), 2);
		}
		return result;
	}

	public static double calculate(List<Double> data1, double mean) {
		double result=0;
		for (int i = 0; i < data1.size(); i++) {
			result += Math.pow((data1.get(i)-mean), 2);
		}
		return result;
	}
}
