package com.alura.ForoHub.domain.topicos;

import com.alura.ForoHub.domain.usuarios.Usuario;
import com.alura.ForoHub.domain.usuarios.UsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity(name="Topico")
@Table(name="topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @Column(name="fecha_de_creacion")
    private LocalDateTime fechaDeCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    private boolean activo;

    private String curso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    public Topico(DatosRegistroTopico datos, Usuario usuario) {
        this.titulo = datos.titulo();
        this.activo = true;
        this.mensaje = datos.mensaje();
        this.curso = datos.curso();
        this.autor = usuario;
        this.fechaDeCreacion = LocalDateTime.now();
        this.status = Status.ABIERTO ;
    }
    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico){
        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.curso() != null){
            this.curso = datosActualizarTopico.curso();
        }
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
    }

    public void desactivarTopico(){
        this.activo = false;
    }
}
