package com.example.turnstile.service;

import com.example.turnstile.domain.Client;
import com.example.turnstile.facade.AccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdmService {

    @Autowired
    private AccountFacade accountFacade;

    public Client getClientById(Long id) {
        return accountFacade.getAccountActive(id);
    }

    public Client getClientByAccountReference(UUID accountReference) {
        return accountFacade.getClientByAccountActive(accountReference);
    }

    public List<Client> getAllClient() {
        return accountFacade.findAllAccountActiveById();
    }

    public Client insertClient(Client client){
        return accountFacade.insertAccount(client);
    }

    public Client updateClient(Client client){
        return accountFacade.insertAccount(client);
    }

    public void deleteClient(UUID accountReference){
        accountFacade.deleteAccount(getClientByAccountReference(accountReference));
    }
}
