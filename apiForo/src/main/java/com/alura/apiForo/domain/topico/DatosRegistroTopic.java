package com.alura.apiForo.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopic(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String nombreCurso
       ) {
}
