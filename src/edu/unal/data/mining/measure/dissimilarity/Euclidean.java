package edu.unal.data.mining.measure.dissimilarity;

import java.util.List;

public class Euclidean {
	public static Double calculate(List<Double> data1,List<Double> data2 ){
		double result=0;
		for (int i = 0; i < data1.size(); i++) {
			result += Math.pow((data1.get(i)-data2.get(i)), 2);
		}
		result = Math.sqrt(result);
		return result;
	}
}
