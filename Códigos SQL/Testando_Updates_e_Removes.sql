-- 1. Verificar a atualização do usuário "João Silva"
SELECT NOME, EMAIL
FROM USUARIO
WHERE NOME = 'João Silva';

-- 2. Verificar a atualização do equipamento "Kettlebell"
SELECT NOME, STATUS
FROM EQUIPAMENTO
WHERE NOME = 'Kettlebell';

-- 3. Verificar a atualização do exercício "Supino Reto"
SELECT NOME, NIVEL_DIFICULDADE
FROM EXERCICIO
WHERE NOME = 'Supino Reto';

-- 4. Verificar se o usuário "Frequente Semanal" foi deletado
SELECT * FROM USUARIO
WHERE NOME = 'Frequente Semanal';

-- 5. Verificar se os dados do usuário "Frequente Semanal" foram deletados da tabela AVALIACAO_FISICA
SELECT * FROM AVALIACAO_FISICA
WHERE ID_USUARIO = (SELECT ID_USUARIO FROM USUARIO WHERE NOME = 'Frequente Semanal');

-- 6. Verificar se os dados do usuário "Frequente Semanal" foram deletados da tabela METAS
SELECT * FROM METAS
WHERE ID_USUARIO = (SELECT ID_USUARIO FROM USUARIO WHERE NOME = 'Frequente Semanal');

-- 7. Verificar se os dados do usuário "Frequente Semanal" foram deletados da tabela TREINO
SELECT * FROM TREINO
WHERE ID_USUARIO = (SELECT ID_USUARIO FROM USUARIO WHERE NOME = 'Frequente Semanal');

-- 8. Verificar se os dados do usuário "Frequente Semanal" foram deletados da tabela TREINO_EXERCICIO
SELECT * FROM TREINO_EXERCICIO
WHERE ID_TREINO IN (
    SELECT ID_TREINO FROM TREINO WHERE ID_USUARIO = (
        SELECT ID_USUARIO FROM USUARIO WHERE NOME = 'Frequente Semanal'
    )
);
