package com.example.profilematcher.model.userprofile;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("device_type")
public class Device {

    private Long id;
    private String model;
    private String carrier;
    private String firmware;

}

