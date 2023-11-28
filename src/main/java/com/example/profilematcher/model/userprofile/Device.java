package com.example.profilematcher.model.userprofile;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("device_type")
public class Device {

    @Column
    private Long id;
    @Column
    private String model;
    @Column
    private String carrier;
    @Column
    private String firmware;

    public Device() {
    }

    public Device(Long id, String model, String carrier, String firmware) {
        this.id = id;
        this.model = model;
        this.carrier = carrier;
        this.firmware = firmware;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }
}

