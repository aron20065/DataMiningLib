package edu.unal.data.mining.cluster.validation.intern.index.cohesion;

import java.util.List;

import edu.unal.data.mining.cluster.Cluster;
import edu.unal.data.mining.cluster.validation.intern.cohesion.SSW;

public class BallHall {

	public static double calculate(List<Cluster> clusters ){
		double ssw = SSW.calculate(clusters);
		int k = clusters.size();
		return ssw/k;
	}
}
