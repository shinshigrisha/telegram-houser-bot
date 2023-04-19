package io.proj3ct.repository;


import io.proj3ct.entity.Chat;
import io.proj3ct.entity.City;

import java.util.List;

public interface SearchParameterCustomRepository {

    List<Chat> getChatListBySearchedParameters(City city, Long price, Long numberOfRooms);

}
