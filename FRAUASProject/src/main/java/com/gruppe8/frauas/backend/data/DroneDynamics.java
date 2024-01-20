package com.gruppe8.frauas.backend.data;
import java.util.Date;

public class DroneDynamics {
	private String droneURL;
	private String timestamp;
	private int speed;
	private double alignmentRoll;
	private double alignmentPitch;
	private double alignmentYaw;
	private double longitude;
	private double latitude;
	private int batteryStatus;
	private String lastSeen;
	private String status;
	
	public DroneDynamics(String droneURL, String timestamp, int speed, double alignmentRoll, double alignmentPitch, double alignmentYaw, double longitude, double latitude, 
    		int batteryStatus, String lastSeen, String status) {
		super();
		this.droneURL = droneURL;
		this.timestamp = timestamp;
		this.speed = speed;
		this.alignmentRoll = alignmentRoll;
		this.alignmentPitch = alignmentPitch;
		this.alignmentYaw = alignmentYaw;
		this.longitude = longitude;
		this.latitude = latitude;
		this.batteryStatus = batteryStatus;
		this.lastSeen = lastSeen;
		this.status = status;
	}
	
	public String getDroneURL() {
		return droneURL;
	}
	public void setDrone(String drone) {
		this.droneURL = drone;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getAlignmentRoll() {
		return alignmentRoll;
	}
	public void setAlignmentRoll(double alignmentRoll) {
		this.alignmentRoll = alignmentRoll;
	}
	public double getAlignmentPitch() {
		return alignmentPitch;
	}
	public void setAlignmentPitch(double alignmentPitch) {
		this.alignmentPitch = alignmentPitch;
	}
	public double getAlignmentYaw() {
		return alignmentYaw;
	}
	public void setAlignmentYaw(double alignmentYaw) {
		this.alignmentYaw = alignmentYaw;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getBatteryStatus() {
		return batteryStatus;
	}
	public void setBatteryStatus(int batteryStatus) {
		this.batteryStatus = batteryStatus;
	}
	public String getLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
