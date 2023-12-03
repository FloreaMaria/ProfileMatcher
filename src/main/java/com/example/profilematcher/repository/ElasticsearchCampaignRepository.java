package com.example.profilematcher.repository;

import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface ElasticsearchCampaignRepository extends ElasticsearchRepository<CampaignElasticSearch, UUID> {
//
//    @Query("{\n" +
//            "  \"bool\": {\n" +
//            "    \"must\": [\n" +
//            "      {\n" +
//            "        \"nested\": {\n" +
//            "          \"path\": \"matchers\",\n" +
//            "          \"query\": {\n" +
//            "            \"bool\": {\n" +
//            "              \"must\": [\n" +
//            "                {\"range\": {\"matchers.level.min\": {\"lte\": 2}}},\n" +
//            "                {\"range\": {\"matchers.level.max\": {\"gte\": 2}}},\n" +
//            "                {\"term\": {\"matchers.has.country.keyword\": \"US\"}},\n" +
//            "                {\"terms\": {\"matchers.has.items.keyword\": [\"item1\"]}},\n" +
//            "                {\"bool\": {\"must_not\": {\"terms\": {\"matchers.does_not_have.items.keyword\": [ \"item4\"]}}}}\n" +
//            "              ]\n" +
//            "            }\n" +
//            "          }\n" +
//            "        }\n" +
//            "      },\n" +
//            "      {\"term\": {\"enabled\": true}},\n" +
//            "      {\n" +
//            "        \"bool\": {\n" +
//            "          \"must\": [\n" +
//            "            {\"range\": {\"start_date\": {\"lte\": \"now\"}}},\n" +
//            "            {\"range\": {\"end_date\": {\"gte\": \"now\"}}}\n" +
//            "          ]\n" +
//            "        }\n" +
//            "      }\n" +
//            "    ]\n" +
//            "  }\n" +
//            "}\n")
//    List<CampaignElasticSearch> findCampaignsByConditions(
//
//    );


//    @Query("{\n" +
//            "  \"bool\": {\n" +
//            "    \"must\": [\n" +
//            "      {\n" +
//            "        \"nested\": {\n" +
//            "          \"path\": \"matchers.has\",\n" +
//            "          \"query\": {\n" +
//            "            \"term\": {\n" +
//            "              \"matchers.has.country\": {\n" +
//            "                \"value\": \"?1\"\n" +
//            "              }\n" +
//            "            }\n" +
//            "          }\n" +
//            "        }\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"bool\": {\n" +
//            "          \"should\": [\n" +
//            "            {\n" +
//            "              \"bool\": {\n" +
//            "                \"must\": [\n" +
//            "                  {\n" +
//            "                    \"terms\": {\n" +
//            "                      \"matchers.has.items\": ?2\n" +
//            "                    }\n" +
//            "                  }\n" +
//            "                ]\n" +
//            "              }\n" +
//            "            }\n" +
//            "          ]\n" +
//            "        }\n" +
//            "      },\n" +
//            "      {\n" +
//            "        \"term\": {\n" +
//            "          \"enabled\": true\n" +
//            "        }\n" +
//            "      }\n" +
//            "    ]\n" +
//            "  }\n" +
//            "}\n")
//List<CampaignElasticSearch> findCampaignsByConditions(
//        Long myLevel,
//        String myCountry,
//        String myItems,
//        Date currentDate
//);

@Query("{\n" +
        "    \"nested\": {\n" +
        "      \"path\": \"matchers\",\n" +
        "      \"query\": {\n" +
        "        \"bool\": {\n" +
        "          \"must\": [\n" +
        "            {\n" +
        "              \"range\": {\n" +
        "                \"matchers.level.min\": {\n" +
        "                  \"lte\": ?0\n" +
        "                }\n" +
        "              }\n" +
        "            },\n" +
        "            {\n" +
        "              \"range\": {\n" +
        "                \"matchers.level.max\": {\n" +
        "                  \"gte\": ?0\n" +
        "                }\n" +
        "              }\n" +
        "            }\n" +
        "          ]\n" +
        "        }\n" +
        "      }\n" +
        "    }\n" +
        "}\n")
List<CampaignElasticSearch> findCampaignsByConditions(Long myLevel, String myCountry, List<String> myItems);



//asta merge
//
//    @Query("{\"bool\": {" +
//            "\"must\": []" +
//            "}}")
//    List<CampaignElasticSearch> findAllCampaigns();


    List<CampaignElasticSearch> findAll();
    CampaignElasticSearch save(CampaignElasticSearch campaignElasticSearch);


}
