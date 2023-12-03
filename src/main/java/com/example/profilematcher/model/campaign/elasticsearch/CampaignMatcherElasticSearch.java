package com.example.profilematcher.model.campaign.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignMatcherElasticSearch {

    @Field(type = FieldType.Nested, name = "level")
    private LevelMatcherElasticSearch levelMatcher;

    @Field(type = FieldType.Nested, name = "has")
    private HasMatcherElasticSearch hasMatcher;

    @Field(type = FieldType.Nested, name = "does_not_have")
    private DoesNotHaveMatcherElasticSearch doesNotHaveMatcher;

}
