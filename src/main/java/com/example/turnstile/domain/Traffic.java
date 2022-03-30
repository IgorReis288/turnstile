package com.example.turnstile.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Builder
@Entity(name = "traffic")
public class Traffic extends AbstractDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private UUID accountReference;
    private Instant checkIn;
    private Instant checkOut;
    private String building;
}
