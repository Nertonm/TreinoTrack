from pydantic import BaseModel

class MusculoBase(BaseModel):
    nome: str
    grupo_muscular: str

class MusculoCreate(MusculoBase):
    pass

class MusculoUpdate(MusculoBase):
    pass

class MusculoRead(MusculoBase):
    id: int

    class Config:
        orm_mode = True
