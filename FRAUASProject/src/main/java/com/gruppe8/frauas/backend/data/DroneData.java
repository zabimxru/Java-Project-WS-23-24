package com.gruppe8.frauas.backend.data;

import java.util.Date;

public class DroneData {

    private long id;
    private String dronetype;
    private Date created;
    private String serialnumber;
    private int carriage_weight;
    private String carriage_type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDronetype() {
        return dronetype;
    }

    public void setDronetype(String dronetype) {
        this.dronetype = dronetype;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public int getCarriage_weight() {
        return carriage_weight;
    }

    public void setCarriage_weight(int carriage_weight) {
        this.carriage_weight = carriage_weight;
    }

    public String getCarriage_type() {
        return carriage_type;
    }

    public void setCarriage_type(String carriage_type) {
        this.carriage_type = carriage_type;
    }
}
