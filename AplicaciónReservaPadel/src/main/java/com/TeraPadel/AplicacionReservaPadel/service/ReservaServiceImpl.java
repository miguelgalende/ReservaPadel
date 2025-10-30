package com.TeraPadel.AplicacionReservaPadel.service;

import com.TeraPadel.AplicacionReservaPadel.dto.*;
import com.TeraPadel.AplicacionReservaPadel.model.*;
import com.TeraPadel.AplicacionReservaPadel.repository.*;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service("servicioReservas")
public class ReservaServiceImpl implements ReservaService {

    private final UsuarioJPARepository usuarioJPARepository;
    private final ReservaJPARepository reservaJPARepository;
    private final PistaJPARepository pistaJPARepository;

    public ReservaServiceImpl(
            UsuarioJPARepository usuarioJPARepository,
            ReservaJPARepository reservaJPARepository,
            PistaJPARepository pistaJPARepository) {
        this.usuarioJPARepository = usuarioJPARepository;
        this.reservaJPARepository = reservaJPARepository;
        this.pistaJPARepository = pistaJPARepository;
    }

    @Override
    public ReservaDto grabar(final PeticionCreacionReserva data) {

        Usuario usuario = usuarioJPARepository.findById(data.getId_usuario())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        Pista pista = pistaJPARepository.findById(data.getId_pista())
                .orElseThrow(() -> new NotFoundException("Pista no encontrada"));

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setPista(pista);
        reserva.setInicioReserva(data.getFecha_inicio());
        reserva.setFinReserva(data.getFecha_fin());
        reserva.setEstadoReserva(data.getEstado_reserva());

        Reserva guardada = reservaJPARepository.save(reserva);
        return convert(guardada);
    }

    @Override
    public ReservaDto actualizar(final PeticionActualizacionReserva data) {

        Reserva reserva = reservaJPARepository.findById(data.getId_reserva())
                .orElseThrow(() -> new NotFoundException("Reserva no encontrada"));

        Usuario usuario = usuarioJPARepository.findById(data.getId_usuario())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        Pista pista = pistaJPARepository.findById(data.getId_pista())
                .orElseThrow(() -> new NotFoundException("Pista no encontrada"));

        reserva.setUsuario(usuario);
        reserva.setPista(pista);
        reserva.setInicioReserva(data.getFecha_inicio());
        reserva.setFinReserva(data.getFecha_fin());
        reserva.setEstadoReserva(data.getEstado_reserva());

        Reserva actualizada = reservaJPARepository.save(reserva);
        return convert(actualizada);
    }

    @Override
    public List<ReservaDto> listar() {
        return reservaJPARepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(final Long id) {
        Reserva reserva = reservaJPARepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva no encontrada"));
        reservaJPARepository.delete(reserva);
    }

    private ReservaDto convert(final Reserva reserva) {
        ReservaDto dto = new ReservaDto();
        dto.setFecha_inicio(reserva.getInicioReserva());
        dto.setFecha_fin(reserva.getFinReserva());
        dto.setEstado("ACTIVA".equalsIgnoreCase(reserva.getEstadoReserva()));
        return dto;
    }
}
