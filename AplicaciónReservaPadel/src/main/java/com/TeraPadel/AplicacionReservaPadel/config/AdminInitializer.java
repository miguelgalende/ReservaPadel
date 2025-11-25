package com.TeraPadel.AplicacionReservaPadel.config;

import com.TeraPadel.AplicacionReservaPadel.model.Usuario;
import com.TeraPadel.AplicacionReservaPadel.repository.UsuarioMongoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminInitializer implements CommandLineRunner {

    private final UsuarioMongoRepository usuarioRepo;

    public AdminInitializer(UsuarioMongoRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepo.findByEmailUsuario("admin@terapadel.com").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNombreUsuario("Admin");
            admin.setEmailUsuario("admin@terapadel.com");
            admin.setContraseñaUsuario("admin");
            admin.setRolUsuario("ADMIN");

            usuarioRepo.save(admin);
            System.out.println("Administrador creado: admin@terapadel.com");
        }
    }
}