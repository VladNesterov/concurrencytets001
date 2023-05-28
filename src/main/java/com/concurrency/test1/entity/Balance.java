package com.concurrency.test1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.Cacheable;


@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Cacheable(cacheNames = "Balance", key = "id")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long amount;
}
