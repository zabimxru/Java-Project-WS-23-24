package com.gruppe8.frauas.backend.data;

public class DroneTypes {
	private int id;
	private String manufacturer;
	private String typeName;
	private int weight;
	private int maxSpeed;
	private int batteryCapacity;
	private int controlRange;
	private int maxCarriage;
	
	public DroneTypes(int id, String manufacturer, String typeName, int weight,
			int maxSpeed, int batteryCapacity, int controlRange, int maxCarriage) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.typeName = typeName;
		this.weight = weight;
		this.maxSpeed = maxSpeed;
		this.batteryCapacity = batteryCapacity;
		this.controlRange = controlRange;
		this.maxCarriage = maxCarriage;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getMaximumSpeed() {
		return maxSpeed;
	}
	public void setMaximumSpeed(int maximumSpeed) {
		this.maxSpeed = maximumSpeed;
	}
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public int getControlRange() {
		return controlRange;
	}
	public void setControlRange(int controlRange) {
		this.controlRange = controlRange;
	}
	public int getMaximumCarriage() {
		return maxCarriage;
	}
	public void setMaximumCarriage(int maximumCarriage) {
		this.maxCarriage = maximumCarriage;
	}
}
