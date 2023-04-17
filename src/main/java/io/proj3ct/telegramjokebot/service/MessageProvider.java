package io.proj3ct.telegramjokebot.service;

import io.proj3ct.telegramjokebot.constant.Language;

public interface MessageProvider {

    String getMessage(String message, Language lang);

}
