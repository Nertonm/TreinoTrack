from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from database import SessionLocal
from typing import List
from models.equipamento import Equipamento
from schemas.equipamento import EquipamentoCreate, EquipamentoRead

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

router = APIRouter(prefix="/equipamentos", tags=["Equipamentos"])

@router.post("/", response_model=EquipamentoRead)
def criar_equipamento(equipamento: EquipamentoCreate, db: Session = Depends(get_db)):
    db_equipamento = Equipamento(**equipamento.dict())
    db.add(db_equipamento)
    db.commit()
    db.refresh(db_equipamento)
    return db_equipamento

@router.get("/", response_model=List[EquipamentoRead])
def listar_equipamentos(db: Session = Depends(get_db)):
    return db.query(Equipamento).all()

@router.get("/{equipamento_id}", response_model=EquipamentoRead)
def obter_equipamento(equipamento_id: int, db: Session = Depends(get_db)):
    equipamento = db.query(Equipamento).filter(Equipamento.id == equipamento_id).first()
    if not equipamento:
        raise HTTPException(status_code=404, detail="Equipamento não encontrado")
    return equipamento


@router.put("/{equipamento_id}", response_model=EquipamentoRead)
def atualizar_equipamento(
    equipamento_id: int,
    equipamento_update: EquipamentoCreate,
    db: Session = Depends(get_db)
):
    equipamento = db.query(Equipamento).filter(Equipamento.id == equipamento_id).first()
    if not equipamento:
        raise HTTPException(status_code=404, detail="Equipamento não encontrado")
    for key, value in equipamento_update.dict(exclude_unset=True).items():
        setattr(equipamento, key, value)
    db.commit()
    db.refresh(equipamento)
    return equipamento