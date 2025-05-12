from sqlalchemy import Column, Integer, String, Date, DateTime, Enum as SqlEnum
from database import Base
from datetime import datetime
from schemas.usuario import TipoUsuario

class Usuario(Base):
    __tablename__ = "USUARIO"

    id = Column("ID_USUARIO", Integer, primary_key=True, autoincrement=True)
    nome = Column("NOME", String(100), nullable=False)
    email = Column("EMAIL", String(100), unique=True, nullable=False)
    cpf = Column("CPF", String(11), unique=True, nullable=False)
    data_nascimento = Column("DATA_NASCIMENTO", Date, nullable=False)
    tipo = Column("TIPO", SqlEnum(TipoUsuario), nullable=False)
    data_cadastro = Column("DATA_CADASTRO", DateTime, default=datetime.utcnow)