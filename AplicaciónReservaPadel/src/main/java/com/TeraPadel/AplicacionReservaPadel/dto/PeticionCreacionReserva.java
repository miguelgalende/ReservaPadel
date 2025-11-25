package com.TeraPadel.AplicacionReservaPadel.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter

public class PeticionCreacionReserva {

    @NotNull
    private String id_pista;

    @NotNull
    private String id_usuario;

    @NotNull
    private LocalDateTime fecha_inicio;

    @NotNull
    private LocalDateTime fecha_fin;

    private String estado_reserva = "ACTIVA";

}
