package com.bits.markoth.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Date;

@Slf4j
@ToString
@Entity(name = "bid")
public class BidEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Getter
    @Setter
    private Double amount;

    @Getter
    @Setter
    private Date createdAt;
}