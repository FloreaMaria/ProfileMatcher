package com.example.profilematcher.model.campaign.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoesNotHaveMatcherElasticSearch {

    @Field(type = FieldType.Text, name = "items")
    private List<String> items;

}
