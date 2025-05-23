from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from models.exercicio import Exercicio
from schemas.exercicio import ExercicioCreate, ExercicioRead, ExercicioUpdate
from models.registrotreino import RegistroTreino
from schemas.registrotreino import RegistroTreinoRead

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter(prefix="/exercicios", tags=["Exercícios"])

@router.post("/", response_model=ExercicioRead)
def criar_exercicio(exercicio: ExercicioCreate, db: Session = Depends(get_db)):
    db_exercicio = Exercicio(**exercicio.dict())
    db.add(db_exercicio)
    db.commit()
    db.refresh(db_exercicio)
    return db_exercicio

@router.get("/", response_model=List[ExercicioRead])
def listar_exercicios(db: Session = Depends(get_db)):
    return db.query(Exercicio).all()

@router.get("/{exercicio_id}", response_model=ExercicioRead)
def obter_exercicio(exercicio_id: int, db: Session = Depends(get_db)):
    exercicio = db.query(Exercicio).filter(Exercicio.id == exercicio_id).first()
    if not exercicio:
        raise HTTPException(status_code=404, detail="Exercício não encontrado")
    return exercicio

@router.put("/{exercicio_id}", response_model=ExercicioRead)
def atualizar_exercicio(exercicio_id: int, exercicio_update: ExercicioUpdate, db: Session = Depends(get_db)):
    exercicio = db.query(Exercicio).filter(Exercicio.id == exercicio_id).first()
    if not exercicio:
        raise HTTPException(status_code=404, detail="Exercício não encontrado")
    for key, value in exercicio_update.dict(exclude_unset=True).items():
        setattr(exercicio, key, value)
    db.commit()
    db.refresh(exercicio)
    return exercicio

@router.delete("/{exercicio_id}")
def deletar_exercicio(exercicio_id: int, db: Session = Depends(get_db)):
    exercicio = db.query(Exercicio).filter(Exercicio.id == exercicio_id).first()
    if not exercicio:
        raise HTTPException(status_code=404, detail="Exercício não encontrado")
    db.delete(exercicio)
    db.commit()
    return {"ok": True}

from datetime import datetime, timedelta

@router.get("/usuario/{usuario_id}/ultima-semana", response_model=List[RegistroTreinoRead])
def listar_registros_ultima_semana(usuario_id: int, db: Session = Depends(get_db)):
    uma_semana_atras = datetime.now() - timedelta(days=7)
    registros = (
        db.query(RegistroTreino)
        .filter(RegistroTreino.id_usuario == usuario_id, RegistroTreino.data_inicio >= uma_semana_atras)
        .all()
    )
    if not registros:
        raise HTTPException(status_code=404, detail="Nenhum registro encontrado na última semana.")
    return registros