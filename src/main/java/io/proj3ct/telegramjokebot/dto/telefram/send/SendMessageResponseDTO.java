package io.proj3ct.telegramjokebot.dto.telefram.send;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.proj3ct.telegramjokebot.dto.telefram.update.ParameterDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendMessageResponseDTO {

    @JsonProperty("ok")
    private Boolean ok;

    @JsonProperty("error_code")
    private Long errorCode;

    @JsonProperty("description")
    private String description;

    @JsonProperty("parameters")
    private ParameterDTO parameters;

}
