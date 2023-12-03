package com.example.profilematcher.model.campaign.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelMatcherElasticSearch {

    @Field(type = FieldType.Text, name = "min")
    private Long min;

    @Field(type = FieldType.Text, name = "max")
    private Long max;

}
