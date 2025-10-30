package com.TeraPadel.AplicacionReservaPadel.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "RESERVA")
@Getter
@Setter

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_pista", nullable = false)
    private Pista pista;

    @Column(name = "inicio_reserva", nullable = false)
    private LocalDateTime inicioReserva;

    @Column(name = "fin_reserva", nullable = false)
    private LocalDateTime finReserva;

    @Column(name = "estado_reserva", nullable = false)
    private String estadoReserva;

}
