package com.example.profilematcher.service.impl;

import com.example.profilematcher.model.campaign.Campaign;
import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import com.example.profilematcher.model.userprofile.ActiveCampaign;
import com.example.profilematcher.model.userprofile.Device;
import com.example.profilematcher.model.userprofile.UserProfile;
import com.example.profilematcher.model.userprofile.dto.UserProfileDto;
import com.example.profilematcher.repository.UserProfileRepository;
import com.example.profilematcher.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public UserProfile save(UserProfileDto userProfileDto) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRANCE);

        String credential = userProfileDto.getCredential();
        String created = userProfileDto.getCreated();
        String modified = userProfileDto.getModified();
        String lastSession = userProfileDto.getLastSession();
        Integer totalSpent = userProfileDto.getTotalSpent();
        Integer totalRefund = userProfileDto.getTotalRefund();
        Integer totalTransactions = userProfileDto.getTotalTransactions();
        Integer level = userProfileDto.getLevel();
        Integer xp = userProfileDto.getXp();
        Integer totalPlayTime = userProfileDto.getTotalPlayTime();
        String country = userProfileDto.getCountry();
        String language = userProfileDto.getLanguage();
        String gender = userProfileDto.getGender();
        String customField = userProfileDto.getCustomField();
        String lastPurchase = userProfileDto.getLastPurchase();
        String birthDate = userProfileDto.getBirthDate();
        Map<String, String> clan = userProfileDto.getClan();
        Map<String, Integer> inventory = userProfileDto.getInventory();
        List<Device> devices = userProfileDto.getDevices();

        Date createdDate = formatter.parse(created);
        Date modifiedDate = formatter.parse(modified);
        Date lastSessionDate = formatter.parse(lastSession);
        Date lastPurchaseDate =  formatter.parse(lastPurchase);
        Date birthDateDate = formatter.parse(birthDate);
        UserProfile userProfile = new UserProfile(
                UUID.randomUUID(),
                credential,
                createdDate,
                modifiedDate,
                lastSessionDate,
                totalSpent,
                totalRefund,
                totalTransactions,
                lastPurchaseDate,
                level,
                xp,
                totalPlayTime,
                country,
                language,
                birthDateDate,
                gender,
                inventory,
                customField,
                clan,
                devices,
                new ArrayList<ActiveCampaign>()
        );
        return this.userProfileRepository.save(userProfile);
    }

    @Override
    public Iterable<UserProfile> all() {
        return this.userProfileRepository.findAll();
    }
}
