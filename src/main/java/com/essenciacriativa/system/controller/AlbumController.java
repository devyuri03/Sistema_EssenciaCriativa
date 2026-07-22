package com.essenciacriativa.system.controller;


import com.essenciacriativa.system.dto.AlbumRequestDTO;
import com.essenciacriativa.system.dto.AlbumResponseDTO;
import com.essenciacriativa.system.service.AlbumService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")

public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService){this.albumService = albumService;}

    @PostMapping("/albums")
    public ResponseEntity<AlbumResponseDTO> criarAlbum(@Valid @RequestBody AlbumRequestDTO dto){
         return ResponseEntity.status(HttpStatus.CREATED).body(albumService.criarAlbum(dto));
    }

    @GetMapping ("/albums")
    public ResponseEntity<List<AlbumResponseDTO>> listarAlbums(){
        return ResponseEntity.ok(albumService.listarAlbum());
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<AlbumResponseDTO> buscarPorId (@PathVariable Long id){
        return ResponseEntity.ok(albumService.buscarPorId(id));
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<Void> excluirAlbum(@PathVariable Long id){
        albumService.excluirAlbum(id);
        return ResponseEntity.noContent().build();
    }


}
