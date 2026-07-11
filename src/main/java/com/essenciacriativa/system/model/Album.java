package com.essenciacriativa.system.model;

import com.essenciacriativa.system.enums.StatusAlbum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "albuns")

public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Date data_ensaio;

    @Column
    private Date expiracao;

    @Column
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAlbum statusAlbum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Arquivo> arquivos = new ArrayList<>();

}
