package com.example.profilematcher.model.userprofile;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Table
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
    private int totalSpent;

    @Column(value = "total_refund")
    private int totalRefund;

    @Column(value = "total_transactions")
    private int totalTransactions;

    @Column(value = "last_purchase")
    private Date lastPurchase;

    @Column(value = "level")
    private int level;

    @Column(value = "xp")
    private int xp;

    @Column(value = "total_playtime")
    private int totalPlaytime;

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

    public UserProfile() {
    }

    public UserProfile(UUID playerId, String credential, Date created, Date modified, Date lastSession, int totalSpent, int totalRefund, int totalTransactions, Date lastPurchase, int level, int xp, int totalPlaytime, String country, String language, Date birthdate, String gender, Map<String, Integer> inventory, String customField, Map<String, String> clan, List<Device> devices, List<ActiveCampaign> activeCampaigns) {
        this.playerId = playerId;
        this.credential = credential;
        this.created = created;
        this.modified = modified;
        this.lastSession = lastSession;
        this.totalSpent = totalSpent;
        this.totalRefund = totalRefund;
        this.totalTransactions = totalTransactions;
        this.lastPurchase = lastPurchase;
        this.level = level;
        this.xp = xp;
        this.totalPlaytime = totalPlaytime;
        this.country = country;
        this.language = language;
        this.birthdate = birthdate;
        this.gender = gender;
        this.inventory = inventory;
        this.customField = customField;
        this.clan = clan;
        this.devices = devices;
        this.activeCampaigns = activeCampaigns;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastSession() {
        return lastSession;
    }

    public void setLastSession(Date lastSession) {
        this.lastSession = lastSession;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }

    public int getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(int totalRefund) {
        this.totalRefund = totalRefund;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public Date getLastPurchase() {
        return lastPurchase;
    }

    public void setLastPurchase(Date lastPurchase) {
        this.lastPurchase = lastPurchase;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getTotalPlaytime() {
        return totalPlaytime;
    }

    public void setTotalPlaytime(int totalPlaytime) {
        this.totalPlaytime = totalPlaytime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }

    public Map<String, String> getClan() {
        return clan;
    }

    public void setClan(Map<String, String> clan) {
        this.clan = clan;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<ActiveCampaign> getActiveCampaigns() {
        return activeCampaigns;
    }

    public void setActiveCampaigns(List<ActiveCampaign> activeCampaigns) {
        this.activeCampaigns = activeCampaigns;
    }
}