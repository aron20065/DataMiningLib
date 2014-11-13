package edu.unal.data.mining;

import java.util.List;

public class DataSet {
	private List<String> atribute;
	private List<Double> data;
	public List<String> getAtribute() {
		return atribute;
	}
	public void setAtribute(List<String> atribute) {
		this.atribute = atribute;
	}
	public List<Double> getData() {
		return data;
	}
	public void setData(List<Double> data) {
		this.data = data;
	}
}
