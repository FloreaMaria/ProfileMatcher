package com.example.profilematcher.service;

import com.example.profilematcher.model.campaign.Campaign;
import com.example.profilematcher.model.campaign.dto.CampaignDto;
import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;

import java.text.ParseException;
import java.util.List;

public interface CampaignService {
    List<CampaignElasticSearch> findCampaignsByConditions(Long myLevel, String country, List<String> myItems);
    Campaign save(CampaignDto campaignDto) throws ParseException;
    Iterable<Campaign> findAll();


}
