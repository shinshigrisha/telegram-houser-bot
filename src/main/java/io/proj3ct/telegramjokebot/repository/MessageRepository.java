package io.proj3ct.telegramjokebot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
