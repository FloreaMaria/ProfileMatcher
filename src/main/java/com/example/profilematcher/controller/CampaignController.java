package com.example.profilematcher.controller;

import com.example.profilematcher.model.campaign.*;
import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import com.example.profilematcher.service.impl.CampaignServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

        countries.add("FR");
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
    public  Iterable<CampaignElasticSearch> searchCampaigns(
//            @RequestParam int myLevel,
//            @RequestParam List<String> country,
//            @RequestParam List<String> myItems,
//            @RequestParam List<String> notInItems
    ) throws JsonProcessingException {
        List<String> myItems = new ArrayList<>();
        myItems.add("item_1");
        myItems.add("item_2");
        myItems.add("item_3");
        String country = "FR";
        List<String> itemList = Arrays.asList("item_1", "item_2", "item_3");
        String jsonItems = new ObjectMapper().writeValueAsString(myItems);
        Iterable<CampaignElasticSearch> campaigns = campaignService.findCampaignsByConditions(1L, country, jsonItems);
        return campaigns;
    }

//    @PostMapping(value = "all")
//    public Iterable<Campaign> getAllAvailableCampaigns(){
//
//        return campaignService.findAll();
//    }
}
