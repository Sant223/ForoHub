CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(500) NOT NULL,
    fecha_de_creacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    usuario_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_topico_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id)
);