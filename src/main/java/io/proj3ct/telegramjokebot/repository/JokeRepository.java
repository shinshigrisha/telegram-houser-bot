package io.proj3ct.telegramjokebot.repository;

import io.proj3ct.telegramjokebot.entity.Joke;
import org.springframework.data.repository.CrudRepository;


public interface JokeRepository extends CrudRepository<Joke, Integer> {

}

