package com.ceos18.dangn.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Chat extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatId")
    private Long id;

    private String content;

    @Column(columnDefinition = "TINYINT(0) DEFAULT 0")
    private boolean isRead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatRoomId")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId")
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiverId")
    private User receiver;
}
