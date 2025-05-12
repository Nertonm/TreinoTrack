from pydantic import BaseModel
from typing import Optional
from datetime import date, datetime
from enum import Enum

# Enum para tipos de meta
class TipoMeta(str, Enum):
    perda_peso = "perda_peso"
    ganho_massa = "ganho_massa"
    resistencia = "resistencia"
    outro = "outro"

# Schema base para meta
class MetaBase(BaseModel):
    id_aluno: int
    titulo: str
    descricao: str
    tipo: TipoMeta
    valor_alvo: float
    unidade: str
    data_limite: Optional[date] = None

# Schema para criação de meta
class MetaCreate(MetaBase):
    pass

# Schema para atualização de meta
class MetaUpdate(BaseModel):
    titulo: Optional[str] = None
    descricao: Optional[str] = None
    tipo: Optional[TipoMeta] = None
    valor_alvo: Optional[float] = None
    unidade: Optional[str] = None
    data_limite: Optional[date] = None
    concluida: Optional[bool] = None
    data_conclusao: Optional[datetime] = None

# Schema para leitura de meta
class MetaRead(MetaBase):
    id: int
    data_criacao: datetime
    concluida: bool
    data_conclusao: Optional[datetime] = None

    class Config:
        orm_mode = True
