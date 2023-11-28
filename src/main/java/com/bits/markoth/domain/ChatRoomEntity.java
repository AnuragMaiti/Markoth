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
@Entity(name = "chatroom")
public class ChatRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
            "hilopooled")
    @GenericGenerator(name = "hilopooled", type =
            org.hibernate.id.enhanced.SequenceStyleGenerator.class,
            parameters = {
                    @Parameter(name = "sequence_name", value =
                            "hibernate_sequence"),
                    @Parameter(name = "increment_size", value = "50"),
                    @Parameter(name = "optimizer", value = "pooled")
            }
    )
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
    @JoinColumn(name = "seller_id")
    private UserEntity seller;

    @Getter
    @Setter
    private Date buyer_read;

    @Getter
    @Setter
    private Date seller_read;
}