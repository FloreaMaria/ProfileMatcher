package com.example.profilematcher.service.impl;

import com.example.profilematcher.exception.EmptyFieldException;
import com.example.profilematcher.model.campaign.*;
import com.example.profilematcher.model.campaign.dto.CampaignDto;
import com.example.profilematcher.model.campaign.elasticsearch.*;
import com.example.profilematcher.repository.CampaignRepository;
import com.example.profilematcher.repository.ElasticsearchCampaignRepository;
import com.example.profilematcher.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {

    private final ElasticsearchCampaignRepository elasticsearchCampaignRepository;
    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignServiceImpl(ElasticsearchCampaignRepository elasticsearchCampaignRepository, CampaignRepository campaignRepository, RestTemplate restTemplate) {
        this.elasticsearchCampaignRepository = elasticsearchCampaignRepository;
        this.campaignRepository = campaignRepository;
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
    public Campaign save(CampaignDto campaignDto) throws ParseException {
        String game = campaignDto.getGame();
        String name = campaignDto.getName();
        Double priority = campaignDto.getPriority();
        String startDate = campaignDto.getStartDate();
        String endDate = campaignDto.getEndDate();
        String lastUpdate = campaignDto.getLastUpdated();
        Boolean enabled = campaignDto.getEnabled();

        if(game == null || game.isEmpty()){
            throw new EmptyFieldException("Game field can not be null or empty");
        }
        if(name == null || name.isEmpty()){
            throw new EmptyFieldException("Name field can not be null or empty");
        }
        if(priority == null){
            throw new EmptyFieldException("Priority field can not be null");
        }
        if(startDate == null || startDate.isEmpty()){
            throw new EmptyFieldException("Start date field can not be null or empty");
        }
        if(endDate == null || endDate.isEmpty()){
            throw new EmptyFieldException("End date field can not be null or empty");
        }
        if(enabled == null){
            throw new EmptyFieldException("Enabled field can not be null");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRANCE);
        Date startDateFormatted = formatter.parse(startDate);
        Date endDateFormatted = formatter.parse(endDate);
        Date lastUpdateFormatted = formatter.parse(lastUpdate);

        CampaignMatcher campaignMatcher = campaignDto.getMatchers();
        Campaign campaign = new Campaign(UUID.randomUUID(),
                game,
                name,
                priority,
                campaignMatcher,
                startDateFormatted,
                endDateFormatted,
                enabled,
                lastUpdateFormatted
                );
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
