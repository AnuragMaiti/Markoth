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

@Slf4j
@ToString
@Entity(name = "users")
public class UserEntity {

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
    private String username;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String avatar_url;

}