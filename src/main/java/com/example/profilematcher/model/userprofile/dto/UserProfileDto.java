package com.example.profilematcher.model.userprofile.dto;

import com.example.profilematcher.model.userprofile.Device;
import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.List;

@Data
public class UserProfileDto {
    private String credential;
    private String created;
    private String modified;
    private String lastSession;
    private Integer totalSpent;
    private Integer totalRefund;
    private Integer totalTransactions;
    private String lastPurchase;
    private String birthDate;
    private String gender;
    private String country;
    private String language;
    private String customField;
    private Integer level;
    private Integer xp;
    private Integer totalPlayTime;
    private Map<String, String> clan;
    private Map<String, Integer> inventory;
    private List<Device> devices;
}
