package com.example.profilematcher.model.campaign;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("campaign_matcher_type")
public class CampaignMatcher {

    @Column(value = "level")
    private LevelMatcher levelMatcher;

    @Column(value = "has")
    private HasMatcher hasMatcher;

    @Column(value = "does_not_have")
    private DoesNotHaveMatcher doesNotHaveMatcher;

    public CampaignMatcher() {
    }


    public CampaignMatcher(LevelMatcher levelMatcher, HasMatcher hasMatcher, DoesNotHaveMatcher doesNotHaveMatcher) {
        this.levelMatcher = levelMatcher;
        this.hasMatcher = hasMatcher;
        this.doesNotHaveMatcher = doesNotHaveMatcher;
    }

    public LevelMatcher getLevelMatcher() {
        return levelMatcher;
    }

    public void setLevelMatcher(LevelMatcher levelMatcher) {
        this.levelMatcher = levelMatcher;
    }

    public HasMatcher getHasMatcher() {
        return hasMatcher;
    }

    public void setHasMatcher(HasMatcher hasMatcher) {
        this.hasMatcher = hasMatcher;
    }

    public DoesNotHaveMatcher getDoesNotHaveMatcher() {
        return doesNotHaveMatcher;
    }

    public void setDoesNotHaveMatcher(DoesNotHaveMatcher doesNotHaveMatcher) {
        this.doesNotHaveMatcher = doesNotHaveMatcher;
    }
}
