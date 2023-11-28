package com.example.profilematcher.service.impl;

import com.example.profilematcher.model.userprofile.UserProfile;
import com.example.profilematcher.repository.UserProfileRepository;
import com.example.profilematcher.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile getClientConfig(UUID playerId) {
        return this.userProfileRepository.findByPlayerId(playerId);
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return this.userProfileRepository.save(userProfile);
    }
}
