package com.essenciacriativa.system.repository;

import com.essenciacriativa.system.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
