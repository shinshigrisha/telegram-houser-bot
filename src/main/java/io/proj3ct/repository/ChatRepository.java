package io.proj3ct.repository;


import io.proj3ct.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Chat getChatByChatId(Long chatId);

}
