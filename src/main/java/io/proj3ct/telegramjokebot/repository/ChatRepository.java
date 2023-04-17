package io.proj3ct.telegramjokebot.repository;


import io.proj3ct.telegramjokebot.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Chat getChatByChatId(Long chatId);

}
