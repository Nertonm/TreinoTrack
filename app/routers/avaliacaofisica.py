from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from models.avaliacaofisica import AvaliacaoFisica
from schemas.avaliacaofisica import AvaliacaoFisicaCreate, AvaliacaoFisicaRead

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter(prefix="/avaliacoes", tags=["Avaliações Físicas"])

@router.post("/", response_model=AvaliacaoFisicaRead)
def criar_avaliacao(avaliacao: AvaliacaoFisicaCreate, db: Session = Depends(get_db)):
    db_avaliacao = AvaliacaoFisica(**avaliacao.dict())
    db.add(db_avaliacao)
    db.commit()
    db.refresh(db_avaliacao)
    return db_avaliacao

@router.get("/", response_model=List[AvaliacaoFisicaRead])
def listar_avaliacoes(db: Session = Depends(get_db)):
    return db.query(AvaliacaoFisica).all()

@router.get("/{avaliacao_id}", response_model=AvaliacaoFisicaRead)
def obter_avaliacao(avaliacao_id: int, db: Session = Depends(get_db)):
    avaliacao = db.query(AvaliacaoFisica).filter(AvaliacaoFisica.id == avaliacao_id).first()
    if not avaliacao:
        raise HTTPException(status_code=404, detail="Avaliação não encontrada")
    return avaliacao
