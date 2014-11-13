package edu.unal.data.mining.cluster.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.unal.data.mining.DataSet;
import edu.unal.data.mining.cluster.Cluster;

/**
 * Clase encargada de leer los datos de un archivo en los siguientes formatos:
 * CSV TXT
 * 
 * @author hamer
 *
 */
public class ReadCluster {
	private String path;

	public ReadCluster(String path) {
		this.path = path;
	}

	public List<Cluster> readFileCSV(String separator, boolean label,boolean id) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String sCurrentLine;
			HashMap<String, Cluster> clustersMap = new HashMap<String, Cluster>();
			Cluster cluster;
			List<String> labels = null;
			while ((sCurrentLine = br.readLine()) != null) {
				if (label){
					String [] data =  sCurrentLine.split(separator);
					labels = Arrays.asList(data);
					label=false;
					continue;
				}
				String [] data =  sCurrentLine.split(separator);
				if (clustersMap.get(data[0]) != null){
					cluster = clustersMap.get(data[0]);
				}else{
					cluster = new Cluster();
					cluster.setLabel(data[0]);
					cluster.setLabelDataset(labels);
					clustersMap.put(data[0], cluster);
					cluster  = clustersMap.get(data[0]);
				}
				if (id){
					data = Arrays.copyOfRange(data, 2, data.length);	
				}else{
					data = Arrays.copyOfRange(data, 1, data.length);
				}
				DataSet dataset= new DataSet();
				ArrayList<Double> datasettemp = new ArrayList<Double>();
				for (int i = 0; i < data.length; i++) {
					datasettemp.add(Double.parseDouble(data[i]));
				}
				dataset.setData(datasettemp);
				cluster.addDataset(dataset);			
			}
			List<Cluster> clusterslist = new ArrayList<Cluster>(clustersMap.values());
			return clusterslist;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
