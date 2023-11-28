package com.example.profilematcher.model.campaign;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@UserDefinedType("does_not_have_matcher_type")
public class DoesNotHaveMatcher {
    @Column(value = "items")
    private List<String> items;

    public DoesNotHaveMatcher() {
    }

    public DoesNotHaveMatcher(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
