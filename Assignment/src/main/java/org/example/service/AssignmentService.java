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

public class AssignmentService {

    public static String fetchApiAndGetUniquePost(String url) {

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

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result != null ? result : "";
    }

    public static int countEachCharacter(String finalString) {
        String post = finalString.replaceAll("\n", "").replaceAll("\\s", "").toLowerCase();
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < post.length(); i++) {
            mp.put(post.charAt(i), mp.getOrDefault(post.charAt(i), 0) + 1);
        }
        int count = 0;
        int uniqueCharactersInBody = 0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > 1) {
                count++;
                System.out.println(entry.getKey() + ":" + entry.getValue());
            } else if (entry.getValue() == 1) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                uniqueCharactersInBody++;
                count++;
            }
        }

        //we can do with JAVA 8 but above one is optimized since we are only iterating once.

//        int count = (int) mp.values().stream()
//                .filter(value -> value > 1)
//                .count();
//
//        int uniqueCharactersInBody = (int) mp.values().stream()
//                .filter(value -> value == 1)
//                .count();
//
//        mp.entrySet().stream()
//                .filter(entry -> entry.getValue() >= 1)
//                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

        System.out.println("Total characters found in the body: = " + count);
        System.out.println("Unique Characters which occurrence is 1 i.e. non-repeating = " + uniqueCharactersInBody);

        return count;
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
