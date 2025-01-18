package com.alura.apiForo.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopic(Long id, String titulo, String mensaje, LocalDateTime fechacreacion)
{

    public DatosListadoTopic(Topic topic)
    {
        this(topic.getId(),topic.getTitulo(),topic.getNombreCurso(),topic.getFechacreacion());

    }


}
