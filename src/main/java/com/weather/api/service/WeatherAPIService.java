package com.weather.api.service;

import com.weather.api.model.WeatherRoot;

import java.util.Map;

public interface WeatherAPIService {

    Map<String, Double> getWeatherForecast(Long zipCode);
}
