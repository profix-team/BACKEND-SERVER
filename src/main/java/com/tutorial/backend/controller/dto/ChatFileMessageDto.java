package com.tutorial.backend.controller.dto;

import com.tutorial.backend.entity.type.MessageType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ChatFileMessageDto {
    private String id;
    private String message;
    private Long senderId;
    private Long chatRoomId;
    private Long fileId;
    private int emotionNum;
    private MessageType messageType;

    @Builder
    public ChatFileMessageDto(String id, String message, Long senderId, Long chatRoomId, Long fileId,int emotionNum, MessageType messageType) {
        this.id = id;
        this.message = message;
        this.senderId = senderId;
        this.chatRoomId = chatRoomId;
        this.fileId = fileId;
        this.emotionNum = emotionNum;
        this.messageType = messageType;
    }
}
