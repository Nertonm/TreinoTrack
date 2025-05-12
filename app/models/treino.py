from sqlalchemy import Column, Integer, String, DateTime, ForeignKey
from database import Base
from datetime import datetime

class Treino(Base):
    __tablename__ = "TREINO"

    id = Column("ID_TREINO", Integer, primary_key=True, autoincrement=True)
    nome = Column("NOME", String(100), nullable=False)
    duracao_padrao = Column("DURACAO_PADRAO", Integer, nullable=False)
    objetivo = Column("OBJETIVO", String(100), nullable=False)
    categoria = Column("CATEGORIA", String(50), nullable=False)
    id_personal_criador = Column("ID_PERSONAL_CRIADOR", Integer, ForeignKey("USUARIO.ID_USUARIO"))
    data_criacao = Column("DATA_CRIACAO", DateTime, default=datetime.utcnow)