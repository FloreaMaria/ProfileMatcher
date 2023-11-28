package com.example.profilematcher.repository;

import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
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


//@Query("{\n" +
//        "  \"query\": {\n" +
//        "    \"bool\": {\n" +
//        "      \"must\": [\n" +
//        "        {\n" +
//        "          \"range\": {\n" +
//        "            \"matchers.level.min\": {\"lte\": myLevel}\n" +
//        "          }\n" +
//        "        },\n" +
//        "        {\n" +
//        "          \"range\": {\n" +
//        "            \"matchers.level.max\": {\"gte\": myLevel}\n" +
//        "          }\n" +
//        "        },\n" +
//        "        {\n" +
//        "          \"terms\": {\n" +
//        "            \"matchers.has.country.keyword\": myCountry\n" +
//        "          }\n" +
//        "        },\n" +
//        "        {\n" +
//        "          \"bool\": {\n" +
//        "            \"should\": [\n" +
//        "              {\n" +
//        "                \"bool\": {\n" +
//        "                  \"must\": [\n" +
//        "                    {\n" +
//        "                      \"terms\": {\n" +
//        "                        \"matchers.has.items.keyword\": myItems\n" +
//        "                      }\n" +
//        "                    },\n" +
//        "                    {\n" +
//        "                      \"bool\": {\n" +
//        "                        \"must_not\": [\n" +
//        "                          {\n" +
//        "                            \"terms\": {\n" +
//        "                              \"matchers.does_not_have.items.keyword\": myItems\n" +
//        "                            }\n" +
//        "                          }\n" +
//        "                        ]\n" +
//        "                      }\n" +
//        "                    }\n" +
//        "                  ]\n" +
//        "                }\n" +
//        "              }\n" +
//        "            ]\n" +
//        "          }\n" +
//        "        },\n" +
//        "        {\n" +
//        "          \"term\": {\n" +
//        "            \"enabled\": true\n" +
//        "          }\n" +
//        "        },\n" +
//        "        {\n" +
//        "          \"bool\": {\n" +
//        "            \"must\": [\n" +
//        "              {\n" +
//        "                \"range\": {\n" +
//        "                  \"start_date\": {\"lte\": currentDate}\n" +
//        "                }\n" +
//        "              },\n" +
//        "              {\n" +
//        "                \"range\": {\n" +
//        "                  \"end_date\": {\"gte\": currentDate}\n" +
//        "                }\n" +
//        "              }\n" +
//        "            ]\n" +
//        "          }\n" +
//        "        }\n" +
//        "      ]\n" +
//        "    }\n" +
//        "  }\n" +
//        "}\n")
//List<CampaignElasticSearch> findCampaignsByConditions(
//        Long myLevel,
//        String myCountry,
//        String myItems,
//        Date currentDate
//);
@Query("{\n" +
        "  \"bool\": {\n" +
        "    \"must\": [\n" +
        "      {\"range\": {\"matchers.level.min\": {\"lte\": ?0}}},\n" +
        "      {\"range\": {\"matchers.level.max\": {\"gte\": ?0}}},\n" +
        "      {\"nested\": {\n" +
        "         \"path\": \"matchers.has\",\n" +
        "         \"query\": {\n" +
        "            \"terms\": {\" matchers.has.country.keyword\": [\"?1\"]\n" +
        "        }" +
        "         }\n" +
        "      }},\n" +
        "      {\n" +
        "        \"bool\": {\n" +
        "          \"should\": [\n" +
        "            {\n" +
        "              \"bool\": {\n" +
        "                \"must\": [\n" +
        "                  {\"terms\": {\"matchers.has.items.keyword\": ?2}},\n" +
        "                  {\n" +
        "                    \"bool\": {\n" +
        "                      \"must_not\": [\n" +
        "                        {\"terms\": {\"matchers.does_not_have.items.keyword\": ?2}}\n" +
        "                      ]\n" +
        "                    }\n" +
        "                  }\n" +
        "                ]\n" +
        "              }\n" +
        "            }\n" +
        "          ]\n" +
        "        }\n" +
        "      },\n" +
        "      {\"term\": {\"enabled\": true}},\n" +
        "      {\"range\": {\"start_date\": {\"lte\": \"?3\"}}},\n" +
        "      {\"range\": {\"end_date\": {\"gte\": \"?3\"}}}\n" +
        "    ]\n" +
        "  }\n" +
        "}")
List<CampaignElasticSearch> findCampaignsByConditions(
        Long myLevel,
        String myCountry,
        String myItems,
        Date currentDate
);




    List<CampaignElasticSearch> findAll();
    CampaignElasticSearch save(CampaignElasticSearch campaignElasticSearch);


}
