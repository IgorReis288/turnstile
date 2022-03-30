package com.example.turnstile.service;

import com.example.turnstile.domain.Client;
import com.example.turnstile.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    ClientRepository client;

    public Client findClientByAccountReference(UUID accountReference){
        return client.findClientByAccountReference(accountReference);
    }
}
