package com.example.profilematcher.controller;

import com.example.profilematcher.model.campaign.*;
import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import com.example.profilematcher.service.impl.CampaignServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "campaign/")
public class CampaignController {

    private final CampaignServiceImpl campaignService;

    @Autowired
    public CampaignController(CampaignServiceImpl campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping(value = "save")
    public ResponseEntity<Campaign> save(){
        LevelMatcher levelMatcher = new LevelMatcher(1L, 3L);

        List<String> countries = new ArrayList<>();
        countries.add("US");
        countries.add("RO");
        countries.add("CA");
        List<String> requiredItems = new ArrayList<>();
        requiredItems.add("item_1");
        HasMatcher hasMatcher = new HasMatcher(countries, requiredItems);

        List<String> notRequiredItems = new ArrayList<>();
        notRequiredItems.add("item_4");
        DoesNotHaveMatcher doesNotHaveMatcher = new DoesNotHaveMatcher(notRequiredItems);

        Date startDate = new Date();
        Date endDate = new Date();
        Boolean enabled = true;
        Date lastUpdated = new Date();


        CampaignMatcher campaignMatcher = new CampaignMatcher(
                levelMatcher,
                hasMatcher,
                doesNotHaveMatcher
        );

        Campaign campaign = new Campaign(
                UUID.randomUUID(),
                "mygame",
                "mycampaign",
                10.5,
                campaignMatcher,
                startDate,
                endDate,
                enabled,
                lastUpdated
        );

        Campaign savedCampaign = campaignService.save(campaign);
        return ResponseEntity.ok(savedCampaign);
    }


    @GetMapping("/search")
    public ResponseEntity<List<CampaignElasticSearch>> searchCampaigns(
//            @RequestParam int myLevel,
//            @RequestParam List<String> country,
//            @RequestParam List<String> myItems,
//            @RequestParam List<String> notInItems
    ) {
        List<String> myItems = new ArrayList<>();
        myItems.add("item_1");
        myItems.add("item_2");
        myItems.add("item_3");
        String country = "CA";
        List<CampaignElasticSearch> campaigns = campaignService.findCampaignsByConditions(3L, country,
                myItems);
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

    @PostMapping(value = "all")
    public Iterable<Campaign> getAllAvailableCampaigns(){

        return campaignService.findAll();
    }
}
