package com.essenciacriativa.system.controller;

import com.essenciacriativa.system.dto.UsuarioRequestDTO;
import com.essenciacriativa.system.dto.UsuarioResponseDTO;
import com.essenciacriativa.system.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<UsuarioResponseDTO> criarCliente(@Valid @RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.criarUsuario(dto));
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<UsuarioResponseDTO>> listadeClientes() {
        return ResponseEntity.ok(usuarioService.listarClientes());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable long id) {
        return ResponseEntity.ok(usuarioService.buscarporId(id));
    }

    @DeleteMapping("/clientes/{id}")
    ResponseEntity<Void> deletarCliente(@PathVariable long id) {
        usuarioService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }


}




