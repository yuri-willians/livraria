-- Cria tabela editoras
CREATE TABLE editoras (
	id SERIAL NOT NULL,
	nome VARCHAR(250) NOT NULL,
	PRIMARY KEY(id)
);

-- Cria tabela livros
CREATE TABLE livros (
	id SERIAL,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(250),
	id_editora INT NOT NULL,
	PRIMARY KEY (id)
);

-- Adiciona a chave estrangeira de editara na tabela livros
ALTER TABLE livros ADD CONSTRAINT fk_livro_editora FOREIGN KEY (id_editora) REFERENCES editoras (id);

-- Cria tablea autores
CREATE TABLE autores (
	id SERIAL NOT NULL,
	nome VARCHAR(250) NOT NULL,
	PRIMARY KEY (id)
);

-- Cria tabela associativa de autores e livros
CREATE TABLE autor_livro (
	autor_id INT NOT NULL,
	livro_id INT NOT NULL,
	PRIMARY KEY (autor_id, livro_id)
);

-- Adiciona as chaves estrangeiras de editora e livrosna tabela autor_livro
ALTER TABLE autor_livro ADD CONSTRAINT fk_autor_livro_autor FOREIGN KEY (autor_id) REFERENCES autores (id);
ALTER TABLE autor_livro ADD CONSTRAINT fk_autor_livro_livro FOREIGN KEY (livro_id) REFERENCES livros (id);

-- Insere algumas editoras
INSERT INTO editoras(nome) VALUES ('HarperCollins');
INSERT INTO editoras(nome) VALUES ('Nova Fronteira');
INSERT INTO editoras(nome) VALUES ('Antofagica');
INSERT INTO editoras(nome) VALUES ('Alta Books');

-- Insera alguns autores
INSERT INTO autores(nome) VALUES ('Agatha Christie');
INSERT INTO autores(nome) VALUES ('Charles Dickens');
INSERT INTO autores(nome) VALUES ('Bert Bates');
INSERT INTO autores(nome) VALUES ('Kathy Sierra');


