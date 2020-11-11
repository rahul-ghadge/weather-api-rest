package com.weather.api.model;

import java.io.Serializable;

public class Weather implements Serializable {
    public int id;
    public String main;
    public String description;
    public String icon;
}