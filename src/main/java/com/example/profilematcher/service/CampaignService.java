package com.example.profilematcher.service;

import com.example.profilematcher.model.campaign.Campaign;
import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CampaignService {
    public List<CampaignElasticSearch> findCampaignsByConditions(Long myLevel, String country, List<String> myItems);
    Campaign save(Campaign campaign);
    Iterable<Campaign> findAll();


}
