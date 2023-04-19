package io.proj3ct.service;


import io.proj3ct.dto.HomeDTO;
import io.proj3ct.entity.City;
import io.proj3ct.entity.Home;

import java.util.List;

public interface DTOToModelConvService {

    Home getHome(HomeDTO homeDTO, List<City> cityList);

}
