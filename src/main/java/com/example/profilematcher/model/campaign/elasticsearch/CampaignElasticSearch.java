package com.example.profilematcher.model.campaign.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "campaign_index",  createIndex = true)
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

}
