package io.proj3ct.telegramjokebot.repository;

import io.proj3ct.telegramjokebot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);

}
