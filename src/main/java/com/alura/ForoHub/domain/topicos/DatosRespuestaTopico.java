package com.alura.ForoHub.domain.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(

        Long id,
        String titulo,
        String mensaje,
        String curso,
        LocalDateTime fechaDeCreacion,
        Status status

) {
}
