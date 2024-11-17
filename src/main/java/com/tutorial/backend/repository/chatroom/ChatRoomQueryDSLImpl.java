package com.tutorial.backend.repository.chatroom;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static com.tutorial.backend.entity.QChatRoom.chatRoom;

import com.tutorial.backend.controller.dto.ChatRoomAndFriendDto;
import com.tutorial.backend.entity.QChatRoom;
import com.tutorial.backend.entity.QMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Slf4j
@Repository
@RequiredArgsConstructor
public class ChatRoomQueryDSLImpl implements ChatRoomQueryDSL{

    private final JPAQueryFactory query;
    @Override
    public Optional<Long> findByMyIdAndFriendId(Long userId, Long friendId) {
        return Optional.ofNullable(
            query.select(chatRoom.id)
                .from(chatRoom)
                .where(
                    chatRoom.seller.id.eq(userId).and(chatRoom.buyer.id.eq(friendId))
                        .or(chatRoom.buyer.id.eq(friendId).and(chatRoom.seller.id.eq(userId)))
                )
                .fetchOne()
        );
    }

    @Override
    public List<ChatRoomAndFriendDto> findByMyId(Long userId) {
        QChatRoom chatRoom = QChatRoom.chatRoom;
        QMember seller = new QMember("seller");
        QMember buyer = new QMember("buyer");

        return query
                .select(Projections.constructor(
                        ChatRoomAndFriendDto.class,
                        chatRoom.id, // Long chatRoomId
                        // CASE 문을 사용하여 조건에 맞는 친구 ID 선택 (Long 타입 반환)
                        Expressions.cases()
                                .when(chatRoom.seller.id.eq(userId)).then(buyer.id)
                                .otherwise(seller.id), // Long friendId
                        // CASE 문을 사용하여 조건에 맞는 친구 이름 선택 (String 타입 반환)
                        Expressions.cases()
                                .when(chatRoom.seller.id.eq(userId)).then(buyer.memberName)
                                .otherwise(seller.memberName), // String nickName
                        // CASE 문을 사용하여 조건에 맞는 프로필 이미지 URL 선택 (String 타입 반환)
                        Expressions.cases()
                                .when(chatRoom.seller.id.eq(userId)).then(seller.profileImageUrl)
                                .otherwise(seller.profileImageUrl) // String friendProfileUrl
                ))
                .from(chatRoom)
                .join(chatRoom.seller, seller)
                .join(chatRoom.seller, buyer)
                .where(
                        chatRoom.seller.id.eq(userId)
                                .or(chatRoom.buyer.id.eq(userId))
                )
                .fetch();
    }

}
