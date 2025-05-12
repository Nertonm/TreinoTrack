from sqlalchemy import Column, Integer, String, Text, ForeignKey
from database import Base

class TreinoExercicio(Base):
    __tablename__ = "TREINO_EXERCICIO"
    id_treino = Column("ID_TREINO", Integer, ForeignKey("TREINO.ID_TREINO"), primary_key=True)
    id_exercicio = Column("ID_EXERCICIO", Integer, ForeignKey("EXERCICIO.ID_EXERCICIO"), primary_key=True)
    ordem = Column("ORDEM", Integer, primary_key=True)
    series = Column("SERIES", Integer, nullable=False)
    repeticoes = Column("REPETICOES", String(20), nullable=False)
    descanso = Column("DESCANSO", Integer)
    observacoes = Column("OBSERVACOES", Text)