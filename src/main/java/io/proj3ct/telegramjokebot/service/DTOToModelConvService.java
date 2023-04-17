package io.proj3ct.telegramjokebot.service;


import io.proj3ct.telegramjokebot.dto.HomeDTO;
import io.proj3ct.telegramjokebot.entity.City;
import io.proj3ct.telegramjokebot.entity.Home;

import java.util.List;

public interface DTOToModelConvService {

    Home getHome(HomeDTO homeDTO, List<City> cityList);

}
