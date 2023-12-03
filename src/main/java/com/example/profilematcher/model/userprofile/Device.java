package com.example.profilematcher.model.userprofile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

}

