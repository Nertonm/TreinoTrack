-- Criação do Banco de Dados
CREATE DATABASE IF NOT EXISTS FitLife;
USE FitLife;

-- -----------------------------------------------------
-- Tabela de Usuários
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS USUARIO (
    ID_USUARIO INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) UNIQUE NOT NULL,
    CPF CHAR(11) UNIQUE NOT NULL,
    DATA_NASCIMENTO DATE NOT NULL,
    TIPO ENUM('aluno', 'personal') NOT NULL,
    DATA_CADASTRO DATETIME DEFAULT CURRENT_TIMESTAMP
) COMMENT 'Armazena informações dos usuários do sistema';

-- -----------------------------------------------------
-- Tabela de Equipamentos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS EQUIPAMENTO (
    ID_EQUIPAMENTO INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    DESCRICAO TEXT,
    STATUS ENUM('ativo', 'inativo', 'manutencao') DEFAULT 'ativo'
) COMMENT 'Cadastro de equipamentos disponíveis na academia';

-- -----------------------------------------------------
-- Tabela de Músculos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  MUSCULO (
    ID_MUSCULO INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    GRUPO_MUSCULAR VARCHAR(50) NOT NULL
) COMMENT 'Grupos musculares trabalhados pelos exercícios';

-- -----------------------------------------------------
-- Tabela de Exercícios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  EXERCICIO (
    ID_EXERCICIO INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    CATEGORIA VARCHAR(50) NOT NULL,
    ID_EQUIPAMENTO INT NULL,
    INSTRUCOES TEXT,
    NIVEL_DIFICULDADE ENUM('iniciante', 'intermediario', 'avancado') DEFAULT 'iniciante',
    FOREIGN KEY (ID_EQUIPAMENTO) 
        REFERENCES EQUIPAMENTO(ID_EQUIPAMENTO)
        ON DELETE SET NULL
) COMMENT 'Exercícios disponíveis no sistema';

-- -----------------------------------------------------
-- Tabela de Relação Exercício x Músculo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS EXERCICIO_MUSCULO (
    ID_EXERCICIO INT NOT NULL,
    ID_MUSCULO INT NOT NULL,
    INTENSIDADE ENUM('primario', 'secundario') DEFAULT 'primario',
    PRIMARY KEY (ID_EXERCICIO, ID_MUSCULO),
    FOREIGN KEY (ID_EXERCICIO) 
        REFERENCES EXERCICIO(ID_EXERCICIO)
        ON DELETE CASCADE,
    FOREIGN KEY (ID_MUSCULO) 
        REFERENCES MUSCULO(ID_MUSCULO)
        ON DELETE CASCADE
) COMMENT 'Relação N:N entre exercícios e músculos trabalhados';

-- -----------------------------------------------------
-- Tabela de Treinos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TREINO (
    ID_TREINO INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    DURACAO_PADRAO INT NOT NULL COMMENT 'Duração em minutos',
    OBJETIVO VARCHAR(100) NOT NULL,
    CATEGORIA VARCHAR(50) NOT NULL,
    ID_PERSONAL_CRIADOR INT NULL,
    DATA_CRIACAO DATETIME DEFAULT CURRENT_TIMESTAMP,
    CHECK (DURACAO_PADRAO >= 0),
    FOREIGN KEY (ID_PERSONAL_CRIADOR) 
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE SET NULL
) COMMENT 'Rotinas de treino criadas pelos personais';

-- -----------------------------------------------------
-- Tabela de Relação Treino x Exercício
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  TREINO_EXERCICIO (
    ID_TREINO INT NOT NULL,
    ID_EXERCICIO INT NOT NULL,
    ORDEM INT NOT NULL,
    SERIES INT NOT NULL,
    REPETICOES VARCHAR(20) NOT NULL COMMENT 'Pode ser um número ou intervalo (ex: 8-12)',
    DESCANSO INT COMMENT 'Tempo em segundos',
    OBSERVACOES TEXT,
    PRIMARY KEY (ID_TREINO, ID_EXERCICIO, ORDEM),
    FOREIGN KEY (ID_TREINO) 
        REFERENCES TREINO(ID_TREINO)
        ON DELETE CASCADE,
    FOREIGN KEY (ID_EXERCICIO) 
        REFERENCES EXERCICIO(ID_EXERCICIO)
        ON DELETE CASCADE,
    CHECK (SERIES > 0),
    CHECK (ORDEM > 0)
) COMMENT 'Exercícios que compõem cada treino';

-- -----------------------------------------------------
-- Tabela de Avaliação Física
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  AVALIACAO_FISICA (
    ID_AVALIACAO INT PRIMARY KEY AUTO_INCREMENT,
    ID_ALUNO INT NOT NULL,
    ID_PERSONAL INT NOT NULL,
    DATA_AVALIACAO DATETIME NOT NULL,
    PESO DECIMAL(5,2) COMMENT 'Em kg',
    ALTURA INT COMMENT 'Em cm',
    PERCENTUAL_GORDURA DECIMAL(5,2),
    MASSA_MUSCULAR DECIMAL(5,2),
    CIRCUNFERENCIAS TEXT COMMENT 'JSON com medidas corporais',
    OBSERVACOES TEXT,
    FOREIGN KEY (ID_ALUNO) 
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE CASCADE,
    FOREIGN KEY (ID_PERSONAL) 
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE CASCADE
) COMMENT 'Avaliações físicas dos alunos';

-- -----------------------------------------------------
-- Tabela de Associação Usuário x Treino (Rotinas)
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS USUARIO_TREINO (
    ID_USUARIO INT NOT NULL,
    ID_TREINO INT NOT NULL,
    DATA_ASSOCIACAO DATETIME DEFAULT CURRENT_TIMESTAMP,
    ATIVO BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (ID_USUARIO, ID_TREINO),
    FOREIGN KEY (ID_USUARIO) 
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE CASCADE,
    FOREIGN KEY (ID_TREINO) 
        REFERENCES TREINO(ID_TREINO)
        ON DELETE CASCADE
) COMMENT 'Treinos atribuídos a cada usuário';

-- -----------------------------------------------------
-- Tabela de Registro de Treinos Realizados
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  REGISTRO_TREINO (
    ID_REGISTRO INT PRIMARY KEY AUTO_INCREMENT,
    ID_USUARIO INT NOT NULL,
    ID_TREINO INT NOT NULL,
    DATA_INICIO DATETIME NOT NULL,
    DATA_FIM DATETIME NOT NULL,
    CALORIAS_QUEIMADAS FLOAT NOT NULL,
    FEEDBACK TEXT,
    FOREIGN KEY (ID_USUARIO) 
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE CASCADE,
    FOREIGN KEY (ID_TREINO) 
        REFERENCES TREINO(ID_TREINO)
        ON DELETE CASCADE,
    CHECK (CALORIAS_QUEIMADAS >= 0),
    CHECK (DATA_FIM > DATA_INICIO)
) COMMENT 'Registro de treinos realizados pelos usuários';

-- -----------------------------------------------------
-- Tabela de Metas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS META (
    ID_META INT PRIMARY KEY AUTO_INCREMENT,
    ID_ALUNO INT NOT NULL,
    TITULO VARCHAR(100) NOT NULL,
    DESCRICAO TEXT NOT NULL,
    TIPO ENUM('perda_peso', 'ganho_massa', 'resistencia', 'outro') NOT NULL,
    VALOR_ALVO DECIMAL(10,2) NOT NULL,
    UNIDADE VARCHAR(20) NOT NULL,
    DATA_CRIACAO DATETIME DEFAULT CURRENT_TIMESTAMP,
    DATA_LIMITE DATE,
    CONCLUIDA BOOLEAN DEFAULT FALSE,
    DATA_CONCLUSAO DATETIME NULL,
    FOREIGN KEY (ID_ALUNO) 
        REFERENCES USUARIO(ID_USUARIO)
        ON DELETE CASCADE
) COMMENT 'Metas de condicionamento físico dos alunos';