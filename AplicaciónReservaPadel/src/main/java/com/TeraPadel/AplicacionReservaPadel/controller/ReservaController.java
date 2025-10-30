package com.TeraPadel.AplicacionReservaPadel.controller;

import com.TeraPadel.AplicacionReservaPadel.dto.*;
import com.TeraPadel.AplicacionReservaPadel.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ReservaDto> crearReserva(@Valid @RequestBody PeticionCreacionReserva peticion) {
        ReservaDto reservaCreada = reservaService.grabar(peticion);
        return ResponseEntity.ok(reservaCreada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ReservaDto>> listarReservas() {
        List<ReservaDto> reservas = reservaService.listar();
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ReservaDto> actualizarReserva(@Valid @RequestBody PeticionActualizacionReserva peticion) {
        ReservaDto reservaActualizada = reservaService.actualizar(peticion);
        return ResponseEntity.ok(reservaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        reservaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ReservaDto>> listarReservasPorUsuario(@PathVariable Long idUsuario) {
        PeticionBusquedaReserva filtro = new PeticionBusquedaReserva();
        filtro.setId_usuario(idUsuario);
        // aquí podrías agregar un método reservaService.buscar(filtro)
        List<ReservaDto> reservas = reservaService.listar(); // temporalmente listar todas
        return ResponseEntity.ok(reservas);
    }

}
