package com.example.turnstile.service;

import com.example.turnstile.enumerations.BuildingEnum;
import com.example.turnstile.facade.AccountFacade;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.example.turnstile.enumerations.BuildingEnum.codToEnum;
import static java.util.Objects.nonNull;

@Log4j2
@Service
public class CheckService {

    @Autowired
    private AccountFacade accountFacade;

    public Boolean checkUserInput(String accountReference, Integer cod) {

        UUID account = UUID.fromString(accountReference);
        String permission = accountFacade.getPermissionByAccountActive(account);

        if (permission.isEmpty()) {
            log.warn("A conta "+accountReference+" é inativa ou inválida");
            return false;
        }

        BuildingEnum buildingEnum = codToEnum(cod);

        if (nonNull(buildingEnum)) {

            List<String> tokens = Arrays.asList(permission.split("\\."));

            if (tokens.contains(permission)) {
                accountFacade.setCheckInAccountInBuilding(account, buildingEnum);
                log.info("O usuário " + accountReference + "entrou no " + buildingEnum.getUnit());
                return true;
            }
            log.warn("O usuário " + accountReference + "não pode entrar no " + buildingEnum.getUnit());
            return false;
        }

        log.warn("O usuário " + accountReference + "está com a permissão inválida");
        return false;
    }

    public void checkOutAccount(String accountReference, Integer cod){
        accountFacade.setCheckOutAccountInBuilding(UUID.fromString(accountReference), codToEnum(cod));
    }

}
