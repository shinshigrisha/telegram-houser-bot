package io.proj3ct.telegramjokebot.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "MESSAGE")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MESSAGE_ID")
    private Long messageId;

    @Column(name = "DATE")
    private Date date;

    @Lob
    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    private User user;

    @ManyToOne
    private Chat chat;

}
