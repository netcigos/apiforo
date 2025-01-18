package com.alura.apiForo.domain.topico;

import com.alura.apiForo.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "topics")
@Entity(name = "Topic")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String nombreCurso;
    private LocalDateTime fechacreacion;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Topic(DatosRegistroTopic datosRegistroTopic)
    {

        this.titulo=datosRegistroTopic.titulo();
        this.mensaje= datosRegistroTopic.mensaje();;
        this.nombreCurso= datosRegistroTopic.nombreCurso();;
        this.status=true;
        this.fechacreacion=LocalDateTime.now();



    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public LocalDateTime getFechacreacion() {
        return fechacreacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //Actualisa los datos de un topic
    public void actualisarDatos(DatosActualisarTopic datosActualisarTopic)
    {
        if(datosActualisarTopic.titulo()!=null)
        {
            this.titulo=datosActualisarTopic.titulo();

        }

        if(datosActualisarTopic.mensaje()!=null)
        {
            this.mensaje=datosActualisarTopic.mensaje();

        }

        if(datosActualisarTopic.nombreCurso()!=null)
        {

            this.nombreCurso=datosActualisarTopic.nombreCurso();

        }


    }
}
