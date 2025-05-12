from sqlalchemy import Column, Integer, DateTime, Float, Text, ForeignKey
from database import Base

class RegistroTreino(Base):
    __tablename__ = "REGISTRO_TREINO"

    id = Column("ID_REGISTRO", Integer, primary_key=True, autoincrement=True)
    id_usuario = Column("ID_USUARIO", Integer, ForeignKey("USUARIO.ID_USUARIO"), nullable=False)
    id_treino = Column("ID_TREINO", Integer, ForeignKey("TREINO.ID_TREINO"), nullable=False)
    data_inicio = Column("DATA_INICIO", DateTime, nullable=False)
    data_fim = Column("DATA_FIM", DateTime, nullable=False)
    calorias_queimadas = Column("CALORIAS_QUEIMADAS", Float, nullable=False)
    feedback = Column("FEEDBACK", Text)