from sqlalchemy import Column, Integer, DateTime, Boolean, ForeignKey
from database import Base
from datetime import datetime

class UsuarioTreino(Base):
    __tablename__ = "USUARIO_TREINO"
    id_usuario = Column("ID_USUARIO", Integer, ForeignKey("USUARIO.ID_USUARIO"), primary_key=True)
    id_treino = Column("ID_TREINO", Integer, ForeignKey("TREINO.ID_TREINO"), primary_key=True)
    data_associacao = Column("DATA_ASSOCIACAO", DateTime, default=datetime.utcnow)
    ativo = Column("ATIVO", Boolean, default=True)