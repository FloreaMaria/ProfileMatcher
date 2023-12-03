package com.example.profilematcher.model.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@UserDefinedType("campaign_matcher_type")
public class CampaignMatcher {

    @Column(value = "level")
    private LevelMatcher levelMatcher;

    @Column(value = "has")
    private HasMatcher hasMatcher;

    @Column(value = "does_not_have")
    private DoesNotHaveMatcher doesNotHaveMatcher;
}
