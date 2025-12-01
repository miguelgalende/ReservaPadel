package com.TeraPadel.AplicacionReservaPadel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.TeraPadel.AplicacionReservaPadel.model.Pista;
import com.TeraPadel.AplicacionReservaPadel.service.PistaService;

@RestController
@RequestMapping("/api/pistas")
@CrossOrigin("*")
public class PistaController {
    private final PistaService pistaService;

    public PistaController(PistaService pistaService) {
        this.pistaService = pistaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Pista> crear(@RequestBody Pista pista) {
        return ResponseEntity.ok(pistaService.crear(pista));
    }

    @GetMapping("/club/{idClub}")
    public List<Pista> listarPorClub(@PathVariable String idClub) {
        return pistaService.listarPorClub(idClub);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        pistaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
