package com.CSC340.RMSproj.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class weather {
    private String currentWeather;
    private String temp;
    private String city;
    private String wind;
    private String rainChance;
}
