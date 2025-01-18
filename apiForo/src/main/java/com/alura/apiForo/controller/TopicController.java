package com.alura.apiForo.controller;

import com.alura.apiForo.domain.topico.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    //Registrar un topico nuevo
    @PostMapping
    public ResponseEntity<DatosRespuestaTopic> regristarTopic(@RequestBody @Valid DatosRegistroTopic datosRegistroTopic,
                                                              UriComponentsBuilder uriComponentsBuilder)
    {

        Topic topico=topicRepository.save(new Topic(datosRegistroTopic));


        DatosRespuestaTopic datosRespuestaTopic= new DatosRespuestaTopic(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getNombreCurso());

        URI url= uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopic);

    }

    //Obtener todos los topicos
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopic>> obtenerTopicos(@PageableDefault(size = 10) Pageable paginacion) {
    return ResponseEntity.ok(topicRepository.findAllByStatusTrue(paginacion).map(DatosListadoTopic::new));
    }

    //Obtener un topico por id
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopic>obtenerTopicoId(@PathVariable Long id)
    {
        Topic topic= topicRepository.getReferenceById(id);
        var datorRespuestaTopic = new DatosRespuestaTopic(topic.getId(),topic.getTitulo(),topic.getMensaje(),topic.getNombreCurso());

        return ResponseEntity.ok(datorRespuestaTopic);


    }

    //Actualisar un topico
    @PutMapping
    @Transactional
    public ResponseEntity actulisarTopic(@RequestBody @Valid DatosActualisarTopic datosActualisarTopic)
    {

        Topic topic= topicRepository.getReferenceById(datosActualisarTopic.id());

        topic.actualisarDatos(datosActualisarTopic);
        var datosRespuestaTopic = new DatosRespuestaTopic(topic.getId(),topic.getTitulo(),topic.getMensaje(),topic.getNombreCurso());

        return ResponseEntity.ok(datosRespuestaTopic);

    }

    //Delete fisico topic
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id)
    {
        topicRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }



}
