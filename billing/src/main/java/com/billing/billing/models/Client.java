package com.billing.billing.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String nombre;

    @Column
    @Getter
    @Setter
    private String apellido;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_nacimiento;

    public LocalDate getFechaNacimiento() {
        return fecha_nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fecha_nacimiento = Date.from(fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
