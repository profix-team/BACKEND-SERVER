package com.tutorial.backend.repository.chatroom;

import com.tutorial.backend.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>, ChatRoomQueryDSL {
}
