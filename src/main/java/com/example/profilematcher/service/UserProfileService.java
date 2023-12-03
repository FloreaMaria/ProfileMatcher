package com.example.profilematcher.service;

import com.example.profilematcher.model.userprofile.UserProfile;
import com.example.profilematcher.model.userprofile.dto.UserProfileDto;
import org.apache.catalina.User;

import java.text.ParseException;
import java.util.UUID;

public interface UserProfileService {
    UserProfile getClientConfig(UUID playerId);
    UserProfile save(UserProfileDto userProfileDto) throws ParseException;
    Iterable<UserProfile> all();
}
