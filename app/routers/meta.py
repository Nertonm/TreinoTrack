from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from schemas.meta import MetaRead, MetaCreate, MetaUpdate
from models.meta import *
from models.usuario import Usuario

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Roteador de metas
router = APIRouter(prefix="/metas", tags=["Metas"])

# Função para criar uma meta
@router.post("/", response_model=MetaRead)
def criar_meta(meta: MetaCreate, db: Session = Depends(get_db)):
    # Verifica se o aluno existe
    aluno = db.query(Usuario).filter(Usuario.id == meta.id_aluno).first()
    if not aluno:
        raise HTTPException(status_code=400, detail="Aluno não encontrado")
    db_meta = Meta(**meta.dict())
    db.add(db_meta)
    db.commit()
    db.refresh(db_meta)
    return db_meta

# Função para listar todas as metas
@router.get("/", response_model=List[MetaRead])
def listar_metas(db: Session = Depends(get_db)):
    return db.query(Meta).all()

# Função para obter uma meta específica
@router.get("/{meta_id}", response_model=MetaRead)
def obter_meta(meta_id: int, db: Session = Depends(get_db)):
    meta = db.query(Meta).filter(Meta.id == meta_id).first()
    if not meta:
        raise HTTPException(status_code=404, detail="Meta não encontrada")
    return meta

# Função para atualizar uma meta
@router.put("/{meta_id}", response_model=MetaRead)
def atualizar_meta(meta_id: int, meta_update: MetaUpdate, db: Session = Depends(get_db)):
    meta = db.query(Meta).filter(Meta.id == meta_id).first()
    if not meta:
        raise HTTPException(status_code=404, detail="Meta não encontrada")
    for key, value in meta_update.dict(exclude_unset=True).items():
        setattr(meta, key, value)
    db.commit()
    db.refresh(meta)
    return meta

# Função para deletar uma meta
@router.delete("/{meta_id}")
def deletar_meta(meta_id: int, db: Session = Depends(get_db)):
    meta = db.query(Meta).filter(Meta.id == meta_id).first()
    if not meta:
        raise HTTPException(status_code=404, detail="Meta não encontrada")
    db.delete(meta)
    db.commit()
    return {"ok": True}
