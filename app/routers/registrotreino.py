from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from models.registrotreino import RegistroTreino
from schemas.registrotreino import RegistroTreinoCreate, RegistroTreinoRead, RegistroTreinoUpdate

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter(prefix="/registros_treino", tags=["Registros de Treino"])

@router.post("/", response_model=RegistroTreinoRead)
def criar_registro_treino(registro: RegistroTreinoCreate, db: Session = Depends(get_db)):
    db_registro = RegistroTreino(**registro.dict())
    db.add(db_registro)
    db.commit()
    db.refresh(db_registro)
    return db_registro

@router.get("/", response_model=List[RegistroTreinoRead])
def listar_registros_treino(db: Session = Depends(get_db)):
    return db.query(RegistroTreino).all()

@router.get("/{registro_id}", response_model=RegistroTreinoRead)
def obter_registro_treino(registro_id: int, db: Session = Depends(get_db)):
    registro = db.query(RegistroTreino).filter(RegistroTreino.id == registro_id).first()
    if not registro:
        raise HTTPException(status_code=404, detail="Registro de treino não encontrado")
    return registro

@router.put("/{registro_id}", response_model=RegistroTreinoRead)
def atualizar_registro_treino(registro_id: int, registro_update: RegistroTreinoUpdate, db: Session = Depends(get_db)):
    registro = db.query(RegistroTreino).filter(RegistroTreino.id == registro_id).first()
    if not registro:
        raise HTTPException(status_code=404, detail="Registro de treino não encontrado")
    for key, value in registro_update.dict(exclude_unset=True).items():
        setattr(registro, key, value)
    db.commit()
    db.refresh(registro)
    return registro

@router.delete("/{registro_id}")
def deletar_registro_treino(registro_id: int, db: Session = Depends(get_db)):
    registro = db.query(RegistroTreino).filter(RegistroTreino.id == registro_id).first()
    if not registro:
        raise HTTPException(status_code=404, detail="Registro de treino não encontrado")
    db.delete(registro)
    db.commit()
    return {"ok": True}
