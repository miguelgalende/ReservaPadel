package com.TeraPadel.AplicacionReservaPadel.controller;

import com.TeraPadel.AplicacionReservaPadel.model.Usuario;
import com.TeraPadel.AplicacionReservaPadel.repository.UsuarioJPARepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class UsuarioController {
private final UsuarioJPARepository usuarioJPARepository;

    public UsuarioController(UsuarioJPARepository usuarioJPARepository) {
        this.usuarioJPARepository = usuarioJPARepository;
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario nuevoUsuario) {

        Optional<Usuario> existente = usuarioJPARepository.findByEmailUsuario(nuevoUsuario.getEmailUsuario());
        if (existente.isPresent()) {
            return ResponseEntity.badRequest().body("El correo ya está registrado");
        }

        Usuario guardado = usuarioJPARepository.save(nuevoUsuario);
        return ResponseEntity.ok(guardado);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        Optional<Usuario> usuario = usuarioJPARepository.findByEmailUsuario(loginRequest.getEmailUsuario());

        if (usuario.isPresent()) {
            Usuario u = usuario.get();

            if (u.getContraseñaUsuario().equals(loginRequest.getContraseñaUsuario())) {
                return ResponseEntity.ok(u);
            } else {
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioJPARepository.findAll());
    }
}
