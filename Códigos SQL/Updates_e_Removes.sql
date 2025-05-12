-- Atualizando os dados das tabelas
UPDATE USUARIO
SET EMAIL = 'novo.joao.silva@email.com'
WHERE NOME = 'João Silva';

UPDATE EQUIPAMENTO
SET STATUS = 'ativo'
WHERE NOME = 'Kettlebell';

UPDATE EXERCICIO
SET NIVEL_DIFICULDADE = 'avancado'
WHERE NOME = 'Supino Reto';

-- Deletando o usuário "Frequente Semanal" e seus dados relacionados

-- Primeiro, removemos as entradas nas tabelas dependentes
DELETE FROM AVALIACAO_FISICA
WHERE ID_USUARIO = (SELECT ID_USUARIO FROM USUARIO WHERE NOME = 'Frequente Semanal');

DELETE FROM METAS
WHERE ID_USUARIO = (SELECT ID_USUARIO FROM USUARIO WHERE NOME = 'Frequente Semanal');

DELETE FROM TREINO_EXERCICIO
WHERE ID_TREINO IN (SELECT ID_TREINO FROM TREINO WHERE ID_USUARIO = (SELECT ID_USUARIO FROM USUARIO WHERE NOME = 'Frequente Semanal'));

DELETE FROM TREINO
WHERE ID_USUARIO = (SELECT ID_USUARIO FROM USUARIO WHERE NOME = 'Frequente Semanal');

-- Por fim, removemos o usuário da tabela USUARIO
DELETE FROM USUARIO
WHERE NOME = 'Frequente Semanal';
