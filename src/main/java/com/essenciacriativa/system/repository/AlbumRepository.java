package com.essenciacriativa.system.repository;

import com.essenciacriativa.system.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByClienteId(Long id);
}
