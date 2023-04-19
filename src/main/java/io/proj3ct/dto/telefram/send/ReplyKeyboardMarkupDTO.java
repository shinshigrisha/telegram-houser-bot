package io.proj3ct.dto.telefram.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReplyKeyboardMarkupDTO implements ReplyKeyboard {

    @JsonProperty("keyboard")
    private KeyboardButtonDTO[][] keyboardButtonArray;

    @JsonProperty("one_time_keyboard")
    private Boolean oneTimeKeyboard;

}
