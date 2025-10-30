package com.TeraPadel.AplicacionReservaPadel.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter

public class PeticionCreacionReserva {

    @NotNull
    private Long id_pista;

    @NotNull
    private Long id_usuario;

    @NotNull
    private LocalDateTime fecha_inicio;

    @NotNull
    private LocalDateTime fecha_fin;

    private String estado_reserva = "ACTIVA";

}
