package com.TeraPadel.AplicacionReservaPadel.repository;

import com.TeraPadel.AplicacionReservaPadel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioJPARepository extends JpaRepository<Usuario, Long>{

    List<Usuario> findUsuarioById(final Long id_usuario);

    Optional<Usuario> findByEmailUsuario(String email);

}
