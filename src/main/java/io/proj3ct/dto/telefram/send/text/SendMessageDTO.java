package io.proj3ct.dto.telefram.send.text;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Data
public class SendMessageDTO {
    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("text")
    private String text;

    @JsonProperty("reply_markup")
    private ReplyKeyboard replyKeyboard;
    
}
