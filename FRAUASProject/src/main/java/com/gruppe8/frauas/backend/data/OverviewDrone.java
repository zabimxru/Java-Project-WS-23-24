package com.gruppe8.frauas.backend.data;
import java.util.List;

public class OverviewDrone { //DRONES
	private int id;
	private String droneType;
	private String serialNumber;
	private String Created;
	private int carriageWeight;
	private String carriageType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		Created = created;
	}
	public int getCarriageWeight() {
		return carriageWeight;
	}
	public void setCarriageWeight(int carriageWeight) {
		this.carriageWeight = carriageWeight;
	}
	public String getCarriageType() {
		return carriageType;
	}
	public void setCarriageType(String carriageType) {
		this.carriageType = carriageType;
	}
	public OverviewDrone(int id, String droneType, String created, String serialNumber, int carriageWeight, String carriageType) {
		super();
		this.id = id;
		this.setDroneType(droneType);
		this.Created = created;
		this.serialNumber = serialNumber;
		this.carriageWeight = carriageWeight;
		this.carriageType = carriageType;
	}
	public String getDroneType() {
		return droneType;
	}
	public void setDroneType(String droneType) {
		this.droneType = droneType;
	}
}
