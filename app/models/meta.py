from sqlalchemy import Column, Integer, String, Text, Enum as SqlEnum, DECIMAL, DateTime, Date, Boolean, ForeignKey
from database import Base
from enum import Enum
from datetime import datetime

class TipoMeta(str, Enum):
    perda_peso = "perda_peso"
    ganho_massa = "ganho_massa"
    resistencia = "resistencia"
    outro = "outro"

class Meta(Base):
    __tablename__ = "META"

    id = Column("ID_META", Integer, primary_key=True, autoincrement=True)
    id_aluno = Column("ID_ALUNO", Integer, ForeignKey("USUARIO.ID_USUARIO"), nullable=False)
    titulo = Column("TITULO", String(100), nullable=False)
    descricao = Column("DESCRICAO", Text, nullable=False)
    tipo = Column("TIPO", SqlEnum(TipoMeta), nullable=False)
    valor_alvo = Column("VALOR_ALVO", DECIMAL(10,2), nullable=False)
    unidade = Column("UNIDADE", String(20), nullable=False)
    data_criacao = Column("DATA_CRIACAO", DateTime, default=datetime.utcnow)
    data_limite = Column("DATA_LIMITE", Date)
    concluida = Column("CONCLUIDA", Boolean, default=False)
    data_conclusao = Column("DATA_CONCLUSAO", DateTime)