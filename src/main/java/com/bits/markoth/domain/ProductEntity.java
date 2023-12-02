package com.bits.markoth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Date;

@Slf4j
@ToString
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private Long sellerId;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String attachmentsUrl;
    @Getter
    @Setter
    private String category;
    @Getter
    @Setter
    private Double initialBid;
    @Getter
    @Setter
    private Double minRaise;
    @Getter
    @Setter
    private Double autosellPrice;
    @Getter
    @Setter
    private Date startAt;
    @Getter
    @Setter
    private Date endAt;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Double increment;
    @Getter
    @Setter
    private Double buyNow;
}