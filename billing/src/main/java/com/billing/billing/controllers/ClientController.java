package com.billing.billing.controllers;

import com.billing.billing.models.*;
import com.billing.billing.repository.*;
import com.billing.billing.responses.ClienteResponse;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository repo;

    @GetMapping
    public String index() {
        return "conectado";
    }

    @PostMapping("save")
    public ClienteResponse post(@RequestBody Client cliente) {
        repo.save(cliente);

        // Calcular edad
        LocalDate fechaNacimiento = cliente.getFechaNacimiento();
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();

        // Construir la respuesta
        ClienteResponse response = new ClienteResponse();
        response.setNombre(cliente.getNombre());
        response.setApellido(cliente.getApellido());
        response.setAños(edad);

        return response;
    }

}
