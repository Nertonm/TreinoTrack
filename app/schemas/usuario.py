from pydantic import BaseModel, EmailStr
from datetime import date, datetime
from enum import Enum
from typing import Optional

# Enum para tipos de usuário
class TipoUsuario(str, Enum):
    aluno = "aluno"
    personal = "personal"

# Modelo base para o usuário
class UsuarioBase(BaseModel):
    nome: str
    email: EmailStr
    cpf: str
    data_nascimento: date
    tipo: TipoUsuario  # Mantenha o TipoUsuario aqui para garantir que seja um dos valores do Enum

class UsuarioCreate(BaseModel):
    nome: str
    email: str
    cpf: str
    data_nascimento: date
    tipo: TipoUsuario

    class Config:
        from_attributes = True

# Modelo para leitura do usuário
class UsuarioRead(BaseModel):
    id: int
    nome: str
    email: str
    cpf: str
    data_nascimento: date
    tipo: str
    data_cadastro: datetime  # Alterado para datetime

    class Config:
        from_attributes = True

# Modelo para atualização do usuário
class UsuarioUpdate(BaseModel):
    nome: Optional[str] = None
    email: Optional[str] = None
    senha: Optional[str] = None
