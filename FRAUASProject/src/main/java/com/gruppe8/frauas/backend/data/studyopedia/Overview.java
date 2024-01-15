import java.util.Date;
import java.util.List;

public class Overview {
	
	public Overview(int id, String manufacturer, String typename, String serialnumber, Date created, String status,
			Date lastUpdate, List<OverviewDrone> drones) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.typename = typename;
		this.serialnumber = serialnumber;
		this.created = created;
		this.status = status;
		this.lastUpdate = lastUpdate;
		this.drones = drones;
	}
	
	private int id;
	private String manufacturer;
	private String typename;
	private String serialnumber;
	private Date created;
	private String status;
	private Date lastUpdate;
	private List<OverviewDrone> drones;
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
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public List<OverviewDrone> getDrones() {
		return drones;
	}
	public void setDrones(List<OverviewDrone> drones) {
		this.drones = drones;
	}
	
	
}
