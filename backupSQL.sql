-- Criação da tabela contatos
CREATE TABLE contatos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255),
    chave INTEGER (6),
);

-- Inserção de 20 linhas de dados aleatórios
INSERT INTO contatos (nome, telefone, email, chave) VALUES
('João', '91234567890', 'joão@teste.com', 0),
('Maria', '91345678901', 'maria@teste.com', 0),
('Pedro', '91456789012', 'pedro@teste.com', 0),
('Ana', '91567890123', 'ana@teste.com', 0),
('Carlos', '91678901234', 'carlos@teste.com', 0),
('Paula', '91789012345', 'paula@teste.com', 0),
('José', '91890123456', 'josé@teste.com', 0),
('Fernanda', '91901234567', 'fernanda@teste.com', 0),
('Lucas', '92012345678', 'lucas@teste.com', 0),
('Juliana', '92123456789', 'juliana@teste.com', 0),
('Rafael', '92234567890', 'rafael@teste.com', 0),
('Larissa', '92345678901', 'larissa@teste.com', 0),
('Bruno', '92456789012', 'bruno@teste.com', 0),
('Camila', '92567890123', 'camila@teste.com', 0),
('Gustavo', '92678901234', 'gustavo@teste.com', 0),
('Simone', '92789012345', 'simone@teste.com', 0),
('Eduardo', '92890123456', 'eduardo@teste.com', 0),
('Tatiane', '92901234567', 'tatiane@teste.com', 0),
('Thiago', '93012345678', 'thiago@teste.com', 0);

CREATE TABLE usurarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255)
);

-- Inserção de USUARIO ADMIM
INSERT INTO contatos (id, nome, email, senha) VALUES
('0', 'Admin', 'admin@admin.com', 1234);