import java.util.List;

public class OverviewDroneType {
	private int id;
	private String manufacturer;
	private String typeName;
	private List<OverviewDrone> drones;
	private int weight;
	private int maximumSpeed;
	private int batteryCapacity;
	private int controlRange;
	private int maximumCarriage;
	
	public OverviewDroneType(int id, String manufacturer, String typeName, List<OverviewDrone> drones, int weight,
			int maximumSpeed, int batteryCapacity, int controlRange, int maximumCarriage) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.typeName = typeName;
		this.drones = drones;
		this.weight = weight;
		this.maximumSpeed = maximumSpeed;
		this.batteryCapacity = batteryCapacity;
		this.controlRange = controlRange;
		this.maximumCarriage = maximumCarriage;
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
	public List<OverviewDrone> getDrones() {
		return drones;
	}
	public void setDrones(List<OverviewDrone> drones) {
		this.drones = drones;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
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
		return maximumCarriage;
	}
	public void setMaximumCarriage(int maximumCarriage) {
		this.maximumCarriage = maximumCarriage;
	}

}
