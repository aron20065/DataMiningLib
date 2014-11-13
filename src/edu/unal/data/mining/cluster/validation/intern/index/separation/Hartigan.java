package edu.unal.data.mining.cluster.validation.intern.index.separation;

import java.util.List;

import edu.unal.data.mining.cluster.Cluster;
import edu.unal.data.mining.cluster.validation.intern.cohesion.SSW;
import edu.unal.data.mining.cluster.validation.intern.separation.SSB;

public class Hartigan {
	public static double calculate(List<Cluster> clusters ){
		double ssb = SSB.calculate(clusters);
		double ssw = SSW.calculate(clusters);
		return Math.log10(ssb/ssw);
	}
}
