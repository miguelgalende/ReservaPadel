package com.TeraPadel.AplicacionReservaPadel.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter

public class PeticionActualizacionReserva {

    @NotNull
    private Long id_reserva;

    @NotNull
    private Long id_pista;

    @NotNull
    private Long id_usuario;

    @NotNull
    private LocalDateTime fecha_inicio;

    @NotNull
    private LocalDateTime fecha_fin;

    private String estado_reserva;

}
