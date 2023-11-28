package com.example.profilematcher.service;

import com.example.profilematcher.model.userprofile.UserProfile;
import org.apache.catalina.User;

import java.util.UUID;

public interface UserProfileService {
    UserProfile getClientConfig(UUID playerId);
    UserProfile save(UserProfile userProfile);
}
