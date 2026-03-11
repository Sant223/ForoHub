CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    fechaDeCreacion datetime NOT NULL,
    status VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);