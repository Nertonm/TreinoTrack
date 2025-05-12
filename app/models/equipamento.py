from sqlalchemy import Column, Integer, String, Text, Enum as SqlEnum
from database import Base
from enum import Enum

class StatusEquipamento(str, Enum):
    ativo = "ativo"
    inativo = "inativo"
    manutencao = "manutencao"

class Equipamento(Base):
    __tablename__ = "EQUIPAMENTO"

    id = Column("ID_EQUIPAMENTO", Integer, primary_key=True, autoincrement=True)
    nome = Column("NOME", String(100), nullable=False)
    descricao = Column("DESCRICAO", Text)
    status = Column("STATUS", SqlEnum(StatusEquipamento), default=StatusEquipamento.ativo)