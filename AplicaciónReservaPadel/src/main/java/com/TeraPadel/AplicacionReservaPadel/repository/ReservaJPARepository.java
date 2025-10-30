package com.TeraPadel.AplicacionReservaPadel.repository;

import com.TeraPadel.AplicacionReservaPadel.model.Pista;
import com.TeraPadel.AplicacionReservaPadel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaJPARepository extends JpaRepository<Reserva, Long>{

    List<Reserva> findByFechaInicio(final LocalDateTime fecha_inicio);

    boolean existsByPistaAndInicioReservaBetween(Pista pista, 
                                             java.time.LocalDateTime inicio, 
                                             java.time.LocalDateTime fin);
}
