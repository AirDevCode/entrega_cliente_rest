DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fecha_nacimiento DATETIME
);
