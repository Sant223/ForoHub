package com.alura.ForoHub.controller;

import com.alura.ForoHub.domain.topicos.*;
import com.alura.ForoHub.domain.usuarios.UsuarioRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos,
                                                                UriComponentsBuilder uriComponentsBuilder){

        var existeTopico = topicoRepository.existsByTituloIgnoreCase(datos.titulo());
        var existeMensaje = topicoRepository.existsByMensajeIgnoreCase(datos.mensaje());
        if(existeTopico || existeMensaje){
            throw new RuntimeException("Ya existe un topico con ese titulo o mensaje");
        }

        var nuevoTopico = new Topico(datos,usuarioRepository.getReferenceById(datos.idUsuario()));
        topicoRepository.save((nuevoTopico));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(nuevoTopico.getId(), nuevoTopico.getTitulo(),
                nuevoTopico.getMensaje(),nuevoTopico.getCurso(),nuevoTopico.getFechaDeCreacion(), nuevoTopico.getStatus());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(nuevoTopico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size=2) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> detallarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getMensaje(),topico.getCurso(),topico.getFechaDeCreacion(),topico.getStatus());

        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getCurso(),topico.getFechaDeCreacion()
        ,topico.getStatus()));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
}
