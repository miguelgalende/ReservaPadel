package com.TeraPadel.AplicacionReservaPadel.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PistaDto {

    private String idPista;

    private String nombrePista;

    private String idClub;

    private String imagenPista;

    private List<String> horario;

    private Map<String, List<String>> ocupadasPorDia;
}
