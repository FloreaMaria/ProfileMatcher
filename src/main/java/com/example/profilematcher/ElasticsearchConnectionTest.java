package com.example.profilematcher;

import org.apache.http.HttpHost;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ElasticsearchConnectionTest {

    public static void main(String[] args) {
        testElasticsearchConnection();
    }

    private static void testElasticsearchConnection() {
        try {
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost", 9200, "http")));

            Request request = new Request("HEAD", "/campaign_index"); // replace "your_index" with your actual index
            Response response = client.getLowLevelClient().performRequest(request);

            // Check the response and headers
            System.out.println("Status Code: " + response.getStatusLine().getStatusCode());
            System.out.println("Headers: " + response.getHeaders().toString());
            System.out.println("Headers:");
            for (org.apache.http.Header header : response.getHeaders()) {
                System.out.println(header.getName() + ": " + header.getValue());
            }

            client.close(); // close the client when done
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
