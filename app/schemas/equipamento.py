from pydantic import BaseModel
from typing import Optional
from enum import Enum

class StatusEquipamento(str, Enum):
    ativo = "ativo"
    inativo = "inativo"
    manutencao = "manutencao"

class EquipamentoBase(BaseModel):
    nome: str
    descricao: Optional[str]
    status: Optional[StatusEquipamento] = StatusEquipamento.ativo

class EquipamentoCreate(EquipamentoBase):
    pass

class EquipamentoRead(EquipamentoBase):
    id: int

    class Config:
        orm_mode = True
