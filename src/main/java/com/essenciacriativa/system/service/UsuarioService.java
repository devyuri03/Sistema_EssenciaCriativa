package com.essenciacriativa.system.service;

import com.essenciacriativa.system.dto.UsuarioRequestDTO;
import com.essenciacriativa.system.dto.UsuarioResponseDTO;
import com.essenciacriativa.system.enums.Role;
import com.essenciacriativa.system.model.Usuario;
import com.essenciacriativa.system.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEnconder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEnconder = passwordEncoder;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto){
        if (usuarioRepository.findByEmail(dto.email()).isPresent()){
            throw new IllegalArgumentException("Email ja cadastrado no sistema" + dto.email());
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEnconder.encode(dto.senha()));
        usuario.setRole(Role.CLIENTE);

        Usuario salvo = usuarioRepository.save(usuario);

        return UsuarioResponseDTO.from(salvo);

    }

    public List<UsuarioResponseDTO> listarClientes(){
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioResponseDTO::from)
                .toList();

    }

    public UsuarioResponseDTO buscarporId (Long id){
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }
        return UsuarioResponseDTO.from(opt.get());
    }

    public void excluirCliente(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        usuarioRepository.delete(usuario);

    }

}
