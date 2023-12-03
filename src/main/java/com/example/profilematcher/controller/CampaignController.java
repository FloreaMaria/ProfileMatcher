package com.example.profilematcher.controller;

import com.example.profilematcher.model.campaign.*;
import com.example.profilematcher.model.campaign.dto.CampaignDto;
import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import com.example.profilematcher.service.impl.CampaignServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public ResponseEntity<Campaign> save(@RequestBody CampaignDto campaignDto) throws ParseException {
        Campaign savedCampaign = campaignService.save(campaignDto);
        return ResponseEntity.ok(savedCampaign);
    }


//    @GetMapping("/search")
//    public  Iterable<CampaignElasticSearch> searchCampaigns(
//    ) throws JsonProcessingException {
//        List<String> myItems = new ArrayList<>();
//        myItems.add("item_1");
//        myItems.add("item_2");
//        myItems.add("item_3");
//        String country = "FR";
//        List<String> itemList = Arrays.asList("item_1", "item_2", "item_3");
//        String jsonItems = new ObjectMapper().writeValueAsString(myItems);
//        Iterable<CampaignElasticSearch> campaigns = campaignService.findCampaignsByConditions(1L, country, itemList);
//        return campaigns;
//    }

    @PostMapping(value = "all")
    public Iterable<Campaign> getAllAvailableCampaigns(){

        return campaignService.findAll();
    }
}
