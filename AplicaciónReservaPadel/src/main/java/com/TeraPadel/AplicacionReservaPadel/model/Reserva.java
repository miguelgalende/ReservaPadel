package com.TeraPadel.AplicacionReservaPadel.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "reservas")
public class Reserva {

    @Id
    private String idReserva;

    private String idUsuario;

    private String idPista;

    private LocalDateTime inicioReserva;

    private LocalDateTime finReserva;

    private String estadoReserva;

}
