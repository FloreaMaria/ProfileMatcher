package com.example.profilematcher.repository;

import com.example.profilematcher.model.userprofile.UserProfile;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserProfileRepository extends CrudRepository<UserProfile, UUID>{
    UserProfile findByPlayerId(UUID id);

}
