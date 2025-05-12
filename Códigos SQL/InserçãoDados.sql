USE FitLife;

-- Inserção de usuários (atualizado para 2025)
INSERT INTO USUARIO (NOME, EMAIL, CPF, DATA_NASCIMENTO, TIPO) VALUES
('João Silva', 'joao.silva@email.com', '12345678901', '1990-05-15', 'aluno'),
('Maria Oliveira', 'maria.oliveira@email.com', '23456789012', '1985-08-22', 'aluno'),
('Carlos Souza', 'carlos.souza@email.com', '34567890123', '1992-03-10', 'personal'),
('Ana Pereira', 'ana.pereira@email.com', '45678901234', '1988-11-30', 'personal'),
('Pedro Costa', 'pedro.costa@email.com', '56789012345', '1995-07-18', 'aluno'),
('Atleta Dedicação', 'atleta.dedicacao@email.com', '99988877766', '1988-04-25', 'aluno'),
('Frequente Semanal', 'frequente.semanal@email.com', '11122233344', '1993-09-12', 'aluno');

-- Inserção de Equipamentos
INSERT INTO EQUIPAMENTO (NOME, DESCRICAO, STATUS) VALUES
('Esteira', 'Esteira elétrica modelo XT-200', 'ativo'),
('Bicicleta Ergométrica', 'Bicicleta com monitor de frequência cardíaca', 'ativo'),
('Halteres', 'Conjunto de halteres de 1 a 20kg', 'ativo'),
('Banco de Supino', 'Banco ajustável para supino e outros exercícios', 'ativo'),
('Barra Fixa', 'Barra para exercícios de pull-up', 'ativo'),
('Corda de Pular', 'Corda de pular profissional', 'ativo'),
('Kettlebell', 'Peso russo de 8kg', 'manutencao'),
('Máquina de Leg Press', 'Máquina para exercícios de perna', 'ativo');

-- ----------------------------USE FitLife;

-- Inserção de usuários (atualizado para 2025)
INSERT INTO USUARIO (NOME, EMAIL, CPF, DATA_NASCIMENTO, TIPO) VALUES
('João Silva', 'joao.silva@email.com', '12345678901', '1990-05-15', 'aluno'),
('Maria Oliveira', 'maria.oliveira@email.com', '23456789012', '1985-08-22', 'aluno'),
('Carlos Souza', 'carlos.souza@email.com', '34567890123', '1992-03-10', 'personal'),
('Ana Pereira', 'ana.pereira@email.com', '45678901234', '1988-11-30', 'personal'),
('Pedro Costa', 'pedro.costa@email.com', '56789012345', '1995-07-18', 'aluno'),
('Atleta Dedicação', 'atleta.dedicacao@email.com', '99988877766', '1988-04-25', 'aluno'),
('Frequente Semanal', 'frequente.semanal@email.com', '11122233344', '1993-09-12', 'aluno');

-- Inserção de Equipamentos
INSERT INTO EQUIPAMENTO (NOME, DESCRICAO, STATUS) VALUES
('Esteira', 'Esteira elétrica modelo XT-200', 'ativo'),
('Bicicleta Ergométrica', 'Bicicleta com monitor de frequência cardíaca', 'ativo'),
('Halteres', 'Conjunto de halteres de 1 a 20kg', 'ativo'),
('Banco de Supino', 'Banco ajustável para supino e outros exercícios', 'ativo'),
('Barra Fixa', 'Barra para exercícios de pull-up', 'ativo'),
('Corda de Pular', 'Corda de pular profissional', 'ativo'),
('Kettlebell', 'Peso russo de 8kg', 'manutencao'),
('Máquina de Leg Press', 'Máquina para exercícios de perna', 'ativo');

-- -----------------------------------------------------
-- Inserção de Músculos
-- -----------------------------------------------------
INSERT INTO MUSCULO (NOME, GRUPO_MUSCULAR) VALUES
('Peitoral Maior', 'Tórax'),
('Deltóide', 'Ombros'),
('Tríceps Braquial', 'Braços'),
('Bíceps Braquial', 'Braços'),
('Reto Abdominal', 'Abdômen'),
('Quadríceps Femoral', 'Pernas'),
('Isquiotibiais', 'Pernas'),
('Glúteo Máximo', 'Pernas'),
('Trapézio', 'Costas'),
('Latíssimo do Dorso', 'Costas');

-- -----------------------------------------------------
-- Inserção de Exercícios
-- -----------------------------------------------------
INSERT INTO EXERCICIO (NOME, CATEGORIA, ID_EQUIPAMENTO, INSTRUCOES, NIVEL_DIFICULDADE) VALUES
('Supino Reto', 'Musculação', 4, 'Deitar no banco e empurrar a barra para cima', 'intermediario'),
('Agachamento Livre', 'Musculação', NULL, 'Manter as costas retas e descer até 90 graus', 'intermediario'),
('Corrida Estacionária', 'Cardio', 1, 'Manter ritmo constante por 30 minutos', 'iniciante'),
('Remada Curvada', 'Musculação', 3, 'Dobrar levemente os joelhos e puxar os pesos', 'avancado'),
('Flexão de Braço', 'Calistenia', NULL, 'Manter o corpo alinhado durante o movimento', 'iniciante'),
('Pull-up', 'Calistenia', 5, 'Puxar o corpo até o queixo passar a barra', 'avancado'),
('Abdominal Crunch', 'Core', NULL, 'Contrair o abdômen ao levantar o tronco', 'iniciante'),
('Leg Press', 'Musculação', 8, 'Empurrar a plataforma com as pernas', 'intermediario'),
('Corda Naval', 'Cardio', NULL, 'Ondular a corda alternando os braços', 'intermediario'),
('Pular Corda', 'Cardio', 6, 'Manter ritmo constante com saltos baixos', 'iniciante');

-- -----------------------------------------------------
-- Inserção de Exercício x Músculo
-- -----------------------------------------------------
INSERT INTO EXERCICIO_MUSCULO (ID_EXERCICIO, ID_MUSCULO, INTENSIDADE) VALUES
(1, 1, 'primario'), (1, 2, 'secundario'), (1, 3, 'secundario'),
(2, 6, 'primario'), (2, 7, 'secundario'), (2, 8, 'secundario'),
(4, 9, 'primario'), (4, 10, 'primario'), (4, 4, 'secundario'),
(6, 10, 'primario'), (6, 4, 'secundario'),
(8, 6, 'primario'), (8, 7, 'secundario'), (8, 8, 'secundario');

-- -----------------------------------------------------
-- Inserção de Treinos (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO TREINO (NOME, DURACAO_PADRAO, OBJETIVO, CATEGORIA, ID_PERSONAL_CRIADOR, DATA_CRIACAO) VALUES
('Treino Iniciante A', 45, 'Adaptação muscular', 'Iniciante', 3, '2025-01-10 09:00:00'),
('Treino Iniciante B', 45, 'Resistência cardiorrespiratória', 'Iniciante', 3, '2025-01-12 09:00:00'),
('Treino Avançado Peito', 60, 'Hipertrofia peitoral', 'Musculação', 4, '2025-01-15 10:00:00'),
('Treino Avançado Costas', 60, 'Força nas costas', 'Musculação', 4, '2025-01-18 10:00:00'),
('Treino Cardio Intenso', 30, 'Queima de gordura', 'Cardio', 4, '2025-02-01 08:00:00'),
('Treino Completo', 90, 'Condicionamento geral', 'Misto', 3, '2025-02-05 09:00:00'),
('Treino Abdômen', 20, 'Definição abdominal', 'Core', 4, '2025-02-10 11:00:00'),
('Treino Inferior', 50, 'Fortalecimento de pernas', 'Musculação', 3, '2025-02-15 09:00:00');

-- -----------------------------------------------------
-- Inserção de Treino x Exercício
-- -----------------------------------------------------
INSERT INTO TREINO_EXERCICIO (ID_TREINO, ID_EXERCICIO, ORDEM, SERIES, REPETICOES, DESCANSO, OBSERVACOES) VALUES
(1, 5, 1, 3, '10-12', 60, 'Manter postura reta'), (1, 7, 2, 3, '15', 45, 'Contrair abdômen'), (1, 3, 3, 1, '20min', NULL, 'Ritmo moderado'),
(2, 10, 1, 5, '1min', 30, 'Manter ritmo constante'), (2, 7, 2, 4, '12', 45, NULL),
(3, 1, 1, 4, '8-10', 90, 'Cuidado com ombros'), (3, 5, 2, 3, '12', 60, NULL),
(4, 6, 1, 4, '6-8', 120, NULL), (4, 4, 2, 3, '10', 90, NULL),
(5, 9, 1, 3, '30seg', 60, 'Intervalo ativo'), (5, 10, 2, 3, '1min', 60, NULL),
(6, 1, 1, 3, '10', 90, NULL), (6, 4, 2, 3, '10', 90, NULL), (6, 2, 3, 3, '12', 90, NULL),
(7, 7, 1, 4, '15', 30, NULL),
(8, 2, 1, 4, '10', 90, NULL), (8, 8, 2, 3, '12', 90, NULL);

-- -----------------------------------------------------
-- Inserção de Avaliações Físicas (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO AVALIACAO_FISICA (ID_ALUNO, ID_PERSONAL, DATA_AVALIACAO, PESO, ALTURA, PERCENTUAL_GORDURA, MASSA_MUSCULAR, CIRCUNFERENCIAS) VALUES
(1, 3, '2025-03-01 10:00:00', 78.5, 175, 18.2, 35.5, '{"braco": 32, "peito": 95, "cintura": 80}'),
(1, 3, '2025-04-01 10:00:00', 76.8, 175, 16.8, 36.2, '{"braco": 33, "peito": 96, "cintura": 78}'),
(2, 4, '2025-03-05 14:00:00', 65.2, 168, 22.5, 28.7, '{"braco": 28, "peito": 88, "cintura": 72}'),
(5, 3, '2025-03-10 09:00:00', 85.0, 182, 20.1, 40.1, '{"braco": 35, "peito": 100, "cintura": 86}');

-- -----------------------------------------------------
-- Inserção de Usuário x Treino (Rotinas) (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO USUARIO_TREINO (ID_USUARIO, ID_TREINO, DATA_ASSOCIACAO, ATIVO) VALUES
(1, 1, '2025-03-02 08:00:00', TRUE), (1, 2, '2025-03-02 08:00:00', TRUE),
(2, 6, '2025-03-06 10:00:00', TRUE), (2, 7, '2025-03-06 10:00:00', FALSE),
(5, 3, '2025-03-11 07:00:00', TRUE), (5, 4, '2025-03-11 07:00:00', TRUE), (5, 8, '2025-03-18 07:00:00', TRUE),
(6, 1, '2025-04-01 08:00:00', TRUE), (6, 3, '2025-04-01 08:00:00', TRUE), (6, 5, '2025-04-01 08:00:00', TRUE), (6, 7, '2025-04-01 08:00:00', TRUE),
(7, 1, '2025-04-15 07:00:00', TRUE), (7, 2, '2025-04-15 07:00:00', TRUE), (7, 3, '2025-04-15 07:00:00', TRUE), (7, 5, '2025-04-15 07:00:00', TRUE), (7, 6, '2025-04-15 07:00:00', TRUE);

-- -----------------------------------------------------
-- Inserção de Registros de Treino Realizados (atualizado para 2025)
-- -----------------------------------------------------
-- Usuário 6 (Atleta Dedicação) - 25 sessões nos últimos 3 meses
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS, FEEDBACK) VALUES
(6, 1, '2025-04-05 08:00:00', '2025-04-05 08:45:00', 220, 'Bom treino matinal'),
(6, 2, '2025-04-07 17:30:00', '2025-04-07 18:15:00', 250, NULL),
(6, 3, '2025-04-10 09:00:00', '2025-04-10 10:00:00', 320, 'Foco no peito'),
(6, 5, '2025-04-12 07:00:00', '2025-04-12 07:30:00', 180, 'Cardio intenso'),
(6, 1, '2025-04-14 08:00:00', '2025-04-14 08:50:00', 230, NULL),
(6, 4, '2025-04-17 18:00:00', '2025-04-17 19:05:00', 340, 'Costas doloridas'),
(6, 6, '2025-04-19 09:30:00', '2025-04-19 11:00:00', 450, 'Treino completo'),
(6, 2, '2025-04-21 16:00:00', '2025-04-21 16:45:00', 240, NULL),
(6, 3, '2025-04-24 10:00:00', '2025-04-24 11:00:00', 310, 'Melhorando técnica'),
(6, 5, '2025-04-26 07:30:00', '2025-04-26 08:00:00', 190, NULL),
(6, 1, '2025-04-28 08:30:00', '2025-04-28 09:20:00', 235, NULL),
(6, 4, '2025-05-01 17:30:00', '2025-05-01 18:35:00', 350, NULL),
(6, 6, '2025-05-03 09:00:00', '2025-05-03 10:30:00', 460, 'Bom desempenho'),
(6, 2, '2025-05-05 15:00:00', '2025-05-05 15:45:00', 245, NULL),
(6, 3, '2025-05-08 10:30:00', '2025-05-08 11:30:00', 325, NULL),
(6, 5, '2025-05-10 08:00:00', '2025-05-10 08:30:00', 195, 'Rápido mas intenso'),
(6, 1, '2025-05-12 09:00:00', '2025-05-12 09:50:00', 240, NULL),
(6, 4, '2025-05-15 18:00:00', '2025-05-15 19:05:00', 345, NULL),
(6, 6, '2025-05-17 10:00:00', '2025-05-17 11:30:00', 465, NULL),
(6, 2, '2025-05-19 16:30:00', '2025-05-19 17:15:00', 250, NULL),
(6, 3, '2025-05-22 09:30:00', '2025-05-22 10:30:00', 330, NULL),
(6, 5, '2025-05-24 07:30:00', '2025-05-24 08:00:00', 200, NULL),
(6, 1, '2025-05-26 08:30:00', '2025-05-26 09:20:00', 245, NULL),
(6, 4, '2025-05-29 17:00:00', '2025-05-29 18:05:00', 350, 'Último treino do mês'),
(6, 6, '2025-05-31 10:30:00', '2025-05-31 12:00:00', 470, NULL);

-- Usuário 7 (Frequente Semanal) - 5+ treinos por semana nos últimos 2 meses
-- Maio 2025 (6 treinos por semana)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS) VALUES
(7, 1, '2025-05-05 07:00:00', '2025-05-05 07:45:00', 220),
(7, 2, '2025-05-06 07:00:00', '2025-05-06 07:45:00', 230),
(7, 3, '2025-05-07 07:00:00', '2025-05-07 08:00:00', 310),
(7, 5, '2025-05-08 07:00:00', '2025-05-08 07:30:00', 180),
(7, 6, '2025-05-09 07:00:00', '2025-05-09 08:30:00', 450),
(7, 1, '2025-05-10 09:00:00', '2025-05-10 09:45:00', 225),
(7, 2, '2025-05-12 07:00:00', '2025-05-12 07:45:00', 235),
(7, 4, '2025-05-13 07:00:00', '2025-05-13 08:05:00', 340),
(7, 5, '2025-05-14 07:00:00', '2025-05-14 07:30:00', 185),
(7, 6, '2025-05-15 07:00:00', '2025-05-15 08:30:00', 455),
(7, 3, '2025-05-16 07:00:00', '2025-05-16 08:00:00', 315),
(7, 1, '2025-05-17 09:00:00', '2025-05-17 09:45:00', 230),
(7, 2, '2025-05-19 07:00:00', '2025-05-19 07:45:00', 240),
(7, 4, '2025-05-20 07:00:00', '2025-05-20 08:05:00', 345),
(7, 5, '2025-05-21 07:00:00', '2025-05-21 07:30:00', 190),
(7, 6, '2025-05-22 07:00:00', '2025-05-22 08:30:00', 460),
(7, 3, '2025-05-23 07:00:00', '2025-05-23 08:00:00', 320),
(7, 1, '2025-05-24 09:00:00', '2025-05-24 09:45:00', 235),
(7, 2, '2025-05-26 07:00:00', '2025-05-26 07:45:00', 245),
(7, 4, '2025-05-27 07:00:00', '2025-05-27 08:05:00', 350),
(7, 5, '2025-05-28 07:00:00', '2025-05-28 07:30:00', 195),
(7, 6, '2025-05-29 07:00:00', '2025-05-29 08:30:00', 465),
(7, 3, '2025-05-30 07:00:00', '2025-05-30 08:00:00', 325),
(7, 1, '2025-05-31 09:00:00', '2025-05-31 09:45:00', 240);

-- Abril 2025 (6 treinos por semana)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS) VALUES
(7, 2, '2025-04-01 07:00:00', '2025-04-01 07:45:00', 230),
(7, 3, '2025-04-02 07:00:00', '2025-04-02 08:00:00', 310),
(7, 5, '2025-04-03 07:00:00', '2025-04-03 07:30:00', 180),
(7, 6, '2025-04-04 07:00:00', '2025-04-04 08:30:00', 450),
(7, 1, '2025-04-05 09:00:00', '2025-04-05 09:45:00', 225),
(7, 2, '2025-04-07 07:00:00', '2025-04-07 07:45:00', 235),
(7, 4, '2025-04-08 07:00:00', '2025-04-08 08:05:00', 340),
(7, 5, '2025-04-09 07:00:00', '2025-04-09 07:30:00', 185),
(7, 6, '2025-04-10 07:00:00', '2025-04-10 08:30:00', 455),
(7, 3, '2025-04-11 07:00:00', '2025-04-11 08:00:00', 315),
(7, 1, '2025-04-12 09:00:00', '2025-04-12 09:45:00', 230),
(7, 2, '2025-04-14 07:00:00', '2025-04-14 07:45:00', 240),
(7, 4, '2025-04-15 07:00:00', '2025-04-15 08:05:00', 345),
(7, 5, '2025-04-16 07:00:00', '2025-04-16 07:30:00', 190),
(7, 6, '2025-04-17 07:00:00', '2025-04-17 08:30:00', 460),
(7, 3, '2025-04-18 07:00:00', '2025-04-18 08:00:00', 320),
(7, 1, '2025-04-19 09:00:00', '2025-04-19 09:45:00', 235),
(7, 2, '2025-04-21 07:00:00', '2025-04-21 07:45:00', 245),
(7, 4, '2025-04-22 07:00:00', '2025-04-22 08:05:00', 350),
(7, 5, '2025-04-23 07:00:00', '2025-04-23 07:30:00', 195),
(7, 6, '2025-04-24 07:00:00', '2025-04-24 08:30:00', 465),
(7, 3, '2025-04-25 07:00:00', '2025-04-25 08:00:00', 325),
(7, 1, '2025-04-26 09:00:00', '2025-04-26 09:45:00', 240),
(7, 2, '2025-04-28 07:00:00', '2025-04-28 07:45:00', 250),
(7, 4, '2025-04-29 07:00:00', '2025-04-29 08:05:00', 355),
(7, 5, '2025-04-30 07:00:00', '2025-04-30 07:30:00', 200);

-- Outros usuários (registros adicionais)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS, FEEDBACK) VALUES
(1, 1, '2025-05-28 08:00:00', '2025-05-28 08:47:00', 220, 'Bom treino'),
(1, 2, '2025-05-26 08:00:00', '2025-05-26 08:42:00', 180, NULL),
(1, 1, '2025-05-21 08:00:00', '2025-05-21 08:50:00', 240, 'Cansativo'),
(1, 2, '2025-05-19 08:00:00', '2025-05-19 08:45:00', 190, NULL),
(2, 6, '2025-05-27 10:00:00', '2025-05-27 11:28:00', 450, 'Treino completo'),
(2, 6, '2025-05-20 10:00:00', '2025-05-20 11:32:00', 480, NULL),
(5, 3, '2025-05-29 07:00:00', '2025-05-29 08:02:00', 320, 'Foco no peito'),
(5, 4, '2025-05-25 07:00:00', '2025-05-25 08:05:00', 340, NULL),
(5, 8, '2025-05-22 07:00:00', '2025-05-22 07:52:00', 280, 'Pernas doloridas');

-- -----------------------------------------------------
-- Inserção de Metas (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO META (ID_ALUNO, TITULO, DESCRICAO, TIPO, VALOR_ALVO, UNIDADE, DATA_CRIACAO, DATA_LIMITE, CONCLUIDA, DATA_CONCLUSAO) VALUES
-- Metas para João (ID 1)
(1, 'Perder 5kg', 'Reduzir percentual de gordura', 'perda_peso', 5, 'kg', '2025-03-02', '2025-06-30', FALSE, NULL),
(1, 'Correr 5km', 'Melhorar capacidade cardiorrespiratória', 'resistencia', 5, 'km', '2025-03-02', '2025-05-31', TRUE, '2025-05-15'),

-- Metas para Maria (ID 2)
(2, 'Ganhar massa muscular', 'Aumentar massa magra em 2kg', 'ganho_massa', 2, 'kg', '2025-03-06', '2025-07-31', FALSE, NULL),
(2, 'Treinar 3x por semana', 'Consistência nos treinos', 'outro', 3, 'vezes/semana', '2025-03-06', '2025-06-30', TRUE, '2025-05-20'),

-- Metas para Pedro (ID 5)USE FitLife;

-- Inserção de usuários (atualizado para 2025)
INSERT INTO USUARIO (NOME, EMAIL, CPF, DATA_NASCIMENTO, TIPO) VALUES
('João Silva', 'joao.silva@email.com', '12345678901', '1990-05-15', 'aluno'),
('Maria Oliveira', 'maria.oliveira@email.com', '23456789012', '1985-08-22', 'aluno'),
('Carlos Souza', 'carlos.souza@email.com', '34567890123', '1992-03-10', 'personal'),
('Ana Pereira', 'ana.pereira@email.com', '45678901234', '1988-11-30', 'personal'),
('Pedro Costa', 'pedro.costa@email.com', '56789012345', '1995-07-18', 'aluno'),
('Atleta Dedicação', 'atleta.dedicacao@email.com', '99988877766', '1988-04-25', 'aluno'),
('Frequente Semanal', 'frequente.semanal@email.com', '11122233344', '1993-09-12', 'aluno');

-- Inserção de Equipamentos
INSERT INTO EQUIPAMENTO (NOME, DESCRICAO, STATUS) VALUES
('Esteira', 'Esteira elétrica modelo XT-200', 'ativo'),
('Bicicleta Ergométrica', 'Bicicleta com monitor de frequência cardíaca', 'ativo'),
('Halteres', 'Conjunto de halteres de 1 a 20kg', 'ativo'),
('Banco de Supino', 'Banco ajustável para supino e outros exercícios', 'ativo'),
('Barra Fixa', 'Barra para exercícios de pull-up', 'ativo'),
('Corda de Pular', 'Corda de pular profissional', 'ativo'),
('Kettlebell', 'Peso russo de 8kg', 'manutencao'),
('Máquina de Leg Press', 'Máquina para exercícios de perna', 'ativo');

-- -----------------------------------------------------
-- Inserção de Músculos
-- -----------------------------------------------------
INSERT INTO MUSCULO (NOME, GRUPO_MUSCULAR) VALUES
('Peitoral Maior', 'Tórax'),
('Deltóide', 'Ombros'),
('Tríceps Braquial', 'Braços'),
('Bíceps Braquial', 'Braços'),
('Reto Abdominal', 'Abdômen'),
('Quadríceps Femoral', 'Pernas'),
('Isquiotibiais', 'Pernas'),
('Glúteo Máximo', 'Pernas'),
('Trapézio', 'Costas'),
('Latíssimo do Dorso', 'Costas');

-- -----------------------------------------------------
-- Inserção de Exercícios
-- -----------------------------------------------------
INSERT INTO EXERCICIO (NOME, CATEGORIA, ID_EQUIPAMENTO, INSTRUCOES, NIVEL_DIFICULDADE) VALUES
('Supino Reto', 'Musculação', 4, 'Deitar no banco e empurrar a barra para cima', 'intermediario'),
('Agachamento Livre', 'Musculação', NULL, 'Manter as costas retas e descer até 90 graus', 'intermediario'),
('Corrida Estacionária', 'Cardio', 1, 'Manter ritmo constante por 30 minutos', 'iniciante'),
('Remada Curvada', 'Musculação', 3, 'Dobrar levemente os joelhos e puxar os pesos', 'avancado'),
('Flexão de Braço', 'Calistenia', NULL, 'Manter o corpo alinhado durante o movimento', 'iniciante'),
('Pull-up', 'Calistenia', 5, 'Puxar o corpo até o queixo passar a barra', 'avancado'),
('Abdominal Crunch', 'Core', NULL, 'Contrair o abdômen ao levantar o tronco', 'iniciante'),
('Leg Press', 'Musculação', 8, 'Empurrar a plataforma com as pernas', 'intermediario'),
('Corda Naval', 'Cardio', NULL, 'Ondular a corda alternando os braços', 'intermediario'),
('Pular Corda', 'Cardio', 6, 'Manter ritmo constante com saltos baixos', 'iniciante');

-- -----------------------------------------------------
-- Inserção de Exercício x Músculo
-- -----------------------------------------------------
INSERT INTO EXERCICIO_MUSCULO (ID_EXERCICIO, ID_MUSCULO, INTENSIDADE) VALUES
(1, 1, 'primario'), (1, 2, 'secundario'), (1, 3, 'secundario'),
(2, 6, 'primario'), (2, 7, 'secundario'), (2, 8, 'secundario'),
(4, 9, 'primario'), (4, 10, 'primario'), (4, 4, 'secundario'),
(6, 10, 'primario'), (6, 4, 'secundario'),
(8, 6, 'primario'), (8, 7, 'secundario'), (8, 8, 'secundario');

-- -----------------------------------------------------
-- Inserção de Treinos (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO TREINO (NOME, DURACAO_PADRAO, OBJETIVO, CATEGORIA, ID_PERSONAL_CRIADOR, DATA_CRIACAO) VALUES
('Treino Iniciante A', 45, 'Adaptação muscular', 'Iniciante', 3, '2025-01-10 09:00:00'),
('Treino Iniciante B', 45, 'Resistência cardiorrespiratória', 'Iniciante', 3, '2025-01-12 09:00:00'),
('Treino Avançado Peito', 60, 'Hipertrofia peitoral', 'Musculação', 4, '2025-01-15 10:00:00'),
('Treino Avançado Costas', 60, 'Força nas costas', 'Musculação', 4, '2025-01-18 10:00:00'),
('Treino Cardio Intenso', 30, 'Queima de gordura', 'Cardio', 4, '2025-02-01 08:00:00'),
('Treino Completo', 90, 'Condicionamento geral', 'Misto', 3, '2025-02-05 09:00:00'),
('Treino Abdômen', 20, 'Definição abdominal', 'Core', 4, '2025-02-10 11:00:00'),
('Treino Inferior', 50, 'Fortalecimento de pernas', 'Musculação', 3, '2025-02-15 09:00:00');

-- -----------------------------------------------------
-- Inserção de Treino x Exercício
-- -----------------------------------------------------
INSERT INTO TREINO_EXERCICIO (ID_TREINO, ID_EXERCICIO, ORDEM, SERIES, REPETICOES, DESCANSO, OBSERVACOES) VALUES
(1, 5, 1, 3, '10-12', 60, 'Manter postura reta'), (1, 7, 2, 3, '15', 45, 'Contrair abdômen'), (1, 3, 3, 1, '20min', NULL, 'Ritmo moderado'),
(2, 10, 1, 5, '1min', 30, 'Manter ritmo constante'), (2, 7, 2, 4, '12', 45, NULL),
(3, 1, 1, 4, '8-10', 90, 'Cuidado com ombros'), (3, 5, 2, 3, '12', 60, NULL),
(4, 6, 1, 4, '6-8', 120, NULL), (4, 4, 2, 3, '10', 90, NULL),
(5, 9, 1, 3, '30seg', 60, 'Intervalo ativo'), (5, 10, 2, 3, '1min', 60, NULL),
(6, 1, 1, 3, '10', 90, NULL), (6, 4, 2, 3, '10', 90, NULL), (6, 2, 3, 3, '12', 90, NULL),
(7, 7, 1, 4, '15', 30, NULL),
(8, 2, 1, 4, '10', 90, NULL), (8, 8, 2, 3, '12', 90, NULL);

-- -----------------------------------------------------
-- Inserção de Avaliações Físicas (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO AVALIACAO_FISICA (ID_ALUNO, ID_PERSONAL, DATA_AVALIACAO, PESO, ALTURA, PERCENTUAL_GORDURA, MASSA_MUSCULAR, CIRCUNFERENCIAS) VALUES
(1, 3, '2025-03-01 10:00:00', 78.5, 175, 18.2, 35.5, '{"braco": 32, "peito": 95, "cintura": 80}'),
(1, 3, '2025-04-01 10:00:00', 76.8, 175, 16.8, 36.2, '{"braco": 33, "peito": 96, "cintura": 78}'),
(2, 4, '2025-03-05 14:00:00', 65.2, 168, 22.5, 28.7, '{"braco": 28, "peito": 88, "cintura": 72}'),
(5, 3, '2025-03-10 09:00:00', 85.0, 182, 20.1, 40.1, '{"braco": 35, "peito": 100, "cintura": 86}');

-- -----------------------------------------------------
-- Inserção de Usuário x Treino (Rotinas) (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO USUARIO_TREINO (ID_USUARIO, ID_TREINO, DATA_ASSOCIACAO, ATIVO) VALUES
(1, 1, '2025-03-02 08:00:00', TRUE), (1, 2, '2025-03-02 08:00:00', TRUE),
(2, 6, '2025-03-06 10:00:00', TRUE), (2, 7, '2025-03-06 10:00:00', FALSE),
(5, 3, '2025-03-11 07:00:00', TRUE), (5, 4, '2025-03-11 07:00:00', TRUE), (5, 8, '2025-03-18 07:00:00', TRUE),
(6, 1, '2025-04-01 08:00:00', TRUE), (6, 3, '2025-04-01 08:00:00', TRUE), (6, 5, '2025-04-01 08:00:00', TRUE), (6, 7, '2025-04-01 08:00:00', TRUE),
(7, 1, '2025-04-15 07:00:00', TRUE), (7, 2, '2025-04-15 07:00:00', TRUE), (7, 3, '2025-04-15 07:00:00', TRUE), (7, 5, '2025-04-15 07:00:00', TRUE), (7, 6, '2025-04-15 07:00:00', TRUE);

-- -----------------------------------------------------
-- Inserção de Registros de Treino Realizados (atualizado para 2025)
-- -----------------------------------------------------
-- Usuário 6 (Atleta Dedicação) - 25 sessões nos últimos 3 meses
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS, FEEDBACK) VALUES
(6, 1, '2025-04-05 08:00:00', '2025-04-05 08:45:00', 220, 'Bom treino matinal'),
(6, 2, '2025-04-07 17:30:00', '2025-04-07 18:15:00', 250, NULL),
(6, 3, '2025-04-10 09:00:00', '2025-04-10 10:00:00', 320, 'Foco no peito'),
(6, 5, '2025-04-12 07:00:00', '2025-04-12 07:30:00', 180, 'Cardio intenso'),
(6, 1, '2025-04-14 08:00:00', '2025-04-14 08:50:00', 230, NULL),
(6, 4, '2025-04-17 18:00:00', '2025-04-17 19:05:00', 340, 'Costas doloridas'),
(6, 6, '2025-04-19 09:30:00', '2025-04-19 11:00:00', 450, 'Treino completo'),
(6, 2, '2025-04-21 16:00:00', '2025-04-21 16:45:00', 240, NULL),
(6, 3, '2025-04-24 10:00:00', '2025-04-24 11:00:00', 310, 'Melhorando técnica'),
(6, 5, '2025-04-26 07:30:00', '2025-04-26 08:00:00', 190, NULL),
(6, 1, '2025-04-28 08:30:00', '2025-04-28 09:20:00', 235, NULL),
(6, 4, '2025-05-01 17:30:00', '2025-05-01 18:35:00', 350, NULL),
(6, 6, '2025-05-03 09:00:00', '2025-05-03 10:30:00', 460, 'Bom desempenho'),
(6, 2, '2025-05-05 15:00:00', '2025-05-05 15:45:00', 245, NULL),
(6, 3, '2025-05-08 10:30:00', '2025-05-08 11:30:00', 325, NULL),
(6, 5, '2025-05-10 08:00:00', '2025-05-10 08:30:00', 195, 'Rápido mas intenso'),
(6, 1, '2025-05-12 09:00:00', '2025-05-12 09:50:00', 240, NULL),
(6, 4, '2025-05-15 18:00:00', '2025-05-15 19:05:00', 345, NULL),
(6, 6, '2025-05-17 10:00:00', '2025-05-17 11:30:00', 465, NULL),
(6, 2, '2025-05-19 16:30:00', '2025-05-19 17:15:00', 250, NULL),
(6, 3, '2025-05-22 09:30:00', '2025-05-22 10:30:00', 330, NULL),
(6, 5, '2025-05-24 07:30:00', '2025-05-24 08:00:00', 200, NULL),
(6, 1, '2025-05-26 08:30:00', '2025-05-26 09:20:00', 245, NULL),
(6, 4, '2025-05-29 17:00:00', '2025-05-29 18:05:00', 350, 'Último treino do mês'),
(6, 6, '2025-05-31 10:30:00', '2025-05-31 12:00:00', 470, NULL);

-- Usuário 7 (Frequente Semanal) - 5+ treinos por semana nos últimos 2 meses
-- Maio 2025 (6 treinos por semana)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS) VALUES
(7, 1, '2025-05-05 07:00:00', '2025-05-05 07:45:00', 220),
(7, 2, '2025-05-06 07:00:00', '2025-05-06 07:45:00', 230),
(7, 3, '2025-05-07 07:00:00', '2025-05-07 08:00:00', 310),
(7, 5, '2025-05-08 07:00:00', '2025-05-08 07:30:00', 180),
(7, 6, '2025-05-09 07:00:00', '2025-05-09 08:30:00', 450),
(7, 1, '2025-05-10 09:00:00', '2025-05-10 09:45:00', 225),
(7, 2, '2025-05-12 07:00:00', '2025-05-12 07:45:00', 235),
(7, 4, '2025-05-13 07:00:00', '2025-05-13 08:05:00', 340),
(7, 5, '2025-05-14 07:00:00', '2025-05-14 07:30:00', 185),
(7, 6, '2025-05-15 07:00:00', '2025-05-15 08:30:00', 455),
(7, 3, '2025-05-16 07:00:00', '2025-05-16 08:00:00', 315),
(7, 1, '2025-05-17 09:00:00', '2025-05-17 09:45:00', 230),
(7, 2, '2025-05-19 07:00:00', '2025-05-19 07:45:00', 240),
(7, 4, '2025-05-20 07:00:00', '2025-05-20 08:05:00', 345),
(7, 5, '2025-05-21 07:00:00', '2025-05-21 07:30:00', 190),
(7, 6, '2025-05-22 07:00:00', '2025-05-22 08:30:00', 460),
(7, 3, '2025-05-23 07:00:00', '2025-05-23 08:00:00', 320),
(7, 1, '2025-05-24 09:00:00', '2025-05-24 09:45:00', 235),
(7, 2, '2025-05-26 07:00:00', '2025-05-26 07:45:00', 245),
(7, 4, '2025-05-27 07:00:00', '2025-05-27 08:05:00', 350),
(7, 5, '2025-05-28 07:00:00', '2025-05-28 07:30:00', 195),
(7, 6, '2025-05-29 07:00:00', '2025-05-29 08:30:00', 465),
(7, 3, '2025-05-30 07:00:00', '2025-05-30 08:00:00', 325),
(7, 1, '2025-05-31 09:00:00', '2025-05-31 09:45:00', 240);

-- Abril 2025 (6 treinos por semana)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS) VALUES
(7, 2, '2025-04-01 07:00:00', '2025-04-01 07:45:00', 230),
(7, 3, '2025-04-02 07:00:00', '2025-04-02 08:00:00', 310),
(7, 5, '2025-04-03 07:00:00', '2025-04-03 07:30:00', 180),
(7, 6, '2025-04-04 07:00:00', '2025-04-04 08:30:00', 450),
(7, 1, '2025-04-05 09:00:00', '2025-04-05 09:45:00', 225),
(7, 2, '2025-04-07 07:00:00', '2025-04-07 07:45:00', 235),
(7, 4, '2025-04-08 07:00:00', '2025-04-08 08:05:00', 340),
(7, 5, '2025-04-09 07:00:00', '2025-04-09 07:30:00', 185),
(7, 6, '2025-04-10 07:00:00', '2025-04-10 08:30:00', 455),
(7, 3, '2025-04-11 07:00:00', '2025-04-11 08:00:00', 315),
(7, 1, '2025-04-12 09:00:00', '2025-04-12 09:45:00', 230),
(7, 2, '2025-04-14 07:00:00', '2025-04-14 07:45:00', 240),
(7, 4, '2025-04-15 07:00:00', '2025-04-15 08:05:00', 345),
(7, 5, '2025-04-16 07:00:00', '2025-04-16 07:30:00', 190),
(7, 6, '2025-04-17 07:00:00', '2025-04-17 08:30:00', 460),
(7, 3, '2025-04-18 07:00:00', '2025-04-18 08:00:00', 320),
(7, 1, '2025-04-19 09:00:00', '2025-04-19 09:45:00', 235),
(7, 2, '2025-04-21 07:00:00', '2025-04-21 07:45:00', 245),
(7, 4, '2025-04-22 07:00:00', '2025-04-22 08:05:00', 350),
(7, 5, '2025-04-23 07:00:00', '2025-04-23 07:30:00', 195),
(7, 6, '2025-04-24 07:00:00', '2025-04-24 08:30:00', 465),
(7, 3, '2025-04-25 07:00:00', '2025-04-25 08:00:00', 325),
(7, 1, '2025-04-26 09:00:00', '2025-04-26 09:45:00', 240),
(7, 2, '2025-04-28 07:00:00', '2025-04-28 07:45:00', 250),
(7, 4, '2025-04-29 07:00:00', '2025-04-29 08:05:00', 355),
(7, 5, '2025-04-30 07:00:00', '2025-04-30 07:30:00', 200);

-- Outros usuários (registros adicionais)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS, FEEDBACK) VALUES
(1, 1, '2025-05-28 08:00:00', '2025-05-28 08:47:00', 220, 'Bom treino'),
(1, 2, '2025-05-26 08:00:00', '2025-05-26 08:42:00', 180, NULL),
(1, 1, '2025-05-21 08:00:00', '2025-05-21 08:50:00', 240, 'Cansativo'),
(1, 2, '2025-05-19 08:00:00', '2025-05-19 08:45:00', 190, NULL),
(2, 6, '2025-05-27 10:00:00', '2025-05-27 11:28:00', 450, 'Treino completo'),
(2, 6, '2025-05-20 10:00:00', '2025-05-20 11:32:00', 480, NULL),
(5, 3, '2025-05-29 07:00:00', '2025-05-29 08:02:00', 320, 'Foco no peito'),
(5, 4, '2025-05-25 07:00:00', '2025-05-25 08:05:00', 340, NULL),
(5, 8, '2025-05-22 07:00:00', '2025-05-22 07:52:00', 280, 'Pernas doloridas');

-- -----------------------------------------------------
-- Inserção de Metas (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO META (ID_ALUNO, TITULO, DESCRICAO, TIPO, VALOR_ALVO, UNIDADE, DATA_CRIACAO, DATA_LIMITE, CONCLUIDA, DATA_CONCLUSAO) VALUES
-- Metas para João (ID 1)
(1, 'Perder 5kg', 'Reduzir percentual de gordura', 'perda_peso', 5, 'kg', '2025-03-02', '2025-06-30', FALSE, NULL),
(1, 'Correr 5km', 'Melhorar capacidade cardiorrespiratória', 'resistencia', 5, 'km', '2025-03-02', '2025-05-31', TRUE, '2025-05-15'),

-- Metas para Maria (ID 2)
(2, 'Ganhar massa muscular', 'Aumentar massa magra em 2kg', 'ganho_massa', 2, 'kg', '2025-03-06', '2025-07-31', FALSE, NULL),
(2, 'Treinar 3x por semana', 'Consistência nos treinos', 'outro', 3, 'vezes/semana', '2025-03-06', '2025-06-30', TRUE, '2025-05-20'),

-- Metas para Pedro (ID 5)
(5, 'Aumentar supino', 'Passar de 60kg para 80kg no supino', 'ganho_massa', 80, 'kg', '2025-03-11', '2025-09-30', FALSE, NULL),
(5, 'Reduzir cintura', 'Diminuir cintura para 82cm', 'perda_peso', 82, 'cm', '2025-03-11', '2025-06-30', FALSE, NULL),
(5, 'Treino diário', 'Manter rotina de treinos diários', 'outro', 30, 'dias', '2025-03-11', '2025-06-30', TRUE, '2025-05-30'),

-- Metas para Atleta Dedicação (ID 6)
(6, 'Participar de competição', 'Preparação para competição de fitness', 'outro', 1, 'competição', '2025-04-01', '2025-10-15', FALSE, NULL),
(6, 'Reduzir tempo corrida', 'Correr 10km em menos de 45 minutos', 'resistencia', 45, 'minutos', '2025-04-01', '2025-08-31', TRUE, '2025-05-10'),

-- Metas para Frequente Semanal (ID 7)
(7, 'Manter frequência', 'Continuar com 5+ treinos semanais', 'outro', 8, 'semanas', '2025-04-15', '2025-06-15', TRUE, '2025-05-31'),
(7, 'Aumentar resistência', 'Aumentar tempo de cardio em 20%', 'resistencia', 20, 'percentual', '2025-04-15', '2025-07-31', FALSE, NULL);
(5, 'Aumentar supino', 'Passar de 60kg para 80kg no supino', 'ganho_massa', 80, 'kg', '2025-03-11', '2025-09-30', FALSE, NULL),
(5, 'Reduzir cintura', 'Diminuir cintura para 82cm', 'perda_peso', 82, 'cm', '2025-03-11', '2025-06-30', FALSE, NULL),
(5, 'Treino diário', 'Manter rotina de treinos diários', 'outro', 30, 'dias', '2025-03-11', '2025-06-30', TRUE, '2025-05-30'),

-- Metas para Atleta Dedicação (ID 6)
(6, 'Participar de competição', 'Preparação para competição de fitness', 'outro', 1, 'competição', '2025-04-01', '2025-10-15', FALSE, NULL),
(6, 'Reduzir tempo corrida', 'Correr 10km em menos de 45 minutos', 'resistencia', 45, 'minutos', '2025-04-01', '2025-08-31', TRUE, '2025-05-10'),

-- Metas para Frequente Semanal (ID 7)
(7, 'Manter frequência', 'Continuar com 5+ treinos semanais', 'outro', 8, 'semanas', '2025-04-15', '2025-06-15', TRUE, '2025-05-31'),
(7, 'Aumentar resistência', 'Aumentar tempo de cardio em 20%', 'resistencia', 20, 'percentual', '2025-04-15', '2025-07-31', FALSE, NULL);-------------------------
-- Inserção de Músculos
-- -----------------------------------------------------
INSERT INTO MUSCULO (NOME, GRUPO_MUSCULAR) VALUES
('Peitoral Maior', 'Tórax'),
('Deltóide', 'Ombros'),
('Tríceps Braquial', 'Braços'),
('Bíceps Braquial', 'Braços'),
('Reto Abdominal', 'Abdômen'),
('Quadríceps Femoral', 'Pernas'),
('Isquiotibiais', 'Pernas'),
('Glúteo Máximo', 'Pernas'),
('Trapézio', 'Costas'),
('Latíssimo do Dorso', 'Costas');

-- -----------------------------------------------------
-- Inserção de Exercícios
-- -----------------------------------------------------
INSERT INTO EXERCICIO (NOME, CATEGORIA, ID_EQUIPAMENTO, INSTRUCOES, NIVEL_DIFICULDADE) VALUES
('Supino Reto', 'Musculação', 4, 'Deitar no banco e empurrar a barra para cima', 'intermediario'),
('Agachamento Livre', 'Musculação', NULL, 'Manter as costas retas e descer até 90 graus', 'intermediario'),
('Corrida Estacionária', 'Cardio', 1, 'Manter ritmo constante por 30 minutos', 'iniciante'),
('Remada Curvada', 'Musculação', 3, 'Dobrar levemente os joelhos e puxar os pesos', 'avancado'),
('Flexão de Braço', 'Calistenia', NULL, 'Manter o corpo alinhado durante o movimento', 'iniciante'),
('Pull-up', 'Calistenia', 5, 'Puxar o corpo até o queixo passar a barra', 'avancado'),
('Abdominal Crunch', 'Core', NULL, 'Contrair o abdômen ao levantar o tronco', 'iniciante'),
('Leg Press', 'Musculação', 8, 'Empurrar a plataforma com as pernas', 'intermediario'),
('Corda Naval', 'Cardio', NULL, 'Ondular a corda alternando os braços', 'intermediario'),
('Pular Corda', 'Cardio', 6, 'Manter ritmo constante com saltos baixos', 'iniciante');

-- -----------------------------------------------------
-- Inserção de Exercício x Músculo
-- -----------------------------------------------------
INSERT INTO EXERCICIO_MUSCULO (ID_EXERCICIO, ID_MUSCULO, INTENSIDADE) VALUES
(1, 1, 'primario'), (1, 2, 'secundario'), (1, 3, 'secundario'),
(2, 6, 'primario'), (2, 7, 'secundario'), (2, 8, 'secundario'),
(4, 9, 'primario'), (4, 10, 'primario'), (4, 4, 'secundario'),
(6, 10, 'primario'), (6, 4, 'secundario'),
(8, 6, 'primario'), (8, 7, 'secundario'), (8, 8, 'secundario');

-- -----------------------------------------------------
-- Inserção de Treinos (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO TREINO (NOME, DURACAO_PADRAO, OBJETIVO, CATEGORIA, ID_PERSONAL_CRIADOR, DATA_CRIACAO) VALUES
('Treino Iniciante A', 45, 'Adaptação muscular', 'Iniciante', 3, '2025-01-10 09:00:00'),
('Treino Iniciante B', 45, 'Resistência cardiorrespiratória', 'Iniciante', 3, '2025-01-12 09:00:00'),
('Treino Avançado Peito', 60, 'Hipertrofia peitoral', 'Musculação', 4, '2025-01-15 10:00:00'),
('Treino Avançado Costas', 60, 'Força nas costas', 'Musculação', 4, '2025-01-18 10:00:00'),
('Treino Cardio Intenso', 30, 'Queima de gordura', 'Cardio', 4, '2025-02-01 08:00:00'),
('Treino Completo', 90, 'Condicionamento geral', 'Misto', 3, '2025-02-05 09:00:00'),
('Treino Abdômen', 20, 'Definição abdominal', 'Core', 4, '2025-02-10 11:00:00'),
('Treino Inferior', 50, 'Fortalecimento de pernas', 'Musculação', 3, '2025-02-15 09:00:00');

-- -----------------------------------------------------
-- Inserção de Treino x Exercício
-- -----------------------------------------------------
INSERT INTO TREINO_EXERCICIO (ID_TREINO, ID_EXERCICIO, ORDEM, SERIES, REPETICOES, DESCANSO, OBSERVACOES) VALUES
(1, 5, 1, 3, '10-12', 60, 'Manter postura reta'), (1, 7, 2, 3, '15', 45, 'Contrair abdômen'), (1, 3, 3, 1, '20min', NULL, 'Ritmo moderado'),
(2, 10, 1, 5, '1min', 30, 'Manter ritmo constante'), (2, 7, 2, 4, '12', 45, NULL),
(3, 1, 1, 4, '8-10', 90, 'Cuidado com ombros'), (3, 5, 2, 3, '12', 60, NULL),
(4, 6, 1, 4, '6-8', 120, NULL), (4, 4, 2, 3, '10', 90, NULL),
(5, 9, 1, 3, '30seg', 60, 'Intervalo ativo'), (5, 10, 2, 3, '1min', 60, NULL),
(6, 1, 1, 3, '10', 90, NULL), (6, 4, 2, 3, '10', 90, NULL), (6, 2, 3, 3, '12', 90, NULL),
(7, 7, 1, 4, '15', 30, NULL),
(8, 2, 1, 4, '10', 90, NULL), (8, 8, 2, 3, '12', 90, NULL);

-- -----------------------------------------------------
-- Inserção de Avaliações Físicas (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO AVALIACAO_FISICA (ID_ALUNO, ID_PERSONAL, DATA_AVALIACAO, PESO, ALTURA, PERCENTUAL_GORDURA, MASSA_MUSCULAR, CIRCUNFERENCIAS) VALUES
(1, 3, '2025-03-01 10:00:00', 78.5, 175, 18.2, 35.5, '{"braco": 32, "peito": 95, "cintura": 80}'),
(1, 3, '2025-04-01 10:00:00', 76.8, 175, 16.8, 36.2, '{"braco": 33, "peito": 96, "cintura": 78}'),
(2, 4, '2025-03-05 14:00:00', 65.2, 168, 22.5, 28.7, '{"braco": 28, "peito": 88, "cintura": 72}'),
(5, 3, '2025-03-10 09:00:00', 85.0, 182, 20.1, 40.1, '{"braco": 35, "peito": 100, "cintura": 86}');

-- -----------------------------------------------------
-- Inserção de Usuário x Treino (Rotinas) (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO USUARIO_TREINO (ID_USUARIO, ID_TREINO, DATA_ASSOCIACAO, ATIVO) VALUES
(1, 1, '2025-03-02 08:00:00', TRUE), (1, 2, '2025-03-02 08:00:00', TRUE),
(2, 6, '2025-03-06 10:00:00', TRUE), (2, 7, '2025-03-06 10:00:00', FALSE),
(5, 3, '2025-03-11 07:00:00', TRUE), (5, 4, '2025-03-11 07:00:00', TRUE), (5, 8, '2025-03-18 07:00:00', TRUE),
(6, 1, '2025-04-01 08:00:00', TRUE), (6, 3, '2025-04-01 08:00:00', TRUE), (6, 5, '2025-04-01 08:00:00', TRUE), (6, 7, '2025-04-01 08:00:00', TRUE),
(7, 1, '2025-04-15 07:00:00', TRUE), (7, 2, '2025-04-15 07:00:00', TRUE), (7, 3, '2025-04-15 07:00:00', TRUE), (7, 5, '2025-04-15 07:00:00', TRUE), (7, 6, '2025-04-15 07:00:00', TRUE);

-- -----------------------------------------------------
-- Inserção de Registros de Treino Realizados (atualizado para 2025)
-- -----------------------------------------------------
-- Usuário 6 (Atleta Dedicação) - 25 sessões nos últimos 3 meses
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS, FEEDBACK) VALUES
(6, 1, '2025-04-05 08:00:00', '2025-04-05 08:45:00', 220, 'Bom treino matinal'),
(6, 2, '2025-04-07 17:30:00', '2025-04-07 18:15:00', 250, NULL),
(6, 3, '2025-04-10 09:00:00', '2025-04-10 10:00:00', 320, 'Foco no peito'),
(6, 5, '2025-04-12 07:00:00', '2025-04-12 07:30:00', 180, 'Cardio intenso'),
(6, 1, '2025-04-14 08:00:00', '2025-04-14 08:50:00', 230, NULL),
(6, 4, '2025-04-17 18:00:00', '2025-04-17 19:05:00', 340, 'Costas doloridas'),
(6, 6, '2025-04-19 09:30:00', '2025-04-19 11:00:00', 450, 'Treino completo'),
(6, 2, '2025-04-21 16:00:00', '2025-04-21 16:45:00', 240, NULL),
(6, 3, '2025-04-24 10:00:00', '2025-04-24 11:00:00', 310, 'Melhorando técnica'),
(6, 5, '2025-04-26 07:30:00', '2025-04-26 08:00:00', 190, NULL),
(6, 1, '2025-04-28 08:30:00', '2025-04-28 09:20:00', 235, NULL),
(6, 4, '2025-05-01 17:30:00', '2025-05-01 18:35:00', 350, NULL),
(6, 6, '2025-05-03 09:00:00', '2025-05-03 10:30:00', 460, 'Bom desempenho'),
(6, 2, '2025-05-05 15:00:00', '2025-05-05 15:45:00', 245, NULL),
(6, 3, '2025-05-08 10:30:00', '2025-05-08 11:30:00', 325, NULL),
(6, 5, '2025-05-10 08:00:00', '2025-05-10 08:30:00', 195, 'Rápido mas intenso'),
(6, 1, '2025-05-12 09:00:00', '2025-05-12 09:50:00', 240, NULL),
(6, 4, '2025-05-15 18:00:00', '2025-05-15 19:05:00', 345, NULL),
(6, 6, '2025-05-17 10:00:00', '2025-05-17 11:30:00', 465, NULL),
(6, 2, '2025-05-19 16:30:00', '2025-05-19 17:15:00', 250, NULL),
(6, 3, '2025-05-22 09:30:00', '2025-05-22 10:30:00', 330, NULL),
(6, 5, '2025-05-24 07:30:00', '2025-05-24 08:00:00', 200, NULL),
(6, 1, '2025-05-26 08:30:00', '2025-05-26 09:20:00', 245, NULL),
(6, 4, '2025-05-29 17:00:00', '2025-05-29 18:05:00', 350, 'Último treino do mês'),
(6, 6, '2025-05-31 10:30:00', '2025-05-31 12:00:00', 470, NULL);

-- Usuário 7 (Frequente Semanal) - 5+ treinos por semana nos últimos 2 meses
-- Maio 2025 (6 treinos por semana)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS) VALUES
(7, 1, '2025-05-05 07:00:00', '2025-05-05 07:45:00', 220),
(7, 2, '2025-05-06 07:00:00', '2025-05-06 07:45:00', 230),
(7, 3, '2025-05-07 07:00:00', '2025-05-07 08:00:00', 310),
(7, 5, '2025-05-08 07:00:00', '2025-05-08 07:30:00', 180),
(7, 6, '2025-05-09 07:00:00', '2025-05-09 08:30:00', 450),
(7, 1, '2025-05-10 09:00:00', '2025-05-10 09:45:00', 225),
(7, 2, '2025-05-12 07:00:00', '2025-05-12 07:45:00', 235),
(7, 4, '2025-05-13 07:00:00', '2025-05-13 08:05:00', 340),
(7, 5, '2025-05-14 07:00:00', '2025-05-14 07:30:00', 185),
(7, 6, '2025-05-15 07:00:00', '2025-05-15 08:30:00', 455),
(7, 3, '2025-05-16 07:00:00', '2025-05-16 08:00:00', 315),
(7, 1, '2025-05-17 09:00:00', '2025-05-17 09:45:00', 230),
(7, 2, '2025-05-19 07:00:00', '2025-05-19 07:45:00', 240),
(7, 4, '2025-05-20 07:00:00', '2025-05-20 08:05:00', 345),
(7, 5, '2025-05-21 07:00:00', '2025-05-21 07:30:00', 190),
(7, 6, '2025-05-22 07:00:00', '2025-05-22 08:30:00', 460),
(7, 3, '2025-05-23 07:00:00', '2025-05-23 08:00:00', 320),
(7, 1, '2025-05-24 09:00:00', '2025-05-24 09:45:00', 235),
(7, 2, '2025-05-26 07:00:00', '2025-05-26 07:45:00', 245),
(7, 4, '2025-05-27 07:00:00', '2025-05-27 08:05:00', 350),
(7, 5, '2025-05-28 07:00:00', '2025-05-28 07:30:00', 195),
(7, 6, '2025-05-29 07:00:00', '2025-05-29 08:30:00', 465),
(7, 3, '2025-05-30 07:00:00', '2025-05-30 08:00:00', 325),
(7, 1, '2025-05-31 09:00:00', '2025-05-31 09:45:00', 240);

-- Abril 2025 (6 treinos por semana)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS) VALUES
(7, 2, '2025-04-01 07:00:00', '2025-04-01 07:45:00', 230),
(7, 3, '2025-04-02 07:00:00', '2025-04-02 08:00:00', 310),
(7, 5, '2025-04-03 07:00:00', '2025-04-03 07:30:00', 180),
(7, 6, '2025-04-04 07:00:00', '2025-04-04 08:30:00', 450),
(7, 1, '2025-04-05 09:00:00', '2025-04-05 09:45:00', 225),
(7, 2, '2025-04-07 07:00:00', '2025-04-07 07:45:00', 235),
(7, 4, '2025-04-08 07:00:00', '2025-04-08 08:05:00', 340),
(7, 5, '2025-04-09 07:00:00', '2025-04-09 07:30:00', 185),
(7, 6, '2025-04-10 07:00:00', '2025-04-10 08:30:00', 455),
(7, 3, '2025-04-11 07:00:00', '2025-04-11 08:00:00', 315),
(7, 1, '2025-04-12 09:00:00', '2025-04-12 09:45:00', 230),
(7, 2, '2025-04-14 07:00:00', '2025-04-14 07:45:00', 240),
(7, 4, '2025-04-15 07:00:00', '2025-04-15 08:05:00', 345),
(7, 5, '2025-04-16 07:00:00', '2025-04-16 07:30:00', 190),
(7, 6, '2025-04-17 07:00:00', '2025-04-17 08:30:00', 460),
(7, 3, '2025-04-18 07:00:00', '2025-04-18 08:00:00', 320),
(7, 1, '2025-04-19 09:00:00', '2025-04-19 09:45:00', 235),
(7, 2, '2025-04-21 07:00:00', '2025-04-21 07:45:00', 245),
(7, 4, '2025-04-22 07:00:00', '2025-04-22 08:05:00', 350),
(7, 5, '2025-04-23 07:00:00', '2025-04-23 07:30:00', 195),
(7, 6, '2025-04-24 07:00:00', '2025-04-24 08:30:00', 465),
(7, 3, '2025-04-25 07:00:00', '2025-04-25 08:00:00', 325),
(7, 1, '2025-04-26 09:00:00', '2025-04-26 09:45:00', 240),
(7, 2, '2025-04-28 07:00:00', '2025-04-28 07:45:00', 250),
(7, 4, '2025-04-29 07:00:00', '2025-04-29 08:05:00', 355),
(7, 5, '2025-04-30 07:00:00', '2025-04-30 07:30:00', 200);

-- Outros usuários (registros adicionais)
INSERT INTO REGISTRO_TREINO (ID_USUARIO, ID_TREINO, DATA_INICIO, DATA_FIM, CALORIAS_QUEIMADAS, FEEDBACK) VALUES
(1, 1, '2025-05-28 08:00:00', '2025-05-28 08:47:00', 220, 'Bom treino'),
(1, 2, '2025-05-26 08:00:00', '2025-05-26 08:42:00', 180, NULL),
(1, 1, '2025-05-21 08:00:00', '2025-05-21 08:50:00', 240, 'Cansativo'),
(1, 2, '2025-05-19 08:00:00', '2025-05-19 08:45:00', 190, NULL),
(2, 6, '2025-05-27 10:00:00', '2025-05-27 11:28:00', 450, 'Treino completo'),
(2, 6, '2025-05-20 10:00:00', '2025-05-20 11:32:00', 480, NULL),
(5, 3, '2025-05-29 07:00:00', '2025-05-29 08:02:00', 320, 'Foco no peito'),
(5, 4, '2025-05-25 07:00:00', '2025-05-25 08:05:00', 340, NULL),
(5, 8, '2025-05-22 07:00:00', '2025-05-22 07:52:00', 280, 'Pernas doloridas');

-- -----------------------------------------------------
-- Inserção de Metas (atualizado para 2025)
-- -----------------------------------------------------
INSERT INTO META (ID_ALUNO, TITULO, DESCRICAO, TIPO, VALOR_ALVO, UNIDADE, DATA_CRIACAO, DATA_LIMITE, CONCLUIDA, DATA_CONCLUSAO) VALUES
-- Metas para João (ID 1)
(1, 'Perder 5kg', 'Reduzir percentual de gordura', 'perda_peso', 5, 'kg', '2025-03-02', '2025-06-30', FALSE, NULL),
(1, 'Correr 5km', 'Melhorar capacidade cardiorrespiratória', 'resistencia', 5, 'km', '2025-03-02', '2025-05-31', TRUE, '2025-05-15'),

-- Metas para Maria (ID 2)
(2, 'Ganhar massa muscular', 'Aumentar massa magra em 2kg', 'ganho_massa', 2, 'kg', '2025-03-06', '2025-07-31', FALSE, NULL),
(2, 'Treinar 3x por semana', 'Consistência nos treinos', 'outro', 3, 'vezes/semana', '2025-03-06', '2025-06-30', TRUE, '2025-05-20'),

-- Metas para Pedro (ID 5)
(5, 'Aumentar supino', 'Passar de 60kg para 80kg no supino', 'ganho_massa', 80, 'kg', '2025-03-11', '2025-09-30', FALSE, NULL),
(5, 'Reduzir cintura', 'Diminuir cintura para 82cm', 'perda_peso', 82, 'cm', '2025-03-11', '2025-06-30', FALSE, NULL),
(5, 'Treino diário', 'Manter rotina de treinos diários', 'outro', 30, 'dias', '2025-03-11', '2025-06-30', TRUE, '2025-05-30'),

-- Metas para Atleta Dedicação (ID 6)
(6, 'Participar de competição', 'Preparação para competição de fitness', 'outro', 1, 'competição', '2025-04-01', '2025-10-15', FALSE, NULL),
(6, 'Reduzir tempo corrida', 'Correr 10km em menos de 45 minutos', 'resistencia', 45, 'minutos', '2025-04-01', '2025-08-31', TRUE, '2025-05-10'),

-- Metas para Frequente Semanal (ID 7)
(7, 'Manter frequência', 'Continuar com 5+ treinos semanais', 'outro', 8, 'semanas', '2025-04-15', '2025-06-15', TRUE, '2025-05-31'),
(7, 'Aumentar resistência', 'Aumentar tempo de cardio em 20%', 'resistencia', 20, 'percentual', '2025-04-15', '2025-07-31', FALSE, NULL);