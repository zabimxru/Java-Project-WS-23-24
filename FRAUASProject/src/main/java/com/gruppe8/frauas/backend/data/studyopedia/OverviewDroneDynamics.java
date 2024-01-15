import java.util.Date;

public class OverviewDroneDynamics {
	private int id;
	private OverviewDrone drone;
	private Date timestamp;
	private double speed;
	private double alignmentRoll;
	private double controlRange;
	private double alignmentYaw;
	private double longitude;
	private double latitude;
	private int batteryStatus;
	private Date lastSeen;
	private String status;
	
	public OverviewDroneDynamics(int id, OverviewDrone drone, Date timestamp, double speed, double alignmentRoll,
			double controlRange, double alignmentYaw, double longitude, double latitude, int batteryStatus,
			Date lastSeen, String status) {
		super();
		this.id = id;
		this.drone = drone;
		this.timestamp = timestamp;
		this.speed = speed;
		this.alignmentRoll = alignmentRoll;
		this.controlRange = controlRange;
		this.alignmentYaw = alignmentYaw;
		this.longitude = longitude;
		this.latitude = latitude;
		this.batteryStatus = batteryStatus;
		this.lastSeen = lastSeen;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OverviewDrone getDrone() {
		return drone;
	}
	public void setDrone(OverviewDrone drone) {
		this.drone = drone;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getAlignmentRoll() {
		return alignmentRoll;
	}
	public void setAlignmentRoll(double alignmentRoll) {
		this.alignmentRoll = alignmentRoll;
	}
	public double getControlRange() {
		return controlRange;
	}
	public void setControlRange(double controlRange) {
		this.controlRange = controlRange;
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
	public Date getLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
