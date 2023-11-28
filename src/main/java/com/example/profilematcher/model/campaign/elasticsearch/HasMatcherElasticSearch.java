package com.example.profilematcher.model.campaign.elasticsearch;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;


public class HasMatcherElasticSearch {

    @Field(type = FieldType.Text, name = "country")
    private List<String> country;

    @Field(type = FieldType.Text, name = "items")
    private List<String> items;

    public HasMatcherElasticSearch() {
    }

    public HasMatcherElasticSearch(List<String> country, List<String> items) {
        this.country = country;
        this.items = items;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
