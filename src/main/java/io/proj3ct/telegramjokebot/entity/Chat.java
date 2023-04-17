package io.proj3ct.telegramjokebot.entity;

import io.proj3ct.telegramjokebot.constant.ChatStage;
import io.proj3ct.telegramjokebot.constant.Language;
import jakarta.persistence.*;
import lombok.Data;


@Entity

@Data
public class Chat {

    @Id
    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "TYPE", length = 15)
    private String type;

    @Column(name = "TITLE", length = 300)
    private String title;

    @Column(name = "FIRST_NAME", length = 120)
    private String firstName;

    @Column(name = "LAST_NAME", length = 120)
    private String lastName;

    @Column(name = "USERNAME", length = 300)
    private String username;

    @Column(name = "BIO", length = 300)
    private String bio;

    @Column(name = "DESCRIPTION", length = 300)
    private String description;

    @Column(name = "CHAT_STAGE", length = 25)
    @Enumerated(EnumType.STRING)
    private ChatStage chatStage;

    @Column(name = "LANGUAGE", length = 3)
    @Enumerated(EnumType.STRING)
    private Language language;
}
