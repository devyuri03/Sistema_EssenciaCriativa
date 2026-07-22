package com.essenciacriativa.system.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlbumRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @Nullable @NotNull(message = "A data do ensaio deve ser obrigatória")
        LocalDate dataEnsaio,

        @Nullable @NotNull(message = "A expiração do album deve ser inserida")
        LocalDate expiraEm,

        @NotNull(message = "O cliente é obrigatório")
        Long clienteId
)

{}
