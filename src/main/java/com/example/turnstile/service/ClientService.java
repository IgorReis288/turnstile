package com.example.turnstile.service;

import com.example.turnstile.domain.Client;
import com.example.turnstile.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.*;

@Service
public class ClientService {

    @Autowired
    ClientRepository client;

    public Client findClientByAccountReference(UUID accountReference){
        return client.findClientByAccountReference(accountReference);
    }

    public Client findClientActiveById(Long id){
        return client.findClientActiveById(id).orElse(new Client());
    }

    public List<Client> findAllClientActive(){
        return client.findAllClientActive();
    }

    public Client insertClient(Client c){
        return client.save(c);
    }

    public void deleteClient(Client c){
        client.delete(c);
    }

    public Client updateClient(Client c){
        Client cdb = client.findById(c.getId()).orElse(null);

        if(nonNull(cdb)){
            if(!cdb.getPermission().equals(c.getPermission())){
                cdb.setPermission(c.getPermission());
            }
            if(cdb.getAge().equals(c.getAge())){
                cdb.setAge(c.getAge());
            }
            if(cdb.getFullAddress().equals(c.getFullAddress())){
                cdb.setFullAddress(c.getFullAddress());
            }
            if(cdb.getName().equals(c.getName())){
                cdb.setName(c.getName());
            }
            cdb.setUpdateDate(Instant.now());
            return client.save(cdb);
        } else {
            return client.save(c);
        }
    }
}
