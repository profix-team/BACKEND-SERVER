package com.tutorial.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tbl_notice")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private Member admin;
}
