package com.TeraPadel.AplicacionReservaPadel.controller;

import com.TeraPadel.AplicacionReservaPadel.dto.*;
import com.TeraPadel.AplicacionReservaPadel.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ReservaDto> crearReserva(@Valid @RequestBody PeticionCreacionReserva peticion) {
        ReservaDto reserva = reservaService.grabar(peticion);
        return ResponseEntity.ok(reserva);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ReservaDto>> listarReservas() {
        List<ReservaDto> reserva = reservaService.listar();
        return ResponseEntity.ok(reserva);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ReservaDto> actualizarReserva(@Valid @RequestBody PeticionActualizacionReserva peticion) {
        ReservaDto reserva = reservaService.actualizar(peticion);
        return ResponseEntity.ok(reserva);
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
        List<ReservaDto> reservas = reservaService.listar();
        return ResponseEntity.ok(reservas);
    }

}
