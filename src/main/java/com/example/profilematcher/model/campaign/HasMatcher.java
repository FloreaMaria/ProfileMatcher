package com.example.profilematcher.model.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@UserDefinedType("has_matcher_type")
public class HasMatcher {
    @Column(value = "country")
    private List<String> country;

    @Column(value = "items")
    private List<String> items;

}
