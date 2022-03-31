package com.example.turnstile.controller;

import com.example.turnstile.domain.Client;
import com.example.turnstile.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.fromString;

@Controller
@RequestMapping("adm/")
public class AdmController {

    @Autowired
    private AdmService service;

    @GetMapping("account/{accountReference}")
    public Client getClient(@PathVariable String accountReference){
        return service.getClientByAccountReference(fromString(accountReference));
    }

    @GetMapping("account/list")
    public List<Client> getAllClientActive(){
        return service.getAllClient();
    }

    @PostMapping("account/delete/{accountReference}")
    public void deleteClient(@PathVariable String accountReference){
        service.deleteClient(fromString(accountReference));
    }

    @PostMapping("account/delete/{accountReference}")
    public void updateClient(@PathVariable String accountReference){
        service.updateClient(service.getClientByAccountReference(fromString(accountReference)));
    }
}
