package edu.unal.data.mining.cluster.validation.intern.cohesion;

import java.util.List;

import edu.unal.data.mining.DataSet;
import edu.unal.data.mining.cluster.Cluster;
import edu.unal.data.mining.measure.dissimilarity.EuclideanSquare;

/**
 * Medida interna especialmente usada para evaluar la Cohesi�n de los
	clesteres que el algoritmo de agrupamiento gener�.
 * @author hamer
 *
 */
public class SSW {
	/**
	 * 
	 * @param clusters
	 * @return
	 */
	public static double calculate(List<Cluster> clusters ){
		int k = clusters.size();
		double result = 0;
		for (int i = 0; i < k; i++) {
			List<Double> mi = clusters.get(i).getCentroid();
			List<DataSet> datasets = clusters.get(i).getDataset();
			for (int j = 0; j < datasets.size(); j++) {
				DataSet dataset = datasets.get(j);
				result +=EuclideanSquare.calculate(mi, dataset.getData());
			}
		}
		return result;
	}
}
