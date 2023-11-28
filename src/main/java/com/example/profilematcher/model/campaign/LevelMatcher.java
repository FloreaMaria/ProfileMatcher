package com.example.profilematcher.model.campaign;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("level_matcher_type")
public class LevelMatcher {
    @Column(value = "min")
    private Long min;

    @Column(value = "max")
    private Long max;

    public LevelMatcher() {
    }

    public LevelMatcher(Long min, Long max) {
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
