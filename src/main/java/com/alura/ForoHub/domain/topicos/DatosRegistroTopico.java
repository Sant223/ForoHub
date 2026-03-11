package com.alura.ForoHub.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull Long idUsuario,
        @NotNull String mensaje,
        @NotNull String curso,
        @NotNull String titulo




) {
}
