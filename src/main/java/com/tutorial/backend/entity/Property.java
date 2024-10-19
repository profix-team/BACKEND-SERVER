package com.tutorial.backend.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_property")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propertyAddress;

    private String propertyAddressDetail;

    private String propertyDetail;

    private int propertyPrice;

    private int propertyDeposit;

    private int propertyMaintenanceCost;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "property")
    private List<Report> reports;
}
