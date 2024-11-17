package com.tutorial.backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_file_member")
@IdClass(FileMemberId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class FileMember {

    @Id
    @ManyToOne
    @JoinColumn(name = "file_id", nullable = false)
    private File file;

    @Id
    private Long memberId; // String으로 변경

    @Builder
    public FileMember(File file, Long memberId) {
        this.file = file;
        this.memberId = memberId;
    }
}
