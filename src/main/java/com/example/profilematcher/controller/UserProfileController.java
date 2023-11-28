package com.example.profilematcher.controller;

import com.example.profilematcher.model.userprofile.ActiveCampaign;
import com.example.profilematcher.model.userprofile.Clan;
import com.example.profilematcher.model.userprofile.Device;
import com.example.profilematcher.model.userprofile.UserProfile;
import com.example.profilematcher.service.impl.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping(value = "user_profile/")
public class UserProfileController {

    private final UserProfileServiceImpl userProfileService;

    @Autowired
    public UserProfileController(UserProfileServiceImpl userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping(value = "get_client_config/{player_id}")
    public ResponseEntity<UserProfile> getClientConfig(@PathVariable("player_id") UUID playerId){
        UserProfile userProfile = userProfileService.getClientConfig(playerId);
        return ResponseEntity.ok(userProfile);
    }
    @PostMapping(value = "save")
    public ResponseEntity<UserProfile> save(){
        Date created = new Date();
        Date modified = new Date();
        Date lastSession = new Date();
        Date lastPurchase = new Date();
        Date birthDate = new Date();
        Clan clan = new Clan(123456L, "Hello world clan");
        UserProfile userProfile = new UserProfile(
                UUID.randomUUID(),
                "apple_credential",
                created,
                modified,
                lastSession,
                400,
                0,
                5,
                lastPurchase,
                3,
                1000,
                144,
                "CA",
                "fr",
                birthDate,
                "male",
                new HashMap<String, Integer>(),
                "mycustom",
                new HashMap<String, Integer>(),
                new ArrayList<Device>(),
                new ArrayList<ActiveCampaign>()
                );

        UserProfile savedUserProfile = userProfileService.save(userProfile);
        return ResponseEntity.ok(savedUserProfile);
    }
}
