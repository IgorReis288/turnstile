package com.example.turnstile.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class AbstractDomain {

    private Instant creationDate = Instant.now();
    private Instant updateDate = null;
    private Boolean active = true;
}
