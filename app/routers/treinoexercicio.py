from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from models.treinoexercicio import TreinoExercicio
from schemas.treinoexercicio import (
    TreinoExercicioCreate,
    TreinoExercicioRead,
    TreinoExercicioUpdate,
)

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter(prefix="/treino_exercicios", tags=["Treino Exercício"])

@router.post("/", response_model=TreinoExercicioRead)
def criar_treino_exercicio(te: TreinoExercicioCreate, db: Session = Depends(get_db)):
    db_te = TreinoExercicio(**te.dict())
    db.add(db_te)
    db.commit()
    db.refresh(db_te)
    return db_te

@router.get("/", response_model=List[TreinoExercicioRead])
def listar_treino_exercicios(db: Session = Depends(get_db)):
    return db.query(TreinoExercicio).all()

@router.get("/{id_treino}/{id_exercicio}/{ordem}", response_model=TreinoExercicioRead)
def obter_treino_exercicio(id_treino: int, id_exercicio: int, ordem: int, db: Session = Depends(get_db)):
    te = db.query(TreinoExercicio).filter_by(
        id_treino=id_treino, id_exercicio=id_exercicio, ordem=ordem
    ).first()
    if not te:
        raise HTTPException(status_code=404, detail="TreinoExercicio não encontrado")
    return te

@router.put("/{id_treino}/{id_exercicio}/{ordem}", response_model=TreinoExercicioRead)
def atualizar_treino_exercicio(
    id_treino: int,
    id_exercicio: int,
    ordem: int,
    te_update: TreinoExercicioUpdate,
    db: Session = Depends(get_db)
):
    te = db.query(TreinoExercicio).filter_by(
        id_treino=id_treino, id_exercicio=id_exercicio, ordem=ordem
    ).first()
    if not te:
        raise HTTPException(status_code=404, detail="TreinoExercicio não encontrado")
    for key, value in te_update.dict(exclude_unset=True).items():
        setattr(te, key, value)
    db.commit()
    db.refresh(te)
    return te

@router.delete("/{id_treino}/{id_exercicio}/{ordem}")
def deletar_treino_exercicio(id_treino: int, id_exercicio: int, ordem: int, db: Session = Depends(get_db)):
    te = db.query(TreinoExercicio).filter_by(
        id_treino=id_treino, id_exercicio=id_exercicio, ordem=ordem
    ).first()
    if not te:
        raise HTTPException(status_code=404, detail="TreinoExercicio não encontrado")
    db.delete(te)
    db.commit()
    return {"ok": True}
