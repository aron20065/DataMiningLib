package edu.unal.data.mining.cluster.validation.intern.index.cohesion;

import java.util.List;

import edu.unal.data.mining.cluster.Cluster;
import edu.unal.data.mining.cluster.validation.intern.cohesion.SSW;

public class Xu {
	public static double calculate(List<Cluster> clusters ){
		double ssw = SSW.calculate(clusters);
		int d = clusters.get(0).getDataset().get(0).getData().size();
		int k = clusters.size();
		int n = 0;
		for (int i = 0; i < clusters.size(); i++) {
			n += clusters.get(i).getDataset().size();
		}
//		System.out.println("d=\t"+d+
//				"\tssw=\t"+ssw+
//				"\tssb=\t"+ssb+
//				"\tk=\t"+k+
//				"\tn=\t"+n);
		return (d*Math.log10(Math.sqrt(ssw/(d*Math.pow(n, 2)))))+Math.log10(k);
	}
}
