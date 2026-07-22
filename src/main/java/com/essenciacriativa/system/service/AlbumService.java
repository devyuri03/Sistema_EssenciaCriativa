package com.essenciacriativa.system.service;

import com.essenciacriativa.system.dto.AlbumRequestDTO;
import com.essenciacriativa.system.dto.AlbumResponseDTO;
import com.essenciacriativa.system.enums.StatusAlbum;
import com.essenciacriativa.system.model.Album;
import com.essenciacriativa.system.model.Usuario;
import com.essenciacriativa.system.repository.AlbumRepository;
import com.essenciacriativa.system.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final UsuarioRepository usuarioRepository;

    public AlbumResponseDTO criarAlbum(AlbumRequestDTO dto){
        Usuario cliente = usuarioRepository.findById(dto.clienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado: " + dto.clienteId()));

        Album album = new Album();
        album.setNome(dto.nome());
        album.setDataEnsaio(dto.dataEnsaio());
        album.setExpiraEm(dto.expiraEm());
        album.setStatus(StatusAlbum.ATIVO);
        album.setCliente(cliente);

        Album salvo = albumRepository.save(album);

        return AlbumResponseDTO.from(salvo);
    }

    public List<AlbumResponseDTO> listarAlbum(){

        return albumRepository.findAll()
                .stream()
                .map(AlbumResponseDTO::from)
                .toList();
    }

    public AlbumResponseDTO buscarPorId(Long id){
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Album não encontrado: " + id));
        return AlbumResponseDTO.from(album);
    }

    public void excluirAlbum(Long id){
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Album não encontrado: " +id));

        albumRepository.delete(album);
    }
}
