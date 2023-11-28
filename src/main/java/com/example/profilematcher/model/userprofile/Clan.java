package com.example.profilematcher.model.userprofile;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("clan_type")
public class Clan {
    private Long id;
    private String name;

    public Clan() {
    }

    public Clan(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
