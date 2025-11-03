package com.TeraPadel.AplicacionReservaPadel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;
    
    @Column(name = "apellidos_usuario", nullable = false)
    private String apellidosUsuario;

    @Column(name = "telefono_usuario", nullable = false)
    private String telefonoUsuario;

    @Column(name = "email_usuario", nullable = false, unique = true)
    private String emailUsuario;

    @Column(name = "contraseña_usuario", nullable = false)
    private String contraseñaUsuario;
    
    @Column(name = "rol_usuario")
    private String rolUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

}
