package edu.unal.data.mining.cluster.validation.intern.index;

import java.util.List;

import edu.unal.data.mining.DataSet;
import edu.unal.data.mining.cluster.Cluster;
import edu.unal.data.mining.measure.dissimilarity.Euclidean;

public class DaviesBouldin {
	public static double calculate(List<Cluster> clusters) {
		int k = clusters.size();
		double db = 0.0;
		for (int i = 0; i < clusters.size(); i++) {
			double max = 0.0;
			for (int j = 0; j < clusters.size(); j++) {
				if (j!=i){
					double disCentroids = Euclidean.calculate(clusters.get(i).getCentroid(), clusters.get(j).getCentroid());
					double sigmaI = sigma(clusters.get(i));
					double sigmaJ = sigma(clusters.get(j));
					double resultTmp = (sigmaI+sigmaJ)/disCentroids;
//					System.out.println("\tsigmaI\t"+sigmaI+"\tsigmaJ\t"+sigmaJ+"\tdisCentroids\t"+disCentroids+"\tresultTmp\t"+resultTmp);
					if (j==0){
						max = resultTmp;
					}else if (resultTmp >=max){
						max = resultTmp;
					}
				}
			}
//			System.out.println("max\t"+max);
			db +=max;
			
		}
//		System.out.println("db\t"+db);
//		System.out.println("k\t"+k);
//		System.out.println(db/k);
		db = (1.0/k)*db;
//		System.out.println("db\t"+db);
		return db;
	}

	private static double sigma(Cluster cluster) {
		List<Double> centroid = cluster.getCentroid();
		int n = cluster.getDataset().size();
		List<DataSet> dataSets = cluster.getDataset(); 
		double sumDitance = 0;
		for (int i = 0; i < dataSets.size() ; i++) {
			List<Double> data = dataSets.get(i).getData();
			sumDitance +=Euclidean.calculate(centroid, data);
		}
		sumDitance = sumDitance/n; 
		return sumDitance;
	}
}
