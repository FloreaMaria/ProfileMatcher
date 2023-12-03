package com.example.profilematcher.model.campaign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@UserDefinedType("level_matcher_type")
public class LevelMatcher {
    @Column(value = "min")
    private Long min;

    @Column(value = "max")
    private Long max;

}
