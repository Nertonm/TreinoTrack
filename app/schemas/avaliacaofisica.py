from pydantic import BaseModel
from typing import Optional
from datetime import datetime

class AvaliacaoFisicaBase(BaseModel):
    id_aluno: int
    id_personal: int
    data_avaliacao: datetime
    peso: Optional[float]
    altura: Optional[int]
    percentual_gordura: Optional[float]
    massa_muscular: Optional[float]
    circunferencias: Optional[str]
    observacoes: Optional[str]

class AvaliacaoFisicaCreate(AvaliacaoFisicaBase):
    pass

class AvaliacaoFisicaRead(AvaliacaoFisicaBase):
    id: int

    class Config:
        orm_mode = True
