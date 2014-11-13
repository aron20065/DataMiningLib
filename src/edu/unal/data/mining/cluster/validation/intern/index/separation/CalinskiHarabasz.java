package edu.unal.data.mining.cluster.validation.intern.index.separation;

import java.util.List;

import edu.unal.data.mining.cluster.Cluster;
import edu.unal.data.mining.cluster.validation.intern.cohesion.SSW;
import edu.unal.data.mining.cluster.validation.intern.separation.SSB;

public class CalinskiHarabasz {
	public static double calculate(List<Cluster> clusters ){
		double ssb = SSB.calculate(clusters);
		double ssw = SSW.calculate(clusters);
		int k = clusters.size();
		int n = 0;
		for (int i = 0; i < clusters.size(); i++) {
			n += clusters.get(i).getDataset().size();
		}
		return (ssb/(k-1))/(ssw/(n-k));
	}
}
