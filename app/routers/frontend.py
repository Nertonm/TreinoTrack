from fastapi.responses import HTMLResponse
from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session

router = APIRouter(prefix="", tags=["frontpp"])

@router.get("/", response_class=HTMLResponse)
def simple_frontend():
    return """
    <!DOCTYPE html>
    <html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Treino Track - Sistema de Gerenciamento</title>
        <style>
            :root {
                --primary-color: #3498db;
                --secondary-color: #2c3e50;
                --success-color: #2ecc71;
                --danger-color: #e74c3c;
                --light-color: #ecf0f1;
                --dark-color: #34495e;
                --border-radius: 6px;
                --box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            }
            
            * {
                box-sizing: border-box;
            }
            
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                margin: 0;
                padding: 20px;
                background-color: #f5f7fa;
                color: #333;
                line-height: 1.6;
            }
            
            .container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 0 20px;
            }
            
            h1 {
                color: var(--secondary-color);
                text-align: center;
                margin-bottom: 30px;
                padding-bottom: 15px;
                border-bottom: 2px solid var(--primary-color);
            }
            
            h2 {
                color: var(--secondary-color);
                margin-top: 0;
                padding-bottom: 10px;
                border-bottom: 1px solid #ddd;
            }
            
            section {
                background: white;
                border-radius: var(--border-radius);
                box-shadow: var(--box-shadow);
                padding: 20px;
                margin-bottom: 30px;
            }
            
            button, input, select {
                padding: 8px 12px;
                border: 1px solid #ddd;
                border-radius: var(--border-radius);
                font-size: 14px;
                margin: 5px;
                transition: all 0.3s ease;
            }
            
            button {
                background-color: var(--primary-color);
                color: white;
                cursor: pointer;
                border: none;
                font-weight: 500;
            }
            
            button:hover {
                background-color: #2980b9;
                transform: translateY(-1px);
            }
            
            button.danger {
                background-color: var(--danger-color);
            }
            
            button.danger:hover {
                background-color: #c0392b;
            }
            
            button.success {
                background-color: var(--success-color);
            }
            
            button.success:hover {
                background-color: #27ae60;
            }
            
            input, select {
                width: calc(100% - 10px);
                max-width: 300px;
            }
            
            input:focus, select:focus {
                outline: none;
                border-color: var(--primary-color);
                box-shadow: 0 0 0 2px rgba(52, 152, 219, 0.2);
            }
            
            form {
                margin-bottom: 20px;
                padding: 15px;
                background-color: var(--light-color);
                border-radius: var(--border-radius);
            }
            
            .form-group {
                margin-bottom: 15px;
            }
            
            .form-row {
                display: flex;
                flex-wrap: wrap;
                gap: 10px;
                margin-bottom: 10px;
            }
            
            .form-row label {
                display: block;
                margin-bottom: 5px;
                font-weight: 500;
                color: var(--dark-color);
            }
            
            ul {
                list-style: none;
                padding: 0;
                margin: 0;
            }
            
            li {
                padding: 12px 15px;
                border-bottom: 1px solid #eee;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            
            li:nth-child(odd) {
                background-color: #f9f9f9;
            }
            
            li:hover {
                background-color: #f0f0f0;
            }
            
            .btn-group {
                display: flex;
                gap: 5px;
            }
            
            .card {
                background: white;
                border-radius: var(--border-radius);
                box-shadow: var(--box-shadow);
                padding: 15px;
                margin-bottom: 15px;
            }
            
            .alert {
                padding: 10px 15px;
                border-radius: var(--border-radius);
                margin-bottom: 15px;
                display: none;
            }
            
            .alert.success {
                background-color: #d4edda;
                color: #155724;
                border: 1px solid #c3e6cb;
            }
            
            .alert.error {
                background-color: #f8d7da;
                color: #721c24;
                border: 1px solid #f5c6cb;
            }
            
            @media (max-width: 768px) {
                .form-row {
                    flex-direction: column;
                }
                
                input, select {
                    width: 100%;
                    max-width: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Treino Track - Sistema de Gerenciamento</h1>
            
            <div id="alert" class="alert"></div>
            
            <section>
                <h2>Usuários</h2>
                <button onclick="loadUsuarios()">Listar Usuários</button>
                
                <form id="usuarioForm" class="hidden" onsubmit="criarUsuario(event)">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nomeUsuario">Nome</label>
                            <input id="nomeUsuario" placeholder="Nome completo" required>
                        </div>
                        <div class="form-group">
                            <label for="emailUsuario">Email</label>
                            <input id="emailUsuario" type="email" placeholder="Email" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="cpfUsuario">CPF</label>
                            <input id="cpfUsuario" placeholder="000.000.000-00" required>
                        </div>
                        <div class="form-group">
                            <label for="dataNascUsuario">Data de Nascimento</label>
                            <input id="dataNascUsuario" type="date" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tipoUsuario">Tipo de Usuário</label>
                        <select id="tipoUsuario" required>
                            <option value="">Selecione...</option>
                            <option value="aluno">Aluno</option>
                            <option value="personal">Personal Trainer</option>
                            <option value="admin">Administrador</option>
                        </select>
                    </div>
                    <button type="submit" class="success">Criar Usuário</button>
                    <button type="button" onclick="hideForm('usuarioForm')">Cancelar</button>
                </form>
                
                <ul id="usuarios"></ul>
            </section>
            
            <section>
                <h2>Músculos</h2>
                <button onclick="loadMusculos()">Listar Músculos</button>
                
                <form id="musculoForm" class="hidden" onsubmit="criarMusculo(event)">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nomeMusculo">Nome</label>
                            <input id="nomeMusculo" placeholder="Nome do músculo" required>
                        </div>
                        <div class="form-group">
                            <label for="grupoMuscular">Grupo Muscular</label>
                            <input id="grupoMuscular" placeholder="Grupo muscular" required>
                        </div>
                    </div>
                    <button type="submit" class="success">Adicionar Músculo</button>
                    <button type="button" onclick="hideForm('musculoForm')">Cancelar</button>
                </form>
                
                <ul id="musculos"></ul>
            </section>
            
            <section>
                <h2>Equipamentos</h2>
                <button onclick="loadEquipamentos()">Listar Equipamentos</button>
                
                <form id="equipamentoForm" class="hidden" onsubmit="criarEquipamento(event)">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nomeEquipamento">Nome</label>
                            <input id="nomeEquipamento" placeholder="Nome do equipamento" required>
                        </div>
                        <div class="form-group">
                            <label for="descEquipamento">Descrição</label>
                            <input id="descEquipamento" placeholder="Descrição">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="statusEquipamento">Status</label>
                        <select id="statusEquipamento" required>
                            <option value="ativo">Ativo</option>
                            <option value="inativo">Inativo</option>
                            <option value="manutencao">Manutenção</option>
                        </select>
                    </div>
                    <button type="submit" class="success">Criar Equipamento</button>
                    <button type="button" onclick="hideForm('equipamentoForm')">Cancelar</button>
                </form>
                
                <ul id="equipamentos"></ul>
            </section>
            
            <section>
                <h2>Exercícios</h2>
                <button onclick="loadExercicios()">Listar Exercícios</button>
                
                <form id="exercicioForm" class="hidden" onsubmit="criarExercicio(event)">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nomeExercicio">Nome</label>
                            <input id="nomeExercicio" placeholder="Nome do exercício" required>
                        </div>
                        <div class="form-group">
                            <label for="categoriaExercicio">Categoria</label>
                            <input id="categoriaExercicio" placeholder="Categoria" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="idEquipamentoExercicio">ID Equipamento (opcional)</label>
                            <input id="idEquipamentoExercicio" type="number" placeholder="ID do equipamento">
                        </div>
                        <div class="form-group">
                            <label for="nivelDificuldadeExercicio">Nível de Dificuldade</label>
                            <select id="nivelDificuldadeExercicio" required>
                                <option value="iniciante">Iniciante</option>
                                <option value="intermediario">Intermediário</option>
                                <option value="avancado">Avançado</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="instrucoesExercicio">Instruções</label>
                        <input id="instrucoesExercicio" placeholder="Instruções do exercício">
                    </div>
                    <button type="submit" class="success">Criar Exercício</button>
                    <button type="button" onclick="hideForm('exercicioForm')">Cancelar</button>
                </form>
                
                <ul id="exercicios"></ul>
            </section>
            
            <section>
                <h2>Metas</h2>
                <button onclick="loadMetas()">Listar Metas</button>
                
                <form id="metaForm" class="hidden" onsubmit="criarMeta(event)">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="tituloMeta">Título</label>
                            <input id="tituloMeta" placeholder="Título da meta" required>
                        </div>
                        <div class="form-group">
                            <label for="tipoMeta">Tipo de Meta</label>
                            <select id="tipoMeta" required>
                                <option value="perda_peso">Perda de Peso</option>
                                <option value="ganho_massa">Ganho de Massa</option>
                                <option value="resistencia">Resistência</option>
                                <option value="outro">Outro</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="descricaoMeta">Descrição</label>
                        <input id="descricaoMeta" placeholder="Descrição detalhada" required>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="valorAlvoMeta">Valor Alvo</label>
                            <input id="valorAlvoMeta" type="number" step="0.01" placeholder="Valor alvo" required>
                        </div>
                        <div class="form-group">
                            <label for="unidadeMeta">Unidade</label>
                            <input id="unidadeMeta" placeholder="kg, cm, etc." required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="idAlunoMeta">ID do Aluno</label>
                            <input id="idAlunoMeta" type="number" placeholder="ID do aluno" required>
                        </div>
                        <div class="form-group">
                            <label for="dataLimiteMeta">Data Limite</label>
                            <input id="dataLimiteMeta" type="date" required>
                        </div>
                    </div>
                    <button type="submit" class="success">Criar Meta</button>
                    <button type="button" onclick="hideForm('metaForm')">Cancelar</button>
                </form>
                
                <ul id="metas"></ul>
            </section>
            
            <section>
                <h2>Avaliações Físicas</h2>
                <button onclick="loadAvaliacoes()">Listar Avaliações</button>
                
                <form id="avaliacaoForm" class="hidden" onsubmit="criarAvaliacao(event)">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="idAlunoAvaliacao">ID do Aluno</label>
                            <input id="idAlunoAvaliacao" type="number" placeholder="ID do aluno" required>
                        </div>
                        <div class="form-group">
                            <label for="idPersonalAvaliacao">ID do Personal</label>
                            <input id="idPersonalAvaliacao" type="number" placeholder="ID do personal" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="pesoAvaliacao">Peso (kg)</label>
                            <input id="pesoAvaliacao" type="number" step="0.01" placeholder="Peso em kg" required>
                        </div>
                        <div class="form-group">
                            <label for="massaMuscularAvaliacao">Massa Muscular (kg)</label>
                            <input id="massaMuscularAvaliacao" type="number" step="0.01" placeholder="Massa muscular" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="alturaAvaliacao">Altura (m)</label>
                            <input id="alturaAvaliacao" type="number" step="0.01" placeholder="Altura em metros">
                        </div>
                        <div class="form-group">
                            <label for="gorduraAvaliacao">% Gordura</label>
                            <input id="gorduraAvaliacao" type="number" step="0.01" placeholder="Percentual de gordura">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="musculoAvaliacao">% Músculo</label>
                            <input id="musculoAvaliacao" type="number" step="0.01" placeholder="Percentual de músculo">
                        </div>
                        <div class="form-group">
                            <label for="dataAvaliacao">Data da Avaliação</label>
                            <input id="dataAvaliacao" type="date" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="circunferenciasAvaliacao">Circunferências</label>
                        <input id="circunferenciasAvaliacao" placeholder="Ex: Braço: 30cm, Cintura: 80cm" required>
                    </div>
                    <div class="form-group">
                        <label for="observacoesAvaliacao">Observações</label>
                        <input id="observacoesAvaliacao" placeholder="Observações importantes" required>
                    </div>
                    <button type="submit" class="success">Criar Avaliação</button>
                    <button type="button" onclick="hideForm('avaliacaoForm')">Cancelar</button>
                </form>
                
                <ul id="avaliacoes"></ul>
            </section>
            
            <section>
                <h2>Treinos</h2>
                <button onclick="loadTreinos()">Listar Treinos</button>
                
                <form id="treinoForm" class="hidden" onsubmit="criarTreino(event)">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nomeTreino">Nome</label>
                            <input id="nomeTreino" placeholder="Nome do treino" required>
                        </div>
                        <div class="form-group">
                            <label for="objetivoTreino">Objetivo</label>
                            <input id="objetivoTreino" placeholder="Objetivo do treino" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="categoriaTreino">Categoria</label>
                            <input id="categoriaTreino" placeholder="Categoria do treino" required>
                        </div>
                        <div class="form-group">
                            <label for="duracaoPadraoTreino">Duração Padrão (min)</label>
                            <input id="duracaoPadraoTreino" type="number" placeholder="Duração em minutos" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idPersonalCriadorTreino">ID do Personal Criador</label>
                        <input id="idPersonalCriadorTreino" type="number" placeholder="ID do personal" required>
                    </div>
                    <button type="submit" class="success">Criar Treino</button>
                    <button type="button" onclick="hideForm('treinoForm')">Cancelar</button>
                </form>
                
                <ul id="treinos"></ul>
            </section>
            
            <section>
                <h2>Registros de Treino</h2>
                <button onclick="loadRegistros()">Listar Registros</button>
                <form id="registroForm" class="hidden" onsubmit="criarRegistro(event)">
                    <div class="form-row">
                        <div class="form-group" style="">
                            <label for="idUsuarioRegistro"><b>ID do Usuário</b></label>
                            <input id="idUsuarioRegistro" type="number" required placeholder="Ex: 1">
                        </div>
                        <div class="form-group" style="">
                            <label for="idTreinoRegistro"><b>ID do Treino</b></label>
                            <input id="idTreinoRegistro" type="number" required placeholder="Ex: 2">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group" style="">
                            <label for="dataRegistro"><b>Data</b></label>
                            <input id="dataRegistro" type="date" required>
                        </div>
                        <div class="form-group" style="">
                            <label for="caloriasQueimadasRegistro"><b>Calorias Queimadas</b></label>
                            <input id="caloriasQueimadasRegistro" type="number" step="0.01" required placeholder="Ex: 350.5">
                        </div>
                    </div>
                    <div style="display:flex; gap:10px;">
                        <button type="submit" class="success">Criar Registro</button>
                        <button type="button" onclick="hideForm('registroForm')">Cancelar</button>
                    </div>
                </form>
                <ul id="registros"></ul>
            </section>
            
            <section>
                <h2>Usuário-Treino</h2>
                <button onclick="loadUsuarioTreinos()">Listar Relações</button>
                <form id="usuarioTreinoForm" class="hidden" onsubmit="criarUsuarioTreino(event)">
                    <div class="form-row">
                        <div class="form-group" style="">
                            <label for="idUsuarioUT"><b>ID do Usuário</b></label>
                            <input id="idUsuarioUT" type="number" required placeholder="Ex: 1">
                        </div>
                        <div class="form-group" style="">
                            <label for="idTreinoUT"><b>ID do Treino</b></label>
                            <input id="idTreinoUT" type="number" required placeholder="Ex: 2">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group" style="">
                            <label for="ativoUT"><b>Ativo</b></label>
                            <select id="ativoUT" required>
                                <option value="true">Sim</option>
                                <option value="false">Não</option>
                            </select>
                        </div>
                        <div class="form-group" style="">
                            <label for="dataAssociacaoUT"><b>Data de Associação</b></label>
                            <input id="dataAssociacaoUT" type="date" required>
                        </div>
                    </div>
                    <div style="display:flex; gap:10px;">
                        <button type="submit" class="success">Criar Relação</button>
                        <button type="button" onclick="hideForm('usuarioTreinoForm')">Cancelar</button>
                    </div>
                </form>
                <ul id="usuariotreinos"></ul>
            </section>
            <section>
                <h2>Treino-Exercício</h2>
                <button onclick="loadTreinoExercicios()">Listar Relações</button>
           <form id="treinoExercicioForm" class="hidden" onsubmit="criarTreinoExercicio(event)">
                <div class="form-row">
                    <div class="form-group" ">
                        <label for="idTreinoTE"><b>ID do Treino</b></label>
                        <input id="idTreinoTE" type="number" required placeholder="Ex: 1">
                    </div>
                    <div class="form-group" ">
                        <label for="idExercicioTE"><b>ID do Exercício</b></label>
                        <input id="idExercicioTE" type="number" required placeholder="Ex: 5">
                    </div>
                    <div class="form-group" ">
                        <label for="ordemTE"><b>Ordem</b></label>
                        <input id="ordemTE" type="number" required placeholder="Ex: 1">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group" ">
                        <label for="seriesTE"><b>Séries</b></label>
                        <input id="seriesTE" type="number" required placeholder="Ex: 3">
                    </div>
                    <div class="form-group">
                        <label for="repeticoesTE"><b>Repetições</b></label>
                        <input id="repeticoesTE" type="number" required placeholder="Ex: 12">
                    </div>
                </div>
                <div style="display:flex; gap:10px;">
                    <button type="submit" class="success">Criar Relação</button>
                    <button type="button" onclick="hideForm('treinoExercicioForm')">Cancelar</button>
                </div>
            </form>
                <ul id="treinoexercicios"></ul>
            </section>
        </div>

        <script>
            // Funções utilitárias
            function showAlert(message, type = 'success') {
                const alert = document.getElementById('alert');
                alert.textContent = message;
                alert.className = `alert ${type}`;
                alert.style.display = 'block';
                
                setTimeout(() => {
                    alert.style.display = 'none';
                }, 5000);
            }
            
            function showForm(formId) {
                document.getElementById(formId).classList.remove('hidden');
            }
            
            function hideForm(formId) {
                document.getElementById(formId).classList.add('hidden');
            }
            
            function formatDate(dateString) {
                if (!dateString) return '-';
                const date = new Date(dateString);
                return date.toLocaleDateString('pt-BR');
            }
            
            // Usuários
            async function loadUsuarios() {
                try {
                    const resp = await fetch('/usuarios/');
                    if (!resp.ok) throw new Error('Erro ao carregar usuários');
                    
                    const data = await resp.json();
                    const ul = document.getElementById('usuarios');
                    ul.innerHTML = '';
                    
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhum usuário encontrado</li>';
                        return;
                    }
                    
                    data.forEach(u => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>${u.nome}</strong> (${u.email})<br>
                                <small>CPF: ${u.cpf} | Nasc: ${formatDate(u.data_nascimento)} | Tipo: ${u.tipo}</small>
                            </div>
                            <div class="btn-group">
                                <button class="danger" onclick="deletarUsuario(${u.id}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    
                    showAlert('Usuários carregados com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function deletarUsuario(id, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar este usuário?')) return;
                
                try {
                    const resp = await fetch(`/usuarios/${id}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar usuário');
                    
                    loadUsuarios();
                    showAlert('Usuário deletado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function criarUsuario(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/usuarios/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            nome: document.getElementById('nomeUsuario').value,
                            email: document.getElementById('emailUsuario').value,
                            cpf: document.getElementById('cpfUsuario').value,
                            data_nascimento: document.getElementById('dataNascUsuario').value,
                            tipo: document.getElementById('tipoUsuario').value
                        })
                    });
                    
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar usuário');
                    }
                    
                    loadUsuarios();
                    e.target.reset();
                    hideForm('usuarioForm');
                    showAlert('Usuário criado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Músculos
            async function loadMusculos() {
                try {
                    const resp = await fetch('/musculos/');
                    if (!resp.ok) throw new Error('Erro ao carregar músculos');
                    
                    const data = await resp.json();
                    const ul = document.getElementById('musculos');
                    ul.innerHTML = '';
                    
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhum músculo encontrado</li>';
                        return;
                    }
                    
                    data.forEach(m => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>${m.nome}</strong> (${m.grupo_muscular})
                            </div>
                            <div class="btn-group">
                                <button class="danger" onclick="deletarMusculo(${m.id}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    
                    showAlert('Músculos carregados com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function deletarMusculo(id, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar este músculo?')) return;
                
                try {
                    const resp = await fetch(`/musculos/${id}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar músculo');
                    
                    loadMusculos();
                    showAlert('Músculo deletado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function criarMusculo(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/musculos/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            nome: document.getElementById('nomeMusculo').value,
                            grupo_muscular: document.getElementById('grupoMuscular').value
                        })
                    });
                    
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar músculo');
                    }
                    
                    loadMusculos();
                    e.target.reset();
                    hideForm('musculoForm');
                    showAlert('Músculo criado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Equipamentos
            async function loadEquipamentos() {
                try {
                    const resp = await fetch('/equipamentos/');
                    if (!resp.ok) throw new Error('Erro ao carregar equipamentos');
                    
                    const data = await resp.json();
                    const ul = document.getElementById('equipamentos');
                    ul.innerHTML = '';
                    
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhum equipamento encontrado</li>';
                        return;
                    }
                    
                    data.forEach(e => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>${e.nome}</strong><br>
                                <small>${e.descricao || 'Sem descrição'} | Status: ${e.status}</small>
                            </div>
                            <div class="btn-group">
                                <button class="danger" onclick="deletarEquipamento(${e.id}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    
                    showAlert('Equipamentos carregados com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function deletarEquipamento(id, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar este equipamento?')) return;
                
                try {
                    const resp = await fetch(`/equipamentos/${id}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar equipamento');
                    
                    loadEquipamentos();
                    showAlert('Equipamento deletado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function criarEquipamento(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/equipamentos/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            nome: document.getElementById('nomeEquipamento').value,
                            descricao: document.getElementById('descEquipamento').value,
                            status: document.getElementById('statusEquipamento').value
                        })
                    });
                    
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar equipamento');
                    }
                    
                    loadEquipamentos();
                    e.target.reset();
                    hideForm('equipamentoForm');
                    showAlert('Equipamento criado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Exercícios
            async function loadExercicios() {
                try {
                    const resp = await fetch('/exercicios/');
                    if (!resp.ok) throw new Error('Erro ao carregar exercícios');
                    
                    const data = await resp.json();
                    const ul = document.getElementById('exercicios');
                    ul.innerHTML = '';
                    
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhum exercício encontrado</li>';
                        return;
                    }
                    
                    data.forEach(e => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>${e.nome}</strong> - ${e.categoria}<br>
                                <small>Dificuldade: ${e.nivel_dificuldade} | Equipamento: ${e.id_equipamento || 'Nenhum'} | Instruções: ${e.instrucoes || 'Nenhuma'}</small>
                            </div>
                            <div class="btn-group">
                                <button class="danger" onclick="deletarExercicio(${e.id}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    
                    showAlert('Exercícios carregados com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function deletarExercicio(id, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar este exercício?')) return;
                
                try {
                    const resp = await fetch(`/exercicios/${id}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar exercício');
                    
                    loadExercicios();
                    showAlert('Exercício deletado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function criarExercicio(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/exercicios/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            nome: document.getElementById('nomeExercicio').value,
                            categoria: document.getElementById('categoriaExercicio').value,
                            id_equipamento: document.getElementById('idEquipamentoExercicio').value || null,
                            instrucoes: document.getElementById('instrucoesExercicio').value,
                            nivel_dificuldade: document.getElementById('nivelDificuldadeExercicio').value
                        })
                    });
                    
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar exercício');
                    }
                    
                    loadExercicios();
                    e.target.reset();
                    hideForm('exercicioForm');
                    showAlert('Exercício criado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Metas
            async function loadMetas() {
                try {
                    const resp = await fetch('/metas/');
                    if (!resp.ok) throw new Error('Erro ao carregar metas');
                    
                    const data = await resp.json();
                    const ul = document.getElementById('metas');
                    ul.innerHTML = '';
                    
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhuma meta encontrada</li>';
                        return;
                    }
                    
                    data.forEach(m => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>${m.titulo}</strong> - ${m.tipo}<br>
                                <small>Aluno: ${m.id_aluno} | Valor: ${m.valor_alvo} ${m.unidade} | Limite: ${formatDate(m.data_limite)}</small><br>
                                ${m.descricao}
                            </div>
                            <div class="btn-group">
                                <button class="danger" onclick="deletarMeta(${m.id}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    
                    showAlert('Metas carregadas com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function deletarMeta(id, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar esta meta?')) return;
                
                try {
                    const resp = await fetch(`/metas/${id}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar meta');
                    
                    loadMetas();
                    showAlert('Meta deletada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function criarMeta(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/metas/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            titulo: document.getElementById('tituloMeta').value,
                            descricao: document.getElementById('descricaoMeta').value,
                            tipo: document.getElementById('tipoMeta').value,
                            valor_alvo: parseFloat(document.getElementById('valorAlvoMeta').value),
                            unidade: document.getElementById('unidadeMeta').value,
                            id_aluno: parseInt(document.getElementById('idAlunoMeta').value),
                            data_limite: document.getElementById('dataLimiteMeta').value
                        })
                    });
                    
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar meta');
                    }
                    
                    loadMetas();
                    e.target.reset();
                    hideForm('metaForm');
                    showAlert('Meta criada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Avaliações Físicas
            async function loadAvaliacoes() {
                try {
                    const resp = await fetch('/avaliacoes/');
                    if (!resp.ok) throw new Error('Erro ao carregar avaliações');
                    
                    const data = await resp.json();
                    const ul = document.getElementById('avaliacoes');
                    ul.innerHTML = '';
                    
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhuma avaliação encontrada</li>';
                        return;
                    }
                    
                    data.forEach(a => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>Avaliação #${a.id}</strong><br>
                                <small>Aluno: ${a.id_aluno} | Personal: ${a.id_personal} | Data: ${formatDate(a.data_avaliacao)}</small><br>
                                Peso: ${a.peso}kg | Massa Muscular: ${a.massa_muscular}kg<br>
                                ${a.altura ? `Altura: ${a.altura}m | ` : ''}
                                ${a.percentual_gordura ? `Gordura: ${a.percentual_gordura}% | ` : ''}
                                ${a.percentual_musculo ? `Músculo: ${a.percentual_musculo}%` : ''}
                            </div>
                            <div class="btn-group">
                                <button class="danger" onclick="deletarAvaliacao(${a.id}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    
                    showAlert('Avaliações carregadas com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            function hideForm(formId) {
                const form = document.getElementById(formId);
                form.classList.add('hidden');
                // Limpa todos os campos do formulário ao cancelar
                if (form && typeof form.reset === 'function') {
                    form.reset();
                }
            }
            async function deletarAvaliacao(id, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar esta avaliação?')) return;
                
                try {
                    const resp = await fetch(`/avaliacoes/${id}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar avaliação');
                    
                    loadAvaliacoes();
                    showAlert('Avaliação deletada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function criarAvaliacao(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/avaliacoes/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            id_aluno: parseInt(document.getElementById('idAlunoAvaliacao').value),
                            id_personal: parseInt(document.getElementById('idPersonalAvaliacao').value),
                            peso: parseFloat(document.getElementById('pesoAvaliacao').value),
                            massa_muscular: parseFloat(document.getElementById('massaMuscularAvaliacao').value),
                            altura: document.getElementById('alturaAvaliacao').value ? parseFloat(document.getElementById('alturaAvaliacao').value) : null,
                            percentual_gordura: document.getElementById('gorduraAvaliacao').value ? parseFloat(document.getElementById('gorduraAvaliacao').value) : null,
                            percentual_musculo: document.getElementById('musculoAvaliacao').value ? parseFloat(document.getElementById('musculoAvaliacao').value) : null,
                            circunferencias: document.getElementById('circunferenciasAvaliacao').value,
                            observacoes: document.getElementById('observacoesAvaliacao').value,
                            data_avaliacao: document.getElementById('dataAvaliacao').value
                        })
                    });
                    
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar avaliação');
                    }
                    
                    loadAvaliacoes();
                    e.target.reset();
                    hideForm('avaliacaoForm');
                    showAlert('Avaliação criada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Treinos
            async function loadTreinos() {
                try {
                    const resp = await fetch('/treinos/');
                    if (!resp.ok) throw new Error('Erro ao carregar treinos');
                    
                    const data = await resp.json();
                    const ul = document.getElementById('treinos');
                    ul.innerHTML = '';
                    
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhum treino encontrado</li>';
                        return;
                    }
                    
                    data.forEach(t => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>${t.nome}</strong> - ${t.objetivo}<br>
                                <small>Categoria: ${t.categoria} | Duração: ${t.duracao_padrao}min | Personal: ${t.id_personal_criador}</small>
                            </div>
                            <div class="btn-group">
                                <button onclick="editarTreinoForm(${t.id}, '${t.nome}', '${t.objetivo}', '${t.categoria}', event)">Editar</button>
                                <button class="danger" onclick="deletarTreino(${t.id}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    
                    showAlert('Treinos carregados com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function deletarTreino(id, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar este treino?')) return;
                
                try {
                    const resp = await fetch(`/treinos/${id}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar treino');
                    
                    loadTreinos();
                    showAlert('Treino deletado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            function editarTreinoForm(id, nome, objetivo, categoria, event) {
                event.stopPropagation();
                
                const novoNome = prompt('Nome:', nome);
                if (novoNome === null) return;
                
                const novoObjetivo = prompt('Objetivo:', objetivo);
                if (novoObjetivo === null) return;
                
                const novaCategoria = prompt('Categoria:', categoria);
                if (novaCategoria === null) return;
                
                atualizarTreino(id, novoNome, novoObjetivo, novaCategoria);
            }
            
            async function atualizarTreino(id, nome, objetivo, categoria) {
                try {
                    const resp = await fetch(`/treinos/${id}`, {
                        method: 'PUT',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({nome, objetivo, categoria})
                    });
                    
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao atualizar treino');
                    }
                    
                    loadTreinos();
                    showAlert('Treino atualizado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            async function criarTreino(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/treinos/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            nome: document.getElementById('nomeTreino').value,
                            objetivo: document.getElementById('objetivoTreino').value,
                            categoria: document.getElementById('categoriaTreino').value,
                            duracao_padrao: parseInt(document.getElementById('duracaoPadraoTreino').value),
                            id_personal_criador: parseInt(document.getElementById('idPersonalCriadorTreino').value)
                        })
                    });
                    
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar treino');
                    }
                    
                    loadTreinos();
                    e.target.reset();
                    hideForm('treinoForm');
                    showAlert('Treino criado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Registros de Treino
            async function loadRegistros() {
                try {
                    const resp = await fetch('/registros_treino/');
                    if (!resp.ok) throw new Error('Erro ao carregar registros');
                    const data = await resp.json();
                    const ul = document.getElementById('registros');
                    ul.innerHTML = '';
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhum registro encontrado</li>';
                        return;
                    }
                    data.forEach(r => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>Usuário ${r.id_usuario}</strong> - Treino ${r.id_treino}<br>
                                <small>Calorias: ${r.calorias_queimadas} | Data: ${formatDate(r.data_registro)}</small>
                            </div>
                            <div class="btn-group">
                                <button onclick="editarRegistroForm(${r.id}, ${r.id_usuario}, ${r.id_treino}, '${r.data_registro}', ${r.calorias_queimadas}, event)">Editar</button>
                                <button class="danger" onclick="deletarRegistro(${r.id}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    showAlert('Registros carregados com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            async function criarRegistro(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/registros_treino/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            id_usuario: parseInt(document.getElementById('idUsuarioRegistro').value),
                            id_treino: parseInt(document.getElementById('idTreinoRegistro').value),
                            data_registro: document.getElementById('dataRegistro').value,
                            calorias_queimadas: parseFloat(document.getElementById('caloriasQueimadasRegistro').value)
                        })
                    });
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(JSON.stringify(error.detail ?? error, null, 2));
                    }
                    loadRegistros();
                    e.target.reset();
                    hideForm('registroForm');
                    showAlert('Registro criado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            async function deletarRegistro(id, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar este registro?')) return;
                try {
                    const resp = await fetch(`/registros_treino/${id}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar registro');
                    loadRegistros();
                    showAlert('Registro deletado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            function editarRegistroForm(id, id_usuario, id_treino, data_registro, calorias_queimadas, event) {
                event.stopPropagation();
                const novoUsuario = prompt('ID do Usuário:', id_usuario);
                if (novoUsuario === null) return;
                const novoTreino = prompt('ID do Treino:', id_treino);
                if (novoTreino === null) return;
                const novaData = prompt('Data (YYYY-MM-DD):', data_registro ? data_registro.substring(0, 10) : '');
                if (novaData === null) return;
                const novasCalorias = prompt('Calorias Queimadas:', calorias_queimadas);
                if (novasCalorias === null) return;
                atualizarRegistro(id, parseInt(novoUsuario), parseInt(novoTreino), novaData, parseFloat(novasCalorias));
            }

            async function atualizarRegistro(id, id_usuario, id_treino, data_registro, calorias_queimadas) {
                try {
                    const resp = await fetch(`/registros_treino/${id}`, {
                        method: 'PUT',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({id_usuario, id_treino, data_registro, calorias_queimadas})
                    });
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao atualizar registro');
                    }
                    loadRegistros();
                    showAlert('Registro atualizado com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
                        
            // Usuário-Treino
            async function loadUsuarioTreinos() {
                try {
                    const resp = await fetch('/usuario_treinos/');
                    if (!resp.ok) throw new Error('Erro ao carregar relações usuário-treino');
                    const data = await resp.json();
                    const ul = document.getElementById('usuariotreinos');
                    ul.innerHTML = '';
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhuma relação encontrada</li>';
                        return;
                    }
                    data.forEach(ut => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>Usuário ${ut.id_usuario}</strong> - Treino ${ut.id_treino}<br>
                                <small>Ativo: ${ut.ativo ? 'Sim' : 'Não'} | Data: ${formatDate(ut.data_associacao)}</small>
                            </div>
                            <div class="btn-group">
                                <button onclick="editarUsuarioTreinoForm(${ut.id_usuario}, ${ut.id_treino}, ${ut.ativo}, '${ut.data_associacao}', event)">Editar</button>
                                <button class="danger" onclick="deletarUsuarioTreino(${ut.id_usuario}, ${ut.id_treino}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    showAlert('Relações usuário-treino carregadas com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            async function criarUsuarioTreino(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/usuario_treinos/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            id_usuario: parseInt(document.getElementById('idUsuarioUT').value),
                            id_treino: parseInt(document.getElementById('idTreinoUT').value),
                            ativo: document.getElementById('ativoUT').value === "true",
                            data_associacao: document.getElementById('dataAssociacaoUT').value
                        })
                    });
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar relação');
                    }
                    loadUsuarioTreinos();
                    e.target.reset();
                    hideForm('usuarioTreinoForm');
                    showAlert('Relação criada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            async function deletarUsuarioTreino(id_usuario, id_treino, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar esta relação?')) return;
                try {
                    const resp = await fetch(`/usuario_treinos/${id_usuario}/${id_treino}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar relação');
                    loadUsuarioTreinos();
                    showAlert('Relação deletada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            function editarUsuarioTreinoForm(id_usuario, id_treino, ativo, data_associacao, event) {
                event.stopPropagation();
                const novoAtivo = confirm('Marcar como ativo? (OK = Sim, Cancelar = Não)') ? true : false;
                const novaData = prompt('Data de Associação (YYYY-MM-DD):', data_associacao ? data_associacao.substring(0, 10) : '');
                if (novaData === null) return;
                atualizarUsuarioTreino(id_usuario, id_treino, novoAtivo, novaData);
            }

            async function atualizarUsuarioTreino(id_usuario, id_treino, ativo, data_associacao) {
                try {
                    const resp = await fetch(`/usuario_treinos/${id_usuario}/${id_treino}`, {
                        method: 'PUT',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({ativo, data_associacao})
                    });
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao atualizar relação');
                    }
                    loadUsuarioTreinos();
                    showAlert('Relação atualizada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Treino-Exercício
            async function loadTreinoExercicios() {
                try {
                    const resp = await fetch('/treino_exercicios/');
                    if (!resp.ok) throw new Error('Erro ao carregar relações treino-exercício');
                    const data = await resp.json();
                    const ul = document.getElementById('treinoexercicios');
                    ul.innerHTML = '';
                    if (data.length === 0) {
                        ul.innerHTML = '<li>Nenhuma relação encontrada</li>';
                        return;
                    }
                    data.forEach(te => {
                        const li = document.createElement('li');
                        li.innerHTML = `
                            <div>
                                <strong>Treino ${te.id_treino}</strong> - Exercício ${te.id_exercicio}<br>
                                <small>Ordem: ${te.ordem} | Séries: ${te.series} | Repetições: ${te.repeticoes}</small>
                            </div>
                            <div class="btn-group">
                                <button onclick="editarTreinoExercicioForm(${te.id_treino}, ${te.id_exercicio}, ${te.ordem}, ${te.series}, ${te.repeticoes}, event)">Editar</button>
                                <button class="danger" onclick="deletarTreinoExercicio(${te.id_treino}, ${te.id_exercicio}, ${te.ordem}, event)">Deletar</button>
                            </div>
                        `;
                        ul.appendChild(li);
                    });
                    showAlert('Relações treino-exercício carregadas com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            async function criarTreinoExercicio(e) {
                e.preventDefault();
                try {
                    const resp = await fetch('/treino_exercicios/', {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({
                            id_treino: parseInt(document.getElementById('idTreinoTE').value),
                            id_exercicio: parseInt(document.getElementById('idExercicioTE').value),
                            ordem: parseInt(document.getElementById('ordemTE').value),
                            series: parseInt(document.getElementById('seriesTE').value),
                            repeticoes: parseInt(document.getElementById('repeticoesTE').value)
                        })
                    });
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao criar relação');
                    }
                    loadTreinoExercicios();
                    e.target.reset();
                    hideForm('treinoExercicioForm');
                    showAlert('Relação criada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            async function deletarTreinoExercicio(id_treino, id_exercicio, ordem, event) {
                event.stopPropagation();
                if (!confirm('Tem certeza que deseja deletar esta relação?')) return;
                try {
                    const resp = await fetch(`/treino_exercicios/${id_treino}/${id_exercicio}/${ordem}`, {method: 'DELETE'});
                    if (!resp.ok) throw new Error('Erro ao deletar relação');
                    loadTreinoExercicios();
                    showAlert('Relação deletada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }

            function editarTreinoExercicioForm(id_treino, id_exercicio, ordem, series, repeticoes, event) {
                event.stopPropagation();
                const novasSeries = prompt('Séries:', series);
                if (novasSeries === null) return;
                const novasRepeticoes = prompt('Repetições:', repeticoes);
                if (novasRepeticoes === null) return;
                atualizarTreinoExercicio(id_treino, id_exercicio, ordem, parseInt(novasSeries), parseInt(novasRepeticoes));
            }

            async function atualizarTreinoExercicio(id_treino, id_exercicio, ordem, series, repeticoes) {
                try {
                    const resp = await fetch(`/treino_exercicios/${id_treino}/${id_exercicio}/${ordem}`, {
                        method: 'PUT',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({series, repeticoes})
                    });
                    if (!resp.ok) {
                        const error = await resp.json();
                        throw new Error(error.detail || 'Erro ao atualizar relação');
                    }
                    loadTreinoExercicios();
                    showAlert('Relação atualizada com sucesso');
                } catch (error) {
                    showAlert(error.message, 'error');
                }
            }
            
            // Inicialização
            document.addEventListener('DOMContentLoaded', () => {
                // Esconde todos os forms inicialmente
                document.querySelectorAll('form').forEach(form => {
                    form.classList.add('hidden');
                });
            });
        </script>
    </body>
    </html>
    """