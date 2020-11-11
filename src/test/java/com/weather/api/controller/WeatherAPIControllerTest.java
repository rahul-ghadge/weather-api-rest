package com.weather.api.controller;

import com.weather.api.exception.handler.InvalidZipcodeException;
import com.weather.api.service.WeatherAPIService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherAPIControllerTest {

    @InjectMocks
    private WeatherAPIController controller;

    @Mock
    private WeatherAPIService service;

    @Test
    public void redirectTest() {
        ResponseEntity<Void> responseEntity = controller.redirect();

        Assert.assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
    }



    @Test
    public void getWeatherForecastZipcodeSuccessTest() {

        Map<String, Double> map = new HashMap<>();

        when(service.getWeatherForecast(anyLong())).thenReturn(map);
        ResponseEntity<Map<String, Double>> responseEntity = controller.getWeatherForecastZipcode("123456");

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


    @Test(expected = InvalidZipcodeException.class)
    public void getWeatherForecastZipcodeFailureTest() {
        ResponseEntity<Map<String, Double>> responseEntity = controller.getWeatherForecastZipcode("1234");
    }
}
