package com.example.profilematcher.controller;

import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import com.example.profilematcher.model.userprofile.ActiveCampaign;
import com.example.profilematcher.model.userprofile.Clan;
import com.example.profilematcher.model.userprofile.Device;
import com.example.profilematcher.model.userprofile.UserProfile;
import com.example.profilematcher.model.userprofile.dto.UserProfileDto;
import com.example.profilematcher.service.impl.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping(value = "user_profile/")
public class UserProfileController {

    private final UserProfileServiceImpl userProfileService;

    @Autowired
    public UserProfileController(UserProfileServiceImpl userProfileService) {
        this.userProfileService = userProfileService;
    }

//    @GetMapping(value = "get_client_config/{player_id}")
//    public ResponseEntity<UserProfile> getClientConfig(@PathVariable("player_id") UUID playerId){
//        UserProfile userProfile = userProfileService.getClientConfig(playerId);
//        return ResponseEntity.ok(userProfile);
//    }

    @GetMapping(value = "get_client_config/{player_id}")
    public ResponseEntity<UserProfile> getClientConfig(@PathVariable("player_id") UUID playerId){
        UserProfile userProfile = userProfileService.getClientConfig(playerId);
        return ResponseEntity.ok(userProfile);
    }
    @GetMapping(value = "all")
    public Iterable<UserProfile> getAll(){
        return userProfileService.all();
    }

//    @PostMapping(value = "save")
//    public ResponseEntity<UserProfile> save(){
//
//        Date created = new Date();
//        Date modified = new Date();
//        Date lastSession = new Date();
//        Date lastPurchase = new Date();
//        Date birthDate = new Date();
////        Clan clan = new Clan(123456L, "Hello world clan");
//        Map<String, String> clan = new HashMap<>();
//        clan.put("id", "12131");
//        clan.put("name", "Hello world clan");
//        Map<String, Integer> inventory = new HashMap<>();
//        inventory.put("cash", 121);
//        inventory.put("coins", 123);
//        inventory.put("item_1", 1);
//        inventory.put("item_34", 3);
//        inventory.put("item_55", 2);
//        Device device = new Device(1L, "apple iphone11", "vodafone", "123");
//        List<Device> devices = new ArrayList<>();
//        devices.add(device);
//        UserProfile userProfile = new UserProfile(
//                UUID.randomUUID(),
//                "apple_credential",
//                created,
//                modified,
//                lastSession,
//                400,
//                0,
//                5,
//                lastPurchase,
//                3,
//                1000,
//                144,
//                "FR",
//                "fr",
//                birthDate,
//                "male",
//                inventory,
//                "mycustom",
//                clan,
//                devices,
//                new ArrayList<ActiveCampaign>()
//                );
//
//        UserProfile savedUserProfile = userProfileService.save(userProfile);
//        return ResponseEntity.ok(savedUserProfile);
//    }
    @PostMapping(value = "save")
    public ResponseEntity<UserProfile> saveUserProfile(@RequestBody UserProfileDto userProfileDto) throws ParseException {

        UserProfile savedUserProfile = userProfileService.save(userProfileDto);
        return ResponseEntity.ok(savedUserProfile);
    }
}
