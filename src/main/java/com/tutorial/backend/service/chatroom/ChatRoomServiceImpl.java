package com.tutorial.backend.service.chatroom;

import com.tutorial.backend.controller.dto.ChatRoomAndFriendDto;
import com.tutorial.backend.entity.ChatRoom;
import com.tutorial.backend.entity.Member;
import com.tutorial.backend.repository.chatroom.ChatRoomRepository;
import com.tutorial.backend.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
@Slf4j
public class ChatRoomServiceImpl implements ChatRoomService{

    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;

    @Override
    public Optional<Long> getChatRoom(Long id, Long friendId) {
        return chatRoomRepository.findByMyIdAndFriendId(id, friendId);
    }

    @Override
    public List<ChatRoomAndFriendDto> getMyChatRoomAndFriend(Long id) {
        return chatRoomRepository.findByMyId(id);
    }

    @Override
    public Long newRoom(Member me, Long friendId) {
        Member foundFriend = memberRepository.findById(friendId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid friend ID: " + friendId));

        ChatRoom chatRoom = ChatRoom.builder()
                .buyer(me)
                .seller(foundFriend)
                .build();

        ChatRoom savedChatRoom = chatRoomRepository.save(chatRoom);

        return savedChatRoom.getId();
    }


}
