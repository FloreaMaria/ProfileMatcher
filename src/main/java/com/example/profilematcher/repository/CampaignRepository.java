package com.example.profilematcher.repository;

import com.example.profilematcher.model.campaign.Campaign;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CampaignRepository extends CrudRepository<Campaign, UUID> {
    Campaign findByCampaignId(UUID campaignId);

    @Query(value = "select * from campaign;")
    Iterable<Campaign> findAll();
}
