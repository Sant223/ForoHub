package com.alura.ForoHub.domain.topicos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        @JsonAlias("titulo") String titulo,
        @JsonAlias("mensaje")  String mensaje,
        @JsonAlias("curso")  String curso
) {
}
