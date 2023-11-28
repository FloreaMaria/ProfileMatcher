package com.example.profilematcher.model.campaign.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.UUID;

@Document(indexName = "campaign_index", createIndex = true)
public class CampaignElasticSearch {

    @Id
    @Field(type = FieldType.Keyword, name = "campaign_id")
    private UUID campaignId;

    @Field(type = FieldType.Text, name = "game")
    private String game;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Double, name = "priority")
    private Double priority;

    @Field(type = FieldType.Nested, name = "matchers")
    private CampaignMatcherElasticSearch matchers;

    @Field(type = FieldType.Date, name = "start_date")
    private Date startDate;

    @Field(type = FieldType.Date, name = "end_date")
    private Date endDate;

    @Field(type = FieldType.Boolean, name = "enabled")
    private Boolean enabled;

    @Field(type = FieldType.Date, name = "last_updated")
    private Date lastUpdated;

    public CampaignElasticSearch() {
    }

    public CampaignElasticSearch(UUID campaignId, String game, String name, Double priority, CampaignMatcherElasticSearch matchers, Date startDate, Date endDate, Boolean enabled, Date lastUpdated) {
        this.campaignId = campaignId;
        this.game = game;
        this.name = name;
        this.priority = priority;
        this.matchers = matchers;
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

    public CampaignMatcherElasticSearch getMatchers() {
        return matchers;
    }

    public void setMatchers(CampaignMatcherElasticSearch matchers) {
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
