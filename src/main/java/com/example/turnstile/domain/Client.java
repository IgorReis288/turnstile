package com.example.turnstile.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

import static java.util.UUID.*;

@Data
@Entity(name = "client")
public class Client extends AbstractDomain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private UUID accountReference = randomUUID();
    private String name;
    private String document;
    private String fullAddress;
    private String age;
    private String permission;
}
