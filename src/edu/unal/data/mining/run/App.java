package edu.unal.data.mining.run;


import java.util.List;

import edu.unal.data.mining.cluster.Cluster;
import edu.unal.data.mining.cluster.util.ReadCluster;
import edu.unal.data.mining.cluster.validation.intern.cohesion.SSW;
import edu.unal.data.mining.cluster.validation.intern.index.DaviesBouldin;
import edu.unal.data.mining.cluster.validation.intern.index.cohesion.BallHall;
import edu.unal.data.mining.cluster.validation.intern.index.cohesion.Xu;
import edu.unal.data.mining.cluster.validation.intern.index.separation.CalinskiHarabasz;
import edu.unal.data.mining.cluster.validation.intern.index.separation.Hartigan;
import edu.unal.data.mining.cluster.validation.intern.separation.SSB;

public class App {
	public static void main(String[] args) {
		String[] nameFiles = {
				"kmeans_2_tf",
				"kmeans_4_tf",
				"kmeans_6_tf",
				"kmeans_8_tf",
				"kmeans_10_tf",
				"kmeans_12_tf",
				"kmeans_14_tf",
				"kmeans_16_tf",
				"kmeans_18_tf",
				"kmeans_20_tf",
				"kmeans_2",
				"kmeans_4",
				"kmeans_6",
				"kmeans_8",
				"kmeans_10",
				"kmeans_12",
				"kmeans_14",
				"kmeans_16",
				"kmeans_18",
				"kmeans_20",
				"dbscan"
				};
		System.out.println("method\tclusters\tSSE\tSSB\tBall and Hall\tXu\tCalinski and Harabasz\tHartigan\tDaviesBouldin");
		for (int i = 0; i < nameFiles.length; i++) {
			String nameFile = nameFiles[i];
			ReadCluster rc = new ReadCluster("data/"+nameFile+".csv");
			List<Cluster> clusterslist = rc.readFileCSV(";", true,true);
//			for (int i = 0; i < clusterslist.size(); i++) {
//			Cluster cluster= clusterslist.get(i);
//			System.out.println("cluster label : "+ cluster.getLabel());
//			System.out.println("\titems : "+ cluster.getDataset().size());
//			System.out.println("centroid: ");
//			System.out.println(cluster.getCentroid());
//		}
			
			System.out.println(nameFiles[i]+"\t"
			+clusterslist.size()+"\t"
			+SSW.calculate(clusterslist)+"\t"
			+SSB.calculate(clusterslist)+"\t"
			+BallHall.calculate(clusterslist)+"\t"
			+Xu.calculate(clusterslist)+"\t"
			+CalinskiHarabasz.calculate(clusterslist)+"\t"
			+Hartigan.calculate(clusterslist)+"\t"+
			+DaviesBouldin.calculate(clusterslist));
		}

		
	}
}
