package com.weather.api.service;

import com.weather.api.model.response.WeatherAPIResponse;

public interface WeatherAPIService {

    WeatherAPIResponse getWeatherForecast(Long zipCode);
}
