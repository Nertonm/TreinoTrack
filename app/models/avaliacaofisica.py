from sqlalchemy import Column, Integer, DateTime, DECIMAL, Text, ForeignKey
from database import Base

class AvaliacaoFisica(Base):
    __tablename__ = "AVALIACAO_FISICA"

    id = Column("ID_AVALIACAO", Integer, primary_key=True, autoincrement=True)
    id_aluno = Column("ID_ALUNO", Integer, ForeignKey("USUARIO.ID_USUARIO"), nullable=False)
    id_personal = Column("ID_PERSONAL", Integer, ForeignKey("USUARIO.ID_USUARIO"), nullable=False)
    data_avaliacao = Column("DATA_AVALIACAO", DateTime, nullable=False)
    peso = Column("PESO", DECIMAL(5,2))
    altura = Column("ALTURA", Integer)
    percentual_gordura = Column("PERCENTUAL_GORDURA", DECIMAL(5,2))
    massa_muscular = Column("MASSA_MUSCULAR", DECIMAL(5,2))
    circunferencias = Column("CIRCUNFERENCIAS", Text)
    observacoes = Column("OBSERVACOES", Text)