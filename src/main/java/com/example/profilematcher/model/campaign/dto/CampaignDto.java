package com.example.profilematcher.model.campaign.dto;

import com.example.profilematcher.model.campaign.CampaignMatcher;
import com.example.profilematcher.model.campaign.DoesNotHaveMatcher;
import com.example.profilematcher.model.campaign.HasMatcher;
import com.example.profilematcher.model.campaign.LevelMatcher;
import lombok.Data;

@Data
public class CampaignDto {
    private String game;
    private String name;
    private Double priority;
    private String startDate;
    private String endDate;
    private String lastUpdated;
    private Boolean enabled;
    private CampaignMatcher matchers;
//    private LevelMatcher levelMatcher;
//    private HasMatcher hasMatcher;
//    private DoesNotHaveMatcher doesNotHaveMatcher;

}
