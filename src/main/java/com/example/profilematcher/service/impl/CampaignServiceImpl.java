package com.example.profilematcher.service.impl;

import com.example.profilematcher.model.campaign.Campaign;
import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import com.example.profilematcher.repository.CampaignRepository;
import com.example.profilematcher.repository.ElasticsearchCampaignRepository;
import com.example.profilematcher.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;


import java.util.*;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {

    private final ElasticsearchCampaignRepository elasticsearchCampaignRepository;
    private final CampaignRepository campaignRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CampaignServiceImpl(ElasticsearchCampaignRepository elasticsearchCampaignRepository, CampaignRepository campaignRepository, RestTemplate restTemplate) {
        this.elasticsearchCampaignRepository = elasticsearchCampaignRepository;
        this.campaignRepository = campaignRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public List<CampaignElasticSearch> findCampaignsByConditions(Long myLevel, String country, List<String> myItems) {
        return elasticsearchCampaignRepository.findAll();
    }
    @Override
    public Iterable<Campaign> findAll() {
        return campaignRepository.findAll();
    }
    @Override
    public Campaign save(Campaign campaign) {
        return this.campaignRepository.save(campaign);
    }
}
