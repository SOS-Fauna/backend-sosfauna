package com.sosfauna.sosfaunaBackend.model.enumerated;

import com.fasterxml.jackson.annotation.JsonValue;



public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");


    private final String description;

    @Override
    @JsonValue
    public String toString() {
        return description;
    }

    public static Sexo fromDescription(String description) {
        for (Sexo sexo  : Sexo.values()) {
            if (sexo.description.equals(description)) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Error: " + description);
    }

    Sexo(String description) {
        this.description = description;
    }


}
