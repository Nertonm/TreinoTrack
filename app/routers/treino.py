from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from models.treino import Treino
from schemas.treino import TreinoCreate, TreinoRead, TreinoUpdate

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter(prefix="/treinos", tags=["Treinos"])

@router.post("/", response_model=TreinoRead)
def criar_treino(treino: TreinoCreate, db: Session = Depends(get_db)):
    db_treino = Treino(**treino.dict())
    db.add(db_treino)
    db.commit()
    db.refresh(db_treino)
    return db_treino

@router.get("/", response_model=List[TreinoRead])
def listar_treinos(db: Session = Depends(get_db)):
    return db.query(Treino).all()

@router.get("/{treino_id}", response_model=TreinoRead)
def obter_treino(treino_id: int, db: Session = Depends(get_db)):
    treino = db.query(Treino).filter(Treino.id == treino_id).first()
    if not treino:
        raise HTTPException(status_code=404, detail="Treino não encontrado")
    return treino

@router.put("/{treino_id}", response_model=TreinoRead)
def atualizar_treino(treino_id: int, treino_update: TreinoUpdate, db: Session = Depends(get_db)):
    treino = db.query(Treino).filter(Treino.id == treino_id).first()
    if not treino:
        raise HTTPException(status_code=404, detail="Treino não encontrado")
    for key, value in treino_update.dict(exclude_unset=True).items():
        setattr(treino, key, value)
    db.commit()
    db.refresh(treino)
    return treino

@router.delete("/{treino_id}")
def deletar_treino(treino_id: int, db: Session = Depends(get_db)):
    treino = db.query(Treino).filter(Treino.id == treino_id).first()
    if not treino:
        raise HTTPException(status_code=404, detail="Treino não encontrado")
    db.delete(treino)
    db.commit()
    return {"ok": True}
