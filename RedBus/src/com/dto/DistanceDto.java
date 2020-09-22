package com.dto;

public class DistanceDto {
	private int id;
	private String startpoint;
	private String endpoint;
	private int kilometeres;

	public DistanceDto() {
		super();
	}

	public DistanceDto(int id, String startpoint, String endpoint, int kilometeres) {
		super();
		this.id = id;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.kilometeres = kilometeres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartpoint() {
		return startpoint;
	}

	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public int getKilometeres() {
		return kilometeres;
	}

	public void setKilometeres(int kilometeres) {
		this.kilometeres = kilometeres;
	}

	@Override
	public String toString() {
		return "Distance [id=" + id + ", startpoint=" + startpoint + ", endpoint=" + endpoint + ", kilometeres="
				+ kilometeres + "]";
	}

}
