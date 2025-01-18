package com.alura.apiForo.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualisarTopic(@NotNull Long id, @NotBlank String titulo,@NotBlank String mensaje ,@NotBlank String nombreCurso) {
}
