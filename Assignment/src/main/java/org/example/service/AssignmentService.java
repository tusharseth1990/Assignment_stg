package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.dto.Post;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AssignmentService {

    public static String fetchApiAndGetUniquePost(String url) throws IOException {

        String result = "";
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            // Create an HttpGet request with the provided URL
            HttpGet httpGet = new HttpGet(url);
            // Execute the request
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                // Check if the request was successful (status code 200)
                if (response.getStatusLine().getStatusCode() == 200) {
                    // Read the response content as a string
                    String responseBody = EntityUtils.toString(response.getEntity());
                    // Map the response to the desired object
                    ObjectMapper objectMapper = new ObjectMapper();
                    Post post = objectMapper.readValue(responseBody, Post.class);
                    result = post.getBody();
                } else {
                    System.out.println("Error: " + response.getStatusLine().getStatusCode());
                }
            }
        }
        return result != null ? result : "";
    }

    public static Map<Character, Integer> countEachCharacter(String finalString) {
        String post = finalString.replaceAll("\n", "").replaceAll("\\s", "").toLowerCase();
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < post.length(); i++) {
            mp.put(post.charAt(i), mp.getOrDefault(post.charAt(i), 0) + 1);
        }
        String result = mp.entrySet().stream()
                .filter(entry -> entry.getValue() >= 1)
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(", "));
        //we can print the map after return from this method in the main method
        System.out.println(result);
        return mp;
    }

    public static boolean isValidUrl(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
