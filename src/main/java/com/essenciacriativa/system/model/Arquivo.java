package com.essenciacriativa.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "arquivos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeOriginal;

    @Column(nullable = false, unique = true)
    private String chaveStorage;

    @Column
    private String tipo;

    @Column(nullable = false)
    private Long tamanhoBytes;

    @Column
    private LocalDateTime criadoEm;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "album_id")
    private Album album;
}
