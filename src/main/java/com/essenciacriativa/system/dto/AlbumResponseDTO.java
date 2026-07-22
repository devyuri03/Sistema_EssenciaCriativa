package com.essenciacriativa.system.dto;

import com.essenciacriativa.system.enums.StatusAlbum;
import com.essenciacriativa.system.model.Album;

import java.time.LocalDate;

public record AlbumResponseDTO(
        Long id,
        String nome,
        LocalDate dataEnsaio,
        LocalDate expiraEm,
        StatusAlbum status,
        String nomeCliente,
        int quantidadeArquivos
) {
    public static AlbumResponseDTO from(Album album) {
        return new AlbumResponseDTO(
                album.getId(),
                album.getNome(),
                album.getDataEnsaio(),
                album.getExpiraEm(),
                album.getStatus(),
                album.getCliente().getNome(),
                album.getArquivos().size()
        );
    }
}
