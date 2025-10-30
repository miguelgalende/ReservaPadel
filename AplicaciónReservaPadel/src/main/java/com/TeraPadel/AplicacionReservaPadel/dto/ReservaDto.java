package com.TeraPadel.AplicacionReservaPadel.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReservaDto {

    private LocalDateTime fecha_inicio;

    private LocalDateTime fecha_fin;

    private boolean estado;

}
