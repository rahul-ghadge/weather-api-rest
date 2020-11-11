package com.weather.api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.api.exception.handler.WeatherForecastNotFoundException;
import com.weather.api.model.ListData;
import com.weather.api.model.WeatherRoot;
import com.weather.api.service.WeatherAPIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherAPIServiceImpl implements WeatherAPIService {

    private final RestTemplate restTemplate;
    private final Environment environment;

    @Value("${weather.api.key}")
    private String key;

    @Value("${weather.api.url}")
    private String apiUrl;


    @Override
    public Map<String, Double> getWeatherForecast(Long zipcode) {

        try {
            File file = ResourceUtils.getFile("classpath:static/weather-api-response.json");
            WeatherRoot response = new ObjectMapper().readValue(file, WeatherRoot.class);

            Map<String, Double> map = getTomorrowsPredictedData(response.list);

            //getWeatherForecast1(zipcode);

            return map;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Map<String, Double> getWeatherForecast1(Long zipcode) {

        log.info("*** Getting Weather forecast for Zipcode :: {}", zipcode);

        String api = String.format(apiUrl, zipcode, key);
        WeatherRoot response = restTemplate.getForObject(api, WeatherRoot.class);
        log.info("*** Weather forecast for provided Zipcode :: {}", response);

        if (Objects.isNull(response) || CollectionUtils.isEmpty(response.list)) {
            throw new WeatherForecastNotFoundException("Weather forecast for tomorrow not found for provided zipcode");
        }

        Map<String, Double> map = getTomorrowsPredictedData(response.list);
        log.info("*** Weather forecast for tomorrow :: {}", map);

        return map;
    }


    private Map<String, Double> getTomorrowsPredictedData(List<ListData> list) {

        log.info("*** Populating Weather forecast for tomorrow");

        Map<String, Double> hourlyTemperature = new HashMap<>();
        LocalDate tomorrowsLocalDate = LocalDate.now().plusDays(1);

        list.stream().forEach(listData -> {
                    LocalDate forecastedDate = Instant.ofEpochMilli(new Date(listData.dt * 1000)
                            .getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();

                    if (tomorrowsLocalDate.getDayOfMonth() == forecastedDate.getDayOfMonth()) {
                        hourlyTemperature.put(listData.dt_txt, listData.main.temp_min);
                    }
                }
        );

        log.info("*** Populated Weather forecast for tomorrow");

        return hourlyTemperature;
    }


}
