package com.example.turnstile.repository;

import com.example.turnstile.domain.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic, Long> {

    @Query("SELECT t FROM traffic t WHERE t.account-reference = ?1 and t.building = ?2 and t.active = true")
    Traffic findTrafficActiveByAccountReference(UUID AccountRefence, String building);
}
