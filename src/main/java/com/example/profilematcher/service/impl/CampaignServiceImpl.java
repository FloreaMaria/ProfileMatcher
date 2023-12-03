package com.example.profilematcher.service.impl;

import com.example.profilematcher.model.campaign.*;
import com.example.profilematcher.model.campaign.elasticsearch.*;
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
        return elasticsearchCampaignRepository.findCampaignsByConditions(myLevel, country, myItems);
    }
    @Override
    public Iterable<Campaign> findAll() {

        return campaignRepository.findAll();
    }
    @Override
    public Campaign save(Campaign campaign) {

        CampaignElasticSearch elasticsearchCampaign = convertToElasticsearchModel(campaign);
        elasticsearchCampaignRepository.save(elasticsearchCampaign);

        return this.campaignRepository.save(campaign);
    }
    public static CampaignElasticSearch convertToElasticsearchModel(Campaign campaign) {
        CampaignElasticSearch elasticsearchCampaign = new CampaignElasticSearch();
        elasticsearchCampaign.setCampaignId(campaign.getCampaignId());
        elasticsearchCampaign.setGame(campaign.getGame());
        elasticsearchCampaign.setName(campaign.getName());
        elasticsearchCampaign.setPriority(campaign.getPriority());
        elasticsearchCampaign.setMatchers(convertToElasticsearchMatcherModel(campaign.getMatchers()));
        elasticsearchCampaign.setStartDate(campaign.getStartDate());
        elasticsearchCampaign.setEndDate(campaign.getEndDate());
        elasticsearchCampaign.setEnabled(campaign.getEnabled());
        elasticsearchCampaign.setLastUpdated(campaign.getLastUpdated());

        return elasticsearchCampaign;
    }
    private static CampaignMatcherElasticSearch convertToElasticsearchMatcherModel(CampaignMatcher campaignMatcher) {
        if (campaignMatcher == null) {
            return null;
        }
        CampaignMatcherElasticSearch elasticsearchMatcher = new CampaignMatcherElasticSearch();
        LevelMatcherElasticSearch levelMatcherElasticSearch = convertToElasticsearchLevelMatcherModel(campaignMatcher.getLevelMatcher());
        elasticsearchMatcher.setLevelMatcher(levelMatcherElasticSearch);

        HasMatcherElasticSearch hasMatcherElasticSearch = convertToElasticsearchHasMatcherModel(campaignMatcher.getHasMatcher());
        elasticsearchMatcher.setHasMatcher(hasMatcherElasticSearch);

        DoesNotHaveMatcherElasticSearch doesNotHaveMatcherElasticSearch = convertToElasticsearchDoesNotHaveMatcherModel(campaignMatcher.getDoesNotHaveMatcher());
        elasticsearchMatcher.setDoesNotHaveMatcher(doesNotHaveMatcherElasticSearch);

        return elasticsearchMatcher;
    }
    private static LevelMatcherElasticSearch convertToElasticsearchLevelMatcherModel(LevelMatcher levelMatcher) {
        if (levelMatcher == null) {
            return null;
        }
        return new LevelMatcherElasticSearch(levelMatcher.getMin(), levelMatcher.getMax());
    }
    private static HasMatcherElasticSearch convertToElasticsearchHasMatcherModel(HasMatcher hasMatcher) {
        if (hasMatcher == null) {
            return null;
        }
        return new HasMatcherElasticSearch(hasMatcher.getCountry(), hasMatcher.getItems());
    }
    private static DoesNotHaveMatcherElasticSearch convertToElasticsearchDoesNotHaveMatcherModel(DoesNotHaveMatcher doesNotHaveMatcher) {
        if (doesNotHaveMatcher == null) {
            return null;
        }
        return new DoesNotHaveMatcherElasticSearch(doesNotHaveMatcher.getItems());
    }




}
