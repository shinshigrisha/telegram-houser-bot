package io.proj3ct.service;


import io.proj3ct.entity.Chat;
import io.proj3ct.entity.Home;
import io.proj3ct.entity.SearchParameter;

import java.util.List;

public interface SearchParameterService {

    SearchParameter getSearchParameter(Long chatId);

    SearchParameter saveSearchParameter(SearchParameter searchParameter);

    SearchParameter updateSearchParameter(SearchParameter searchParameter);

    void deleteSearchParameter(Long chatId);

    List<Chat> getChatListByAppropriateParameters(Home home);

}
