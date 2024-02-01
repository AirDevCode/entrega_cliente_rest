package com.billing.billing.responses;

import lombok.Getter;
import lombok.Setter;

public class ClienteResponse {

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String apellido;

    @Getter
    @Setter
    private int años;

    // Constructor vacío necesario para la deserialización JSON
    public ClienteResponse() {
    }
}
