package com.weather.api.model;

import java.io.Serializable;

public class City implements Serializable {
    public int id;
    public String name;
    public Coord coord;
    public String country;
    public int population;
    public int timezone;
    public int sunrise;
    public int sunset;
}