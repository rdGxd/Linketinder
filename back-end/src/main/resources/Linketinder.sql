CREATE TABLE candidatos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    sobrenome VARCHAR NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    cpf VARCHAR UNIQUE NOT NULL,
    pais VARCHAR NOT NULL,
    cep VARCHAR NOT NULL,
    descricao_pessoal TEXT,
    senha VARCHAR NOT NULL
);

CREATE TABLE empresas (
    id SERIAL PRIMARY KEY,
    nome_empresa VARCHAR NOT NULL,
    cnpj VARCHAR UNIQUE NOT NULL,
    email_corporativo VARCHAR UNIQUE NOT NULL,
    descricao_empresa TEXT,
    pais VARCHAR NOT NULL,
    cep VARCHAR NOT NULL,
    senha VARCHAR NOT NULL
);

CREATE TABLE competencias (
    id SERIAL PRIMARY KEY,
    nome_competencia VARCHAR NOT NULL
);

CREATE TABLE vagas (
    id SERIAL PRIMARY KEY,
    id_empresa INT REFERENCES empresas(id) ON DELETE CASCADE,
    nome_vaga VARCHAR NOT NULL,
    descricao_vaga TEXT,
    local VARCHAR NOT NULL
);

CREATE TABLE candidatos_competencias (
    id_candidato INT REFERENCES candidatos(id) ON DELETE CASCADE,
    id_competencia INT REFERENCES competencias(id) ON DELETE CASCADE,
    PRIMARY KEY (id_candidato, id_competencia)
);

CREATE TABLE candidatos_vagas (
    id_candidato INT REFERENCES candidatos(id) ON DELETE CASCADE,
    id_vaga INT REFERENCES vagas(id) ON DELETE CASCADE,
    PRIMARY KEY (id_candidato, id_vaga)
);

CREATE TABLE vagas_competencias (
                                    id_vaga INT REFERENCES vagas(id) ON DELETE CASCADE,
                                    id_competencia INT REFERENCES competencias(id) ON DELETE CASCADE,
                                    PRIMARY KEY (id_vaga, id_competencia)
);


INSERT INTO candidatos (nome, sobrenome, data_nascimento, email, cpf, pais, cep, descricao_pessoal, senha)
VALUES ('Sandubinha', 'Exemplo', '1990-01-01', 'sandubinha@example.com', '12345678901', 'Brasil', '12345678', 'Desenvolvedor full stack', 'senha123');

INSERT INTO empresas (nome_empresa, cnpj, email_corporativo, descricao_empresa, pais, cep, senha)
VALUES ('Pastelsoft', '12345678000195', 'contato@pastelsoft.com', 'Desenvolvedora de softwares ERPs', 'Brasil', '12345678', 'senha456');

INSERT INTO competencias (nome_competencia)
VALUES ('Python'), ('Java'), ('Angular');

INSERT INTO vagas (id_empresa, nome_vaga, descricao_vaga, local)
VALUES (1, 'Desenvolvedor Backend', 'Desenvolvimento de APIs', 'São Paulo');

INSERT INTO candidatos_vagas (id_candidato, id_vaga)
VALUES (1, 1);

INSERT INTO vagas_competencias (id_vaga, id_competencia)
VALUES (1, 1), (1, 2);

-- Exibir Candidatos com Competências
SELECT c.nome, c.sobrenome, comp.nome_competencia
FROM candidatos c
JOIN candidatos_competencias cc ON c.id = cc.id_candidato
JOIN competencias comp ON cc.id_competencia = comp.id;

-- Exibir Vagas Curtidas pelos Candidatos
SELECT c.nome, v.nome_vaga
FROM candidatos c
JOIN candidatos_vagas cv ON c.id = cv.id_candidato
JOIN vagas v ON cv.id_vaga = v.id;


-- Exibir Vagas com Competências
SELECT v.nome_vaga, comp.nome_competencia
FROM vagas v
         JOIN vagas_competencias vc ON v.id = vc.id_vaga
         JOIN competencias comp ON vc.id_competencia = comp.id;
