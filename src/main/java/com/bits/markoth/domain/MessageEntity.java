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
@Entity(name = "message")
public class MessageEntity {

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
    @JoinColumn(name = "room_id")
    private ChatRoomEntity room;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String caption;

    @Getter
    @Setter
    private Date sentAt;
}