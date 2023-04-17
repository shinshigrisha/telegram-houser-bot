package io.proj3ct.telegramjokebot.service;


import io.proj3ct.telegramjokebot.dto.HomeDTO;

import java.io.IOException;
import java.util.List;

public interface ScrapService {

    List<String> getCities() throws IOException;

    List<HomeDTO> getHomes(List<String> homeLinks) throws IOException;

}
