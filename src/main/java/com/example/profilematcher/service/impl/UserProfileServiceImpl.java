package com.example.profilematcher.service.impl;

import com.example.profilematcher.model.campaign.Campaign;
import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import com.example.profilematcher.model.userprofile.ActiveCampaign;
import com.example.profilematcher.model.userprofile.UserProfile;
import com.example.profilematcher.repository.UserProfileRepository;
import com.example.profilematcher.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final CampaignServiceImpl campaignService;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, CampaignServiceImpl campaignService) {
        this.userProfileRepository = userProfileRepository;
        this.campaignService = campaignService;
    }

//    @Override
//    public UserProfile getClientConfig(UUID playerId) {
//        return this.userProfileRepository.findByPlayerId(playerId);
//    }

    @Override
    public UserProfile getClientConfig(UUID playerId) {
        //retrieve the user player by id
        UserProfile userProfile = this.userProfileRepository.findByPlayerId(playerId);

        //clear the lists with the current active campaigns
        if(userProfile.getActiveCampaigns() != null){
            userProfile.getActiveCampaigns().clear();
        }

        //create a list of the items he has in inventory
        List<String> userItems = new ArrayList<>();
        Map<String, Integer> inventory = userProfile.getInventory();
        for (String key : inventory.keySet()) {
            userItems.add(String.valueOf(key));
        }
        //retrieve his level, country
        int userLevel = userProfile.getLevel();
        String userCountry = userProfile.getCountry();

        //retrieve all the current campaigns
        Iterable<Campaign> campaigns = campaignService.findAll();
        List<ActiveCampaign> userCampaigns = new ArrayList<>();

        //filter them accordingly to the matchers and enabled mode
        for(Campaign c:campaigns){
            String mainString = String.join("", userItems);
            String hasSubListString = String.join("", c.getMatchers().getHasMatcher().getItems());
//            Date startDate = c.getStartDate();
//            Date endDate = c.getEndDate();
            if(c.getEnabled() && c.getMatchers().getHasMatcher().getCountry().contains(userCountry) &&
                    mainString.contains(hasSubListString) &&
                    Collections.disjoint(userItems,  c.getMatchers().getDoesNotHaveMatcher().getItems())&&
            userLevel >= c.getMatchers().getLevelMatcher().getMin() && userLevel <= c.getMatchers().getLevelMatcher().getMax()){
                ActiveCampaign activeCampaign = new ActiveCampaign(c);
                userCampaigns.add(activeCampaign);
            }
        }
        userProfile.setActiveCampaigns(userCampaigns);
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return this.userProfileRepository.save(userProfile);
    }

    @Override
    public Iterable<UserProfile> all() {
        return this.userProfileRepository.findAll();
    }
}
