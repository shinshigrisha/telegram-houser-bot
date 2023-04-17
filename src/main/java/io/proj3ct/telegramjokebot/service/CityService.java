package io.proj3ct.telegramjokebot.service;


import io.proj3ct.telegramjokebot.entity.City;

import java.io.IOException;
import java.util.List;

public interface CityService {

    void updateCities() throws IOException;

    List<City> getCityList();

    City getCityByCityName(String cityName);

}
