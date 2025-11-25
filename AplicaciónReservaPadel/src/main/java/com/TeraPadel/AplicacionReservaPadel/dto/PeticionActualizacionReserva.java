package com.TeraPadel.AplicacionReservaPadel.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter

public class PeticionActualizacionReserva {

    @NotNull
    private String id_reserva;

    @NotNull
    private String id_pista;

    @NotNull
    private String id_usuario;

    @NotNull
    private LocalDateTime fecha_inicio;

    @NotNull
    private LocalDateTime fecha_fin;

    private String estado_reserva;

}
