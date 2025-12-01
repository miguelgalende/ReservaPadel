package com.TeraPadel.AplicacionReservaPadel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.TeraPadel.AplicacionReservaPadel.model.Club;
import com.TeraPadel.AplicacionReservaPadel.service.ClubService;

@RestController
@RequestMapping("/api/clubs")
@CrossOrigin(origins = "*")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

@PostMapping("/crear")
    public ResponseEntity<Club> crear(@RequestBody Club club) {
        return ResponseEntity.ok(clubService.crear(club));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Club>> listar() {
        return ResponseEntity.ok(clubService.listar());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        clubService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}