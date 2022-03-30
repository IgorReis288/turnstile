package com.example.turnstile.facade;

import com.example.turnstile.domain.Client;
import com.example.turnstile.enumerations.BuildingEnum;
import com.example.turnstile.service.ClientService;
import com.example.turnstile.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountFacade {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TrafficService trafficService;

    public String getPermissionByAccountActive(UUID accountReference){
        Client client =  clientService.findClientByAccountReference(accountReference);
        return client.getActive() ? client.getPermission(): "";
    }

    public void setCheckInAccountInBuilding(UUID accountReference, BuildingEnum buildingEnum){
        trafficService.checkInAccount(accountReference, buildingEnum);
    }

    public void setCheckOutAccountInBuilding(UUID accountReference, BuildingEnum buildingEnum){
        trafficService.checkOutAccount(accountReference, buildingEnum);
    }


}
