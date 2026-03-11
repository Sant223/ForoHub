package com.alura.ForoHub.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DatosAutenticacionUsuario(
        @NotNull
        String correoElectronico,
        @NotNull
        String contrasena
) {
}
