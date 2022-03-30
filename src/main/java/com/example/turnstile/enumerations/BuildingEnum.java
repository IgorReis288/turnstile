package com.example.turnstile.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BuildingEnum {

    TODOS("TODOS", 0),
    DECEA("DECEA", 1),
    GEIV("GEIV", 2),
    CGNA("CGNA", 3);

    private final String unit;
    private final Integer cod;

    public static BuildingEnum codToEnum(int cod) {

        try {
            for (BuildingEnum b : values()) {
                if (b.cod.equals(cod)) {
                    return b;
                }
            }
            throw new ClassNotFoundException("Permissão inválida");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
