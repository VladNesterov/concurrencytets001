package com.concurrency.test1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long amount;
}
