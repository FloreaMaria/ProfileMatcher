package com.example.profilematcher.model.campaign.elasticsearch;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

public class DoesNotHaveMatcherElasticSearch {

    @Field(type = FieldType.Text, name = "items")
    private List<String> items;

    public DoesNotHaveMatcherElasticSearch() {
    }

    public DoesNotHaveMatcherElasticSearch(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
