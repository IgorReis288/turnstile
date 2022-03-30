package com.example.turnstile.controller;

import com.example.turnstile.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check")
public class CheckController {

    @Autowired
    private CheckService service;

    @GetMapping("check-in/{account-reference}/{cod}")
    public String checkIn(@PathVariable String accountReference, @PathVariable Integer cod) {

        return service.checkUserInput(accountReference, cod).toString();
    }

    @GetMapping("check-out/{account-reference}/{cod}")
    public String checkOut(@PathVariable String accountReference, @PathVariable Integer cod) {
        service.checkOutAccount(accountReference, cod);
        return "saiu";
    }

}
