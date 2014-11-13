package edu.unal.data.mining.cluster.validation.intern.separation;

import java.util.List;

import edu.unal.data.mining.DataSet;
import edu.unal.data.mining.cluster.Cluster;
import edu.unal.data.mining.measure.dissimilarity.EuclideanSquare;

public class SSB {
	/**
	 * 
	 * @param clusters
	 * @return
	 */
	public static double calculate(List<Cluster> clusters ){
		int k = clusters.size();
		double result = 0;
		double mean = calculateMean(clusters);
		for (int i = 0; i < k; i++) {
			List<Double> mi = clusters.get(i).getCentroid();
			//mean = calculateMean(clusters.get(i));
			int n = clusters.get(i).getDataset().size();
			for (int j = 0; j < mi.size(); j++) {
				result +=n*EuclideanSquare.calculate(mi, mean);
			}
		}
		return result;
	}
	
	private static double calculateMean(List<Cluster> clusters) {
		int totalDatas = 0;
		int totalDimensions = clusters.get(0).getDataset().get(0).getData().size();
		double sumData=0;
		double mean = 0.0;
		for (int i = 0; i < clusters.size(); i++) {
			List<DataSet> dataSets = clusters.get(i).getDataset();
			totalDatas +=  clusters.get(i).getDataset().size();
			for (int j = 0; j < dataSets.size(); j++) {
				List<Double> data= dataSets.get(j).getData();
				for (int k = 0; k < data.size(); k++) {
					sumData += data.get(k);
				}
			}
		}
		mean = sumData/(totalDatas*totalDimensions);
		return mean;
	}

	private static Double calculateMean(Cluster cluster){
		double totalData = cluster.getDataset().size() * cluster.getDataset().get(0).getData().size();
		double result = 0;
		List<DataSet> dataset = cluster.getDataset();
		for (int i = 0; i < dataset.size(); i++) {
			List<Double> data= dataset.get(i).getData();
			for (int j = 0; j < data.size(); j++) {
				result += data.get(j);
			}
		}
		result = result /totalData;
		return result;
	}
}
