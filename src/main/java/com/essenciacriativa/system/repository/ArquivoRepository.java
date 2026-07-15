package com.essenciacriativa.system.repository;

import com.essenciacriativa.system.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
}
