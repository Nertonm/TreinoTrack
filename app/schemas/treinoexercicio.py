from pydantic import BaseModel
from typing import Optional

class TreinoExercicioBase(BaseModel):
    id_treino: int
    id_exercicio: int
    ordem: int
    series: int
    repeticoes: str
    descanso: Optional[int]
    observacoes: Optional[str]

class TreinoExercicioCreate(TreinoExercicioBase):
    pass

class TreinoExercicioUpdate(BaseModel):
    series: Optional[int]
    repeticoes: Optional[str]
    descanso: Optional[int]
    observacoes: Optional[str]

class TreinoExercicioRead(TreinoExercicioBase):
    class Config:
            orm_mode = True
