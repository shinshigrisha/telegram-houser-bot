package io.proj3ct.service;


import io.proj3ct.entity.Home;

import java.io.IOException;
import java.util.List;

public interface HomeService {

    void findNewHomes() throws IOException;

    List<Home> getUnsentHomes();

    Home updateHome(Home home);

}
