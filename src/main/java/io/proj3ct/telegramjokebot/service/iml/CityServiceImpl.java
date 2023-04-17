package io.proj3ct.telegramjokebot.service.iml;


import io.proj3ct.telegramjokebot.entity.City;
import io.proj3ct.telegramjokebot.repository.CityRepository;
import io.proj3ct.telegramjokebot.service.CityService;
import io.proj3ct.telegramjokebot.service.ScrapService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final ScrapService scrapService;

    public CityServiceImpl(CityRepository cityRepository, ScrapService scrapService) {
        this.cityRepository = cityRepository;
        this.scrapService = scrapService;
    }

    @Transactional
    @Override
    public void updateCities() throws IOException {
        List<String> cityList = scrapService.getCities();
        long numberOfCity = cityRepository.countCities();
        if (numberOfCity > 0) {
            cityRepository.deactiveCities();
            cityList.stream().forEach(item -> {
                City city = cityRepository.getCityByDescription(item);
                if (city != null) {
                    city.setActive(true);
                } else {
                    city = new City();
                    city.setDescription(item);
                }
                cityRepository.save(city);
            });
        } else {
            cityList.stream().forEach(item -> {
                City city = new City();
                city.setDescription(item);
                city.setActive(true);
                cityRepository.save(city);
            });
        }
    }

    @Override
    public List<City> getCityList() {
        return cityRepository.getCities();
    }

    @Override
    public City getCityByCityName(String cityName) {
        return cityRepository.getCityByDescription(cityName);
    }
}
