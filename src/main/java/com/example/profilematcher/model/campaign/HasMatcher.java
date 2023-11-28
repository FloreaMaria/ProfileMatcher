package com.example.profilematcher.model.campaign;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import java.util.List;

@UserDefinedType("has_matcher_type")
public class HasMatcher {
    @Column(value = "country")
    private List<String> country;

    @Column(value = "items")
    private List<String> items;

    public HasMatcher() {
    }

    public HasMatcher(List<String> country, List<String> items) {
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
