CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100),
    senha VARCHAR(100)
);

INSERT INTO usuario (email, senha) VALUES ('usuario@exemplo.com', '1234');
INSERT INTO usuario (email, senha) VALUES ('empresa@exemplo.com', '12345');
