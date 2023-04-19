package io.proj3ct.service.iml;


import io.proj3ct.constant.Language;
import io.proj3ct.service.MessageProvider;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageProviderImpl implements MessageProvider {

    private final MessageSource messageSource;

    public MessageProviderImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String message, Language language) {
        String langName = "null";
        if (language != null)
            langName = language.name();
        return messageSource.getMessage(message, null, new Locale(langName));
    }

}
