package com.example.profilematcher.model.campaign.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class CampaignMatcherElasticSearch {

    @Field(type = FieldType.Nested, name = "level")
    private LevelMatcherElasticSearch levelMatcher;

    @Field(type = FieldType.Nested, name = "has")
    private HasMatcherElasticSearch hasMatcher;

    @Field(type = FieldType.Nested, name = "does_not_have")
    private DoesNotHaveMatcherElasticSearch doesNotHaveMatcher;

    public CampaignMatcherElasticSearch() {
    }

    public CampaignMatcherElasticSearch(LevelMatcherElasticSearch levelMatcher, HasMatcherElasticSearch hasMatcher, DoesNotHaveMatcherElasticSearch doesNotHaveMatcher) {
        this.levelMatcher = levelMatcher;
        this.hasMatcher = hasMatcher;
        this.doesNotHaveMatcher = doesNotHaveMatcher;
    }

    public LevelMatcherElasticSearch getLevelMatcher() {
        return levelMatcher;
    }

    public void setLevelMatcher(LevelMatcherElasticSearch levelMatcher) {
        this.levelMatcher = levelMatcher;
    }

    public HasMatcherElasticSearch getHasMatcher() {
        return hasMatcher;
    }

    public void setHasMatcher(HasMatcherElasticSearch hasMatcher) {
        this.hasMatcher = hasMatcher;
    }

    public DoesNotHaveMatcherElasticSearch getDoesNotHaveMatcher() {
        return doesNotHaveMatcher;
    }

    public void setDoesNotHaveMatcher(DoesNotHaveMatcherElasticSearch doesNotHaveMatcher) {
        this.doesNotHaveMatcher = doesNotHaveMatcher;
    }
}
