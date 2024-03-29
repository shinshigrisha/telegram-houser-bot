package io.proj3ct.service.iml;

import io.proj3ct.dto.HomeDTO;
import io.proj3ct.entity.City;
import io.proj3ct.entity.Home;
import io.proj3ct.service.DTOToModelConvService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DTOToModelConvServiceImpl implements DTOToModelConvService {

    @Override
    public Home getHome(HomeDTO homeDTO, List<City> cityList) {
        Home home = new Home();
        home.setLink(homeDTO.getPageLink());
        home.setImageLink(homeDTO.getImageLink());
        home.setPrice(homeDTO.getPrice());
        home.setPlace(homeDTO.getPlace());
        boolean cityFound = false;
        City baku = null;
        for (City city : cityList) {
            if (city.getDescription().equals(homeDTO.getPlace())) {
                home.setCity(city);
                cityFound = true;
                break;
            }
            if (city.getDescription().equals("Bakı"))
                baku = city;
        }
        if (!cityFound) {
            home.setCity(baku);
        }
        home.setCategory(homeDTO.getCategory());
        home.setStage(homeDTO.getStage());
        home.setNumberOfRoom(homeDTO.getNumberOfRoom());
        home.setArea(homeDTO.getArea());
        home.setTags(homeDTO.getTags());
        home.setInfo(homeDTO.getInfo());
        return home;
    }

}
