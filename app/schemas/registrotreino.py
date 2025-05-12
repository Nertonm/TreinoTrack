from pydantic import BaseModel
from typing import Optional
from datetime import datetime

class RegistroTreinoBase(BaseModel):
    id_usuario: int
    id_treino: int
    data_inicio: datetime
    data_fim: datetime
    calorias_queimadas: float
    feedback: Optional[str]

class RegistroTreinoCreate(RegistroTreinoBase):
    pass

class RegistroTreinoUpdate(RegistroTreinoBase):
    pass

class RegistroTreinoRead(RegistroTreinoBase):
    id: int

    class Config:
        orm_mode = True
