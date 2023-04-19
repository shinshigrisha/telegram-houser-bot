package io.proj3ct.service;


import io.proj3ct.dto.telefram.send.SendMessageResponseDTO;
import io.proj3ct.dto.telefram.send.photo.SendPhotoDTO;
import io.proj3ct.dto.telefram.send.text.SendMessageDTO;
import io.proj3ct.dto.telefram.update.TelegramUpdateDTO;
import io.proj3ct.entity.Home;

import java.util.List;

public interface TelegramMessagingService {

    TelegramUpdateDTO getUpdates();

    SendMessageResponseDTO sendMessage(SendMessageDTO sendMessageDTO);

    SendMessageResponseDTO sendPhoto(SendPhotoDTO sendPhotoDTO);

    SendMessageResponseDTO reply(TelegramUpdateDTO telegramUpdateDTO);

    void sendNewNotifications(List<Home> homeList);

}
