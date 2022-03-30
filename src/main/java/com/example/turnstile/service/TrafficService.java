package com.example.turnstile.service;

import com.example.turnstile.domain.Traffic;
import com.example.turnstile.enumerations.BuildingEnum;
import com.example.turnstile.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class TrafficService {

    @Autowired
    private TrafficRepository repository;

    public void checkInAccount(UUID accountReference, BuildingEnum building){

        repository.save(
                Traffic
                        .builder()
                        .accountReference(accountReference)
                        .checkIn(Instant.now())
                        .checkOut(null)
                        .building(building.getUnit())
                        .build()
        );
    }

    public void checkOutAccount(UUID accountReference, BuildingEnum building){

        Traffic traffic = repository.findTrafficActiveByAccountReference(accountReference, building.getUnit());
        traffic.setCheckOut(Instant.now());
        traffic.setUpdateDate(Instant.now());
        traffic.setActive(false);
        repository.save(traffic);
    }
}
