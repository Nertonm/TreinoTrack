from pydantic import BaseModel
from typing import Optional
from datetime import datetime

class TreinoBase(BaseModel):
    nome: str
    duracao_padrao: int
    objetivo: str
    categoria: str
    id_personal_criador: Optional[int]

class TreinoCreate(TreinoBase):
    pass

class TreinoUpdate(TreinoBase):
    pass

class TreinoRead(TreinoBase):
    id: int
    data_criacao: datetime

    class Config:
        orm_mode = True
