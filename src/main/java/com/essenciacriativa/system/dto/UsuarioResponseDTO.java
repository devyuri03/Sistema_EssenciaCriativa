package com.essenciacriativa.system.dto;

import com.essenciacriativa.system.enums.Role;
import com.essenciacriativa.system.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        Role role
) {

    public static UsuarioResponseDTO from(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }
}