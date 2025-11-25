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

        private final UsuarioMongoRepository usuarioMongoRepository;
        private final ReservaMongoRepository reservaMongoRepository;
        private final PistaMongoRepository pistaMongoRepository;

        public ReservaServiceImpl(
                        UsuarioMongoRepository usuarioMongoRepository,
                        ReservaMongoRepository reservaMongoRepository,
                        PistaMongoRepository pistaMongoRepository) {
                this.usuarioMongoRepository = usuarioMongoRepository;
                this.reservaMongoRepository = reservaMongoRepository;
                this.pistaMongoRepository = pistaMongoRepository;
        }

        @Override
        public ReservaDto grabar(final PeticionCreacionReserva data) {

                usuarioMongoRepository.findById(data.getId_usuario())
                                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

                pistaMongoRepository.findById(data.getId_pista())
                                .orElseThrow(() -> new NotFoundException("Pista no encontrada"));

                Reserva reserva = new Reserva();
                reserva.setIdUsuario(data.getId_usuario());
                reserva.setIdPista(data.getId_pista());
                reserva.setInicioReserva(data.getFecha_inicio());
                reserva.setFinReserva(data.getFecha_fin());
                reserva.setEstadoReserva(data.getEstado_reserva());

                Reserva guardada = reservaMongoRepository.save(reserva);
                return convert(guardada);
        }

        @Override
        public ReservaDto actualizar(PeticionActualizacionReserva data) {

                Reserva reserva = reservaMongoRepository.findById(data.getId_reserva())
                                .orElseThrow(() -> new NotFoundException("Reserva no encontrada"));

                usuarioMongoRepository.findById(data.getId_usuario())
                                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

                pistaMongoRepository.findById(data.getId_pista())
                                .orElseThrow(() -> new NotFoundException("Pista no encontrada"));

                reserva.setIdUsuario(data.getId_usuario());
                reserva.setIdPista(data.getId_pista());
                reserva.setInicioReserva(data.getFecha_inicio());
                reserva.setFinReserva(data.getFecha_fin());
                reserva.setEstadoReserva(data.getEstado_reserva());

                Reserva actualizada = reservaMongoRepository.save(reserva);
                return convert(actualizada);
        }

        @Override
        public List<ReservaDto> listar() {
                return reservaMongoRepository.findAll().stream()
                                .map(this::convert)
                                .collect(Collectors.toList());
        }

        @Override
        public List<ReservaDto> listarPorUsuario(String idUsuario) {
                return reservaMongoRepository.findByIdUsuario(idUsuario)
                                .stream()
                                .map(this::convert)
                                .collect(Collectors.toList());
        }

        @Override
        public void eliminar(String id) {
                reservaMongoRepository.deleteById(id);
        }

        private ReservaDto convert(Reserva reserva) {
        ReservaDto dto = new ReservaDto();
        dto.setId_reserva(reserva.getIdReserva());
        dto.setId_usuario(reserva.getIdUsuario());
        dto.setId_pista(reserva.getIdPista());
        dto.setFecha_inicio(reserva.getInicioReserva());
        dto.setFecha_fin(reserva.getFinReserva());
        dto.setEstado_reserva(reserva.getEstadoReserva());
        return dto;
    }
}
