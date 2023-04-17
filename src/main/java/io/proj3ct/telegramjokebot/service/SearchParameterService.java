package io.proj3ct.telegramjokebot.service;


import io.proj3ct.telegramjokebot.entity.Chat;
import io.proj3ct.telegramjokebot.entity.Home;
import io.proj3ct.telegramjokebot.entity.SearchParameter;

import java.util.List;

public interface SearchParameterService {

    SearchParameter getSearchParameter(Long chatId);

    SearchParameter saveSearchParameter(SearchParameter searchParameter);

    SearchParameter updateSearchParameter(SearchParameter searchParameter);

    void deleteSearchParameter(Long chatId);

    List<Chat> getChatListByAppropriateParameters(Home home);

}
