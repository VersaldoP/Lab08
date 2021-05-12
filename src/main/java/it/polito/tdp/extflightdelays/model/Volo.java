package it.polito.tdp.extflightdelays.model;

public class Volo {
	private int partenza;
	private int arrivo;
	private int distance;
	public Volo(int partenza, int arrivo, int distance) {
		super();
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.distance = distance;
	}
	public int getPartenza() {
		return partenza;
	}
	public void setPartenza(int partenza) {
		this.partenza = partenza;
	}
	public int getArrivo() {
		return arrivo;
	}
	public void setArrivo(int arrivo) {
		this.arrivo = arrivo;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
	