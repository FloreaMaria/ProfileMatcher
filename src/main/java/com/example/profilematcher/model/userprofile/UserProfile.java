package com.example.profilematcher.model.userprofile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @PrimaryKeyColumn(name = "player_id", type = PrimaryKeyType.PARTITIONED)
    private UUID playerId;

    @Column(value = "credential")
    private String credential;

    @Column(value = "created")
    private Date created;

    @Column(value = "modified")
    private Date modified;

    @Column(value = "last_session")
    private Date lastSession;

    @Column(value = "total_spent")
    private Integer totalSpent;

    @Column(value = "total_refund")
    private Integer totalRefund;

    @Column(value = "total_transactions")
    private Integer totalTransactions;

    @Column(value = "last_purchase")
    private Date lastPurchase;

    @Column(value = "level")
    private Integer level;

    @Column(value = "xp")
    private Integer xp;

    @Column(value = "total_playtime")
    private Integer totalPlaytime;

    @Column(value = "country")
    private String country;

    @Column(value = "language")
    private String language;

    @Column(value = "birthdate")
    private Date birthdate;

    @Column(value = "gender")
    private String gender;

    @Column(value = "inventory")
    private Map<String, Integer> inventory;

    @Column(value = "custom_field")
    private String customField;

    @Column(value = "clan")
    private Map<String, String> clan;

    @Column(value = "devices")
    private List<Device> devices;

    @Column(value = "active_campaigns")
    private List<ActiveCampaign> activeCampaigns;


}