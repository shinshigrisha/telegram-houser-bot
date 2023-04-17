package io.proj3ct.telegramjokebot.service.service;

import io.proj3ct.telegramjokebot.service.dto.telegram.update.ChatDTO;
import io.proj3ct.telegramjokebot.service.dto.telegram.update.MessageDTO;
import io.proj3ct.telegramjokebot.service.dto.telegram.update.TelegramUpdateDTO;
import io.proj3ct.telegramjokebot.service.dto.telegram.update.UserDTO;
import io.proj3ct.telegramjokebot.service.entity.Chat;
import io.proj3ct.telegramjokebot.service.entity.Message;
import io.proj3ct.telegramjokebot.service.entity.User;

public interface ChatDataService {

    void saveTelegramMessage(TelegramUpdateDTO telegramUpdateDTO);

    Chat saveChat(ChatDTO chatDTO);

    Chat updateChat(Chat chat);

    User saveUser(UserDTO userDTO);

    Message saveMessage(MessageDTO messageDTO, Chat chat, User user);

    Chat getChatByChatId(Long chatId);

}
