package com.weather.api.model;

import java.io.Serializable;
import java.util.List;

public class WeatherRoot implements Serializable {
    public String cod;
    public int message;
    public int cnt;
    public List<ListData> list;
    public City city;
}