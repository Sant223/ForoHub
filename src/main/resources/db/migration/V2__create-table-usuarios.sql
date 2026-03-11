CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    correoElectronico VARCHAR(100) NOT NULL,
    contraseña datetime NOT NULL,

    PRIMARY KEY (id)
);