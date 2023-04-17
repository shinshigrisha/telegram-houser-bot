package io.proj3ct.telegramjokebot.repository;


import io.proj3ct.telegramjokebot.entity.Chat;
import io.proj3ct.telegramjokebot.entity.City;

import java.util.List;

public interface SearchParameterCustomRepository {

    List<Chat> getChatListBySearchedParameters(City city, Long price, Long numberOfRooms);

}
