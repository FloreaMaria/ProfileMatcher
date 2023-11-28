package com.example.profilematcher.model.userprofile;

import com.example.profilematcher.model.campaign.CampaignMatcher;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.Date;
import java.util.UUID;

@UserDefinedType("active_campaign_type")
public class ActiveCampaign {

    @PrimaryKeyColumn(name = "campaign_id", type = PrimaryKeyType.PARTITIONED)
    private UUID campaignId;

    @Column(value = "game")
    private String game;

    @Column(value = "name")
    private String name;

    @Column(value = "priority")
    private Double priority;

    @Column(value = "matchers")
    @CassandraType(type = CassandraType.Name.UDT, userTypeName = "campaign_matcher_type")
    private CampaignMatcher campaignMatcher;

    @Column(value = "start_date")
    private Date startDate;

    @Column(value = "end_date")
    private Date endDate;

    @Column(value = "enabled")
    private Boolean enabled;

    @Column(value = "last_updated")
    private Date lastUpdated;

}
