package com.TeraPadel.AplicacionReservaPadel.repository;

import com.TeraPadel.AplicacionReservaPadel.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaJPARepository extends JpaRepository<Reserva, Long>{

    List<Reserva> findByInicioReserva(LocalDateTime inicioReserva);

}
