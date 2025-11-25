package com.TeraPadel.AplicacionReservaPadel.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReservaDto {

    private String id_reserva;

    private String id_usuario;

    private String id_pista;

    private LocalDateTime fecha_inicio;

    private LocalDateTime fecha_fin;

    private String estado_reserva;

}
