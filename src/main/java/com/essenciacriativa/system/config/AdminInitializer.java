package com.essenciacriativa.system.config;

import com.essenciacriativa.system.enums.Role;
import com.essenciacriativa.system.model.Usuario;
import com.essenciacriativa.system.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    public CommandLineRunner criarAdminRayane(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        return args -> {
            String emailAdmin ="adminrayane@essenciacriativa.com";

            if (usuarioRepository.findByEmail(emailAdmin).isEmpty()) {
                Usuario admin = new Usuario();
                admin.setNome("Rayane");
                admin.setEmail(emailAdmin);
                admin.setSenha(passwordEncoder.encode("admin123"));
                admin.setRole(Role.ADMIN);
                usuarioRepository.save(admin);
                System.out.println(">>> Usuário admin criado: " + emailAdmin);
            }
        };
    }
}
