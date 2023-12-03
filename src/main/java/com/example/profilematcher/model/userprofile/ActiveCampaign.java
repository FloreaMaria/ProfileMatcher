package com.example.profilematcher.model.userprofile;

import com.example.profilematcher.model.campaign.Campaign;
import com.example.profilematcher.model.campaign.CampaignMatcher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private CampaignMatcher campaignMatcher;

    @Column(value = "start_date")
    private Date startDate;

    @Column(value = "end_date")
    private Date endDate;

    @Column(value = "enabled")
    private Boolean enabled;

    @Column(value = "last_updated")
    private Date lastUpdated;

    public ActiveCampaign(Campaign campaign) {
        this.campaignId = campaign.getCampaignId();
        this.game = campaign.getGame();
        this.name = campaign.getName();
        this.priority = campaign.getPriority();
        this.campaignMatcher = campaign.getMatchers();
        this.startDate = campaign.getStartDate();
        this.endDate = campaign.getEndDate();
        this.enabled = campaign.getEnabled();
        this.lastUpdated = campaign.getLastUpdated();
    }

}
