package com.example.profilematcher.model.campaign.elasticsearch;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class LevelMatcherElasticSearch {

    @Field(type = FieldType.Text, name = "min")
    private Long min;

    @Field(type = FieldType.Text, name = "max")
    private Long max;

    public LevelMatcherElasticSearch() {
    }

    public LevelMatcherElasticSearch(Long min, Long max) {
        this.min = min;
        this.max = max;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }
}
