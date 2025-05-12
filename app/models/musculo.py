from sqlalchemy import Column, Integer, String
from database import Base

class Musculo(Base):
    __tablename__ = "MUSCULO"

    id = Column("ID_MUSCULO", Integer, primary_key=True, autoincrement=True)
    nome = Column("NOME", String(100), nullable=False)
    grupo_muscular = Column("GRUPO_MUSCULAR", String(50), nullable=False)