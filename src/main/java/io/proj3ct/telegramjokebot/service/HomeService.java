package io.proj3ct.telegramjokebot.service;


import io.proj3ct.telegramjokebot.entity.Home;

import java.io.IOException;
import java.util.List;

public interface HomeService {

    void findNewHomes() throws IOException;

    List<Home> getUnsentHomes();

    Home updateHome(Home home);

}
