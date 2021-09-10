-- Cria tabela usuarios
CREATE TABLE usuarios (
    id SERIAL NOT NULL,
    nome VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    senha VARCHAR(250) NOT NULL,
    PRIMARY KEY(id)
);

-- Cria tabela perfis
CREATE TABLE perfis (
    id SERIAL NOT NULL,
    nome VARCHAR(250) NOT NULL,
    PRIMARY KEY(id)
);

-- Cria tabela associativa de usuarios e perfis
CREATE TABLE usuario_perfil (
    id_usuario INT NOT NULL,
    id_perfil INT NOT NULL,
    PRIMARY KEY(id_usuario, id_perfil)
);

-- Adiciona as chaves estrangeiras de usuarios e perfis na tabela usuario_perfil
ALTER TABLE usuario_perfil ADD CONSTRAINT fk_usuario_perfil_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id);
ALTER TABLE usuario_perfil ADD CONSTRAINT fk_usuario_perfil_perfil FOREIGN KEY (id_perfil) REFERENCES perfis  (id) ; 

-- Insere um usuário
INSERT INTO usuarios(
    nome,
    email,
    senha 
) VALUES (
    'Tião da Silva',
    'tiao@email.com',
    '$2a$10$iYX7GOoh72wcl6kRNRwl3.CV7aYmwLmdqGdvJYStNyYrckk5M/O4O' --123456
);

-- Insere alguns perfis
INSERT INTO perfis(nome) VALUES ('ADMINISTRADOR');
INSERT INTO perfis(nome) VALUES ('CLIENTE');

-- Insere a associação entre o usuário e o perfil
INSERT INTO usuario_perfil(id_usuario, id_perfil) VALUES (1, 1);