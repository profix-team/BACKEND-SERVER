package com.tutorial.backend.entity;

import com.tutorial.backend.entity.type.Authority;
import com.tutorial.backend.entity.type.StatusType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_member")
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String memberEmail;

    private String memberPassword;

    private String memberPhone;

    private String memberName;

    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "buyer")
    private List<ChatRoom> chatRoomsAsBuyer;

    @OneToMany(mappedBy = "seller")
    private List<ChatRoom> chatRoomsAsSeller;

    @OneToMany(mappedBy = "admin")
    private List<Notice> notices;

    @OneToMany(mappedBy = "member")
    private List<Property> properties;

    @OneToMany(mappedBy = "member")
    private List<Like> likes;

    @OneToMany(mappedBy = "member")
    private List<Report> reports;

    @Builder
    public Member(Long id, String memberEmail, String memberPassword, String memberPhone, String memberName, String profileImageUrl, StatusType status, Authority authority, List<ChatRoom> chatRoomsAsBuyer, List<ChatRoom> chatRoomsAsSeller, List<Notice> notices, List<Property> properties, List<Like> likes) {
        this.id = id;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberPhone = memberPhone;
        this.memberName = memberName;
        this.profileImageUrl = profileImageUrl;
        this.status = status;
        this.authority = authority;
        this.chatRoomsAsBuyer = chatRoomsAsBuyer;
        this.chatRoomsAsSeller = chatRoomsAsSeller;
        this.notices = notices;
        this.properties = properties;
        this.likes = likes;
    }


    public Member update(String memberName, String memberPhoneNumber, String memberEmail, String profileImageUrl){
        this.setMemberName(memberName);
        this.setMemberPhone(memberPhoneNumber);
        this.setMemberEmail(memberEmail);
        this.setProfileImageUrl(profileImageUrl);
        return this;
    }

}
