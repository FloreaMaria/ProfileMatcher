package com.example.profilematcher.model.campaign;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
public class Campaign {

    @PrimaryKeyColumn(name = "campaign_id", type = PrimaryKeyType.PARTITIONED)
    private UUID campaignId;

    @Column(value = "game")
    private String game;

    @Column(value = "name")
    private String name;

    @Column(value = "priority")
    private Double priority;

    @Column(value = "matchers")
    private CampaignMatcher matchers;

    @Column(value = "start_date")
    private Date startDate;

    @Column(value = "end_date")
    private Date endDate;

    @Column(value = "enabled")
    private Boolean enabled;

    @Column(value = "last_updated")
    private Date lastUpdated;

    public Campaign() {
    }

    public Campaign(UUID campaignId, String game, String name, Double priority, CampaignMatcher campaignMatcher, Date startDate, Date endDate, Boolean enabled, Date lastUpdated) {
        this.campaignId = campaignId;
        this.game = game;
        this.name = name;
        this.priority = priority;
        this.matchers = campaignMatcher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.enabled = enabled;
        this.lastUpdated = lastUpdated;
    }

    public UUID getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(UUID campaignId) {
        this.campaignId = campaignId;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriority() {
        return priority;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }

    public CampaignMatcher getMatchers() {
        return matchers;
    }

    public void setMatchers(CampaignMatcher matchers) {
        this.matchers = matchers;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
