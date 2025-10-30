package com.TeraPadel.AplicacionReservaPadel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "CLUB")
@Getter
@Setter

public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_club")
    private Long idClub;

    @Column(name = "nombre_club", nullable = false)
    private String nombreClub;

    @Column(name = "direccion_club", nullable = false)
    private String direccionClub;
    
    @Column(name = "telefono_club", nullable = false)
    private String telefonoClub;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pista> pistas;

}
