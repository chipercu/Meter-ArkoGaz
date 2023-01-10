package ru.fuzzy.meter.model;

public class Meter {
    private String owner;
    private Integer serial;
    private Integer data;


    public Meter(String owner, Integer serial, Integer data) {
        this.owner = owner;
        this.serial = serial;
        this.data = data;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
