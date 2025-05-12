from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from models.usuariotreino import UsuarioTreino
from schemas.usuariotreino import UsuarioTreinoCreate, UsuarioTreinoRead, UsuarioTreinoUpdate

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter(prefix="/usuario_treinos", tags=["Usuário Treino"])

@router.post("/", response_model=UsuarioTreinoRead)
def criar_usuario_treino(ut: UsuarioTreinoCreate, db: Session = Depends(get_db)):
    db_ut = UsuarioTreino(**ut.dict())
    db.add(db_ut)
    db.commit()
    db.refresh(db_ut)
    return db_ut

@router.get("/", response_model=List[UsuarioTreinoRead])
def listar_usuario_treinos(db: Session = Depends(get_db)):
    return db.query(UsuarioTreino).all()

@router.get("/{id_usuario}/{id_treino}", response_model=UsuarioTreinoRead)
def obter_usuario_treino(id_usuario: int, id_treino: int, db: Session = Depends(get_db)):
    ut = db.query(UsuarioTreino).filter_by(id_usuario=id_usuario, id_treino=id_treino).first()
    if not ut:
        raise HTTPException(status_code=404, detail="Associação não encontrada")
    return ut

@router.put("/{id_usuario}/{id_treino}", response_model=UsuarioTreinoRead)
def atualizar_usuario_treino(
    id_usuario: int,
    id_treino: int,
    ut_update: UsuarioTreinoUpdate,
    db: Session = Depends(get_db)
):
    ut = db.query(UsuarioTreino).filter_by(id_usuario=id_usuario, id_treino=id_treino).first()
    if not ut:
        raise HTTPException(status_code=404, detail="Associação não encontrada")
    for key, value in ut_update.dict(exclude_unset=True).items():
        setattr(ut, key, value)
    db.commit()
    db.refresh(ut)
    return ut

@router.delete("/{id_usuario}/{id_treino}")
def deletar_usuario_treino(id_usuario: int, id_treino: int, db: Session = Depends(get_db)):
    ut = db.query(UsuarioTreino).filter_by(id_usuario=id_usuario, id_treino=id_treino).first()
    if not ut:
        raise HTTPException(status_code=404, detail="Associação não encontrada")
    db.delete(ut)
    db.commit()
    return {"ok": True}
