package com.essenciacriativa.system.controller;

import com.essenciacriativa.system.dto.AlbumResponseDTO;
import com.essenciacriativa.system.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albuns")
public class ClienteAlbumController {

    private final AlbumService albumService;

    public ClienteAlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponseDTO> buscarMeuAlbum (@PathVariable Long id){
        return ResponseEntity.ok(albumService.buscarMeuAlbum(id));
    }

    @GetMapping("/meus")
    public ResponseEntity<List<AlbumResponseDTO>> meusAlbums(){
        return ResponseEntity.ok(albumService.listarMeusAlbums());
    }
}
