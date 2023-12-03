package com.example.profilematcher.model.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
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

}
