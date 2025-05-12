from pydantic import BaseModel
from typing import Optional
from datetime import datetime

class UsuarioTreinoBase(BaseModel):
    id_usuario: int
    id_treino: int
    data_associacao: Optional[datetime] = None
    ativo: Optional[bool] = True

class UsuarioTreinoCreate(UsuarioTreinoBase):
    pass

class UsuarioTreinoUpdate(BaseModel):
    data_associacao: Optional[datetime]
    ativo: Optional[bool]

class UsuarioTreinoRead(UsuarioTreinoBase):
    class Config:
        orm_mode = True
