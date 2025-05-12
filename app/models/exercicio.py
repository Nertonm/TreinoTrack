from sqlalchemy import Column, Integer, String, Text, Enum as SqlEnum, ForeignKey
from database import Base
from enum import Enum

class NivelDificuldade(str, Enum):
    iniciante = "iniciante"
    intermediario = "intermediario"
    avancado = "avancado"

class Exercicio(Base):
    __tablename__ = "EXERCICIO"

    id = Column("ID_EXERCICIO", Integer, primary_key=True, autoincrement=True)
    nome = Column("NOME", String(100), nullable=False)
    categoria = Column("CATEGORIA", String(50), nullable=False)
    id_equipamento = Column("ID_EQUIPAMENTO", Integer, ForeignKey("EQUIPAMENTO.ID_EQUIPAMENTO"))
    instrucoes = Column("INSTRUCOES", Text)
    nivel_dificuldade = Column("NIVEL_DIFICULDADE", SqlEnum(NivelDificuldade), default=NivelDificuldade.iniciante)