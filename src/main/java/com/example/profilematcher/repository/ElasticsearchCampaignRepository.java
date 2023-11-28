package com.example.profilematcher.repository;

import com.example.profilematcher.model.campaign.elasticsearch.CampaignElasticSearch;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ElasticsearchCampaignRepository extends ElasticsearchRepository<CampaignElasticSearch, String> {

    @Query("{\n" +
            "  \"bool\": {\n" +
            "    \"must\": [\n" +
            "      {\n" +
            "        \"nested\": {\n" +
            "          \"path\": \"matchers\",\n" +
            "          \"query\": {\n" +
            "            \"bool\": {\n" +
            "              \"must\": [\n" +
            "                {\"range\": {\"matchers.level.min\": {\"lte\": 2}}},\n" +
            "                {\"range\": {\"matchers.level.max\": {\"gte\": 2}}},\n" +
            "                {\"term\": {\"matchers.has.country.keyword\": \"US\"}},\n" +
            "                {\"terms\": {\"matchers.has.items.keyword\": [\"item1\"]}},\n" +
            "                {\"bool\": {\"must_not\": {\"terms\": {\"matchers.does_not_have.items.keyword\": [ \"item4\"]}}}}\n" +
            "              ]\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      },\n" +
            "      {\"term\": {\"enabled\": true}},\n" +
            "      {\n" +
            "        \"bool\": {\n" +
            "          \"must\": [\n" +
            "            {\"range\": {\"start_date\": {\"lte\": \"now\"}}},\n" +
            "            {\"range\": {\"end_date\": {\"gte\": \"now\"}}}\n" +
            "          ]\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}\n")
    List<CampaignElasticSearch> findCampaignsByConditions(

    );

    List<CampaignElasticSearch> findAll();


}
