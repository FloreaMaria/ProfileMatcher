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
@UserDefinedType("does_not_have_matcher_type")
public class DoesNotHaveMatcher {

    @Column(value = "items")
    private List<String> items;

}
