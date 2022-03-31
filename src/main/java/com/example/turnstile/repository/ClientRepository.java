package com.example.turnstile.repository;

import com.example.turnstile.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM client c WHERE c.account-reference = ?1")
    Client findClientByAccountReference(UUID AccountRefence);

    @Query("SELECT c FROM client c WHERE c.id = ?1 and c.active = true")
    Optional<Client> findClientActiveById(Long id);

    @Query("SELECT c FROM client c WHERE c.active = true")
    List<Client> findAllClientActive();
}
