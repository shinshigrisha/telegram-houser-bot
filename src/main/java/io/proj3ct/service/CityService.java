package io.proj3ct.service;


import io.proj3ct.entity.City;

import java.io.IOException;
import java.util.List;

public interface CityService {

    void updateCities() throws IOException;

    List<City> getCityList();

    City getCityByCityName(String cityName);

}
