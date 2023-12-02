package com.CSC340.RMSproj;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class weatherService {
    public weather accessWeather(String city) {
        try {
            String apiKey = "c8dd3abe5be76d394f9c512b168e4385";
            String url = "http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + city;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonWeather = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonWeather);

            // Make sure these JSON fields match the actual response structure
            String currentWeather = root.findValue("type").asText();
            String location = root.findValue("name").asText();

            return new weather(currentWeather, location);

        } catch (Exception ex) {
            System.out.println("Error in fetching weather: " + ex.getMessage());
            return new weather("Error", "Could not fetch weather");
        }
    }
}
