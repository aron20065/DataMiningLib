package edu.unal.data.mining.cluster;

import java.util.ArrayList;
import java.util.List;

import edu.unal.data.mining.DataSet;

public class Cluster {
	private String label;
	private List<Double> centroid;
	private List<String> labelDataset;
	private List<DataSet> dataset;
	private Boolean datasetchage;
	
	public Cluster() {
		this.centroid = new ArrayList<Double>();
		this.labelDataset = new ArrayList<String>();
		this.dataset = new ArrayList<DataSet>();
		this.datasetchage = false;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Double> getCentroid() {
		calculateCentroid();
		return centroid;
	}

	public void setCentroid(List<Double> centroid) {
		this.centroid = centroid;
	}

	public List<String> getLabelDataset() {
		return labelDataset;
	}

	public void setLabelDataset(List<String> labelDataset) {
		this.labelDataset = labelDataset;
		
	}

	public List<DataSet> getDataset() {
		return dataset;
	}

	public void setDataset(List<DataSet> dataset) {
		this.dataset = dataset;
		datasetchage=true;
	}
	
	public void addDataset(DataSet dataset) {
		this.dataset.add(dataset);
		datasetchage=true;
	}
	
	private void calculateCentroid(){
		if (datasetchage){
			int k = dataset.get(0).getData().size();
			double result;
			for (int i = 0; i < k; i++) {
				result = 0;
				for (int j = 0; j < dataset.size(); j++) {
					DataSet data = dataset.get(j);
					result +=data.getData().get(i);
				}
				result = result/dataset.size();
				this.centroid.add(result);
			}
			this.datasetchage=false;
		}
	}
}
