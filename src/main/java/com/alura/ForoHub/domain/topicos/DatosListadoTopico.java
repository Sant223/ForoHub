package com.alura.ForoHub.domain.topicos;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id, String titulo, String mensaje, LocalDateTime fechaDeCreacion, Status status
) {

    public DatosListadoTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFechaDeCreacion(),
                topico.getStatus());
    }
}
