from pydantic import BaseModel
from typing import Optional
from enum import Enum

class NivelDificuldade(str, Enum):
    iniciante = "iniciante"
    intermediario = "intermediario"
    avancado = "avancado"

class ExercicioBase(BaseModel):
    nome: str
    categoria: str
    id_equipamento: Optional[int]
    instrucoes: Optional[str]
    nivel_dificuldade: Optional[NivelDificuldade] = NivelDificuldade.iniciante

class ExercicioCreate(ExercicioBase):
    pass

class ExercicioUpdate(ExercicioBase):
    pass

class ExercicioRead(ExercicioBase):
    id: int

    class Config:
        orm_mode = True
