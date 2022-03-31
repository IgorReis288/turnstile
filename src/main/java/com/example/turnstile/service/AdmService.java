package com.example.turnstile.service;

import com.example.turnstile.domain.Client;
import com.example.turnstile.facade.AccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmService {

    @Autowired
    private AccountFacade accountFacade;

    public Client getClientById(Long id) {
        return accountFacade.getAccountActive(id);
    }

    public List<Client> getAllClient() {
        return accountFacade.findAllAccountActiveById();
    }

}
