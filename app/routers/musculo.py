from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from models.musculo import Musculo
from schemas.musculo import MusculoCreate, MusculoRead, MusculoUpdate

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter(prefix="/musculos", tags=["Músculos"])

@router.post("/", response_model=MusculoRead)
def criar_musculo(musculo: MusculoCreate, db: Session = Depends(get_db)):
    db_musculo = Musculo(**musculo.dict())
    db.add(db_musculo)
    db.commit()
    db.refresh(db_musculo)
    return db_musculo

@router.get("/", response_model=List[MusculoRead])
def listar_musculos(db: Session = Depends(get_db)):
    return db.query(Musculo).all()

@router.get("/{musculo_id}", response_model=MusculoRead)
def obter_musculo(musculo_id: int, db: Session = Depends(get_db)):
    musculo = db.query(Musculo).filter(Musculo.id == musculo_id).first()
    if not musculo:
        raise HTTPException(status_code=404, detail="Músculo não encontrado")
    return musculo

@router.put("/{musculo_id}", response_model=MusculoRead)
def atualizar_musculo(musculo_id: int, musculo_update: MusculoUpdate, db: Session = Depends(get_db)):
    musculo = db.query(Musculo).filter(Musculo.id == musculo_id).first()
    if not musculo:
        raise HTTPException(status_code=404, detail="Músculo não encontrado")
    for key, value in musculo_update.dict(exclude_unset=True).items():
        setattr(musculo, key, value)
    db.commit()
    db.refresh(musculo)
    return musculo

@router.delete("/{musculo_id}")
def deletar_musculo(musculo_id: int, db: Session = Depends(get_db)):
    musculo = db.query(Musculo).filter(Musculo.id == musculo_id).first()
    if not musculo:
        raise HTTPException(status_code=404, detail="Músculo não encontrado")
    db.delete(musculo)
    db.commit()
    return {"ok": True}
