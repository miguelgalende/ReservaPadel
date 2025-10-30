package com.TeraPadel.AplicacionReservaPadel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "PISTA")
@Getter
@Setter

public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pista")
    private Long idPista;
    
    @Column(name = "nombre_pista", nullable = false)
    private String nombrePista;

    @ManyToOne
    @JoinColumn(name = "id_club", nullable = false)
    private Club club;

    @OneToMany(mappedBy = "pista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

}
