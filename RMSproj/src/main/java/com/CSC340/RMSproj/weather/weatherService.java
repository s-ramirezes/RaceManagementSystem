package com.CSC340.RMSproj.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class weatherService {
    public weather accessWeather(String city) {
        try {
            String url = "http://api.weatherstack.com/current?access_key=c8dd3abe5be76d394f9c512b168e4385" + "&query=" + city;

            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonResponse);

            JsonNode currentWeatherNode = root.path("current");

            weather currentWeather = new weather();
            currentWeather.setCity(city);
            currentWeather.setTemp(currentWeatherNode.path("temperature").asText() + "°C");
            currentWeather.setCurrentWeather(currentWeatherNode.path("weather_descriptions").asText());
            currentWeather.setWind(currentWeatherNode.path("wind_speed").asText() + " km/h");
            currentWeather.setRainChance(currentWeatherNode.path("precip").asText() + "%");

            return currentWeather;

        } catch (JsonProcessingException ex) {
            System.out.println("Error in accessWeather");
            return null;
        }
    }
}
