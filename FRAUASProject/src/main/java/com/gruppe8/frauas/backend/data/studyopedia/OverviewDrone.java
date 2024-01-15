import java.util.List;

public class OverviewDrone { //DRONES
	private int id;
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
	public Overview getOverview() {
		return overview;
	}
	public void setOverview(Overview overview) {
		this.overview = overview;
	}
	public OverviewDroneType getDroneType() {
		return droneType;
	}
	public void setDroneType(OverviewDroneType droneType) {
		this.droneType = droneType;
	}
	public List<OverviewDroneDynamics> getDroneDynamics() {
		return droneDynamics;
	}
	public void setDroneDynamics(List<OverviewDroneDynamics> droneDynamics) {
		this.droneDynamics = droneDynamics;
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
	public int getCarriageType() {
		return carriageType;
	}
	public void setCarriageType(int carriageType) {
		this.carriageType = carriageType;
	}
	public OverviewDrone(int id, String serialNumber, Overview overview, OverviewDroneType droneType,
			List<OverviewDroneDynamics> droneDynamics, String created, int carriageWeight, int carriageType) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.overview = overview;
		this.droneType = droneType;
		this.droneDynamics = droneDynamics;
		Created = created;
		this.carriageWeight = carriageWeight;
		this.carriageType = carriageType;
	}
	
	public OverviewDrone() {}
	private String serialNumber;
	private Overview overview;
	private OverviewDroneType droneType;
	private List<OverviewDroneDynamics> droneDynamics;
	private String Created;
	private int carriageWeight;
	private int carriageType;

}
